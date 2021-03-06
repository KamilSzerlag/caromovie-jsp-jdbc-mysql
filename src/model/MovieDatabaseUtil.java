package model;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class MovieDatabaseUtil {

    private DataSource dataSource;
    private static MovieDatabaseUtil instance = new MovieDatabaseUtil();

    private MovieDatabaseUtil() {
    }

    public static MovieDatabaseUtil getInstance() {
        return instance;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    //TODO getting movies list from DB
    public List<Movie> getMovies(){
        List<Movie> movies = new LinkedList<>();

        Connection conn = null;
        PreparedStatement myStm = null;
        ResultSet rst = null;
        String SQL = "SELECT * FROM movie";
        try{
            conn = dataSource.getConnection();
            myStm = conn.prepareStatement(SQL);

            rst = myStm.executeQuery();
            Movie movie = null;
            while (rst.next()) {
                movie = new Movie(rst.getInt("id"), rst.getString("title"), rst.getString("year"));
                movie.setWatched(rst.getBoolean("watched"));
                movies.add(movie);
            }
        }catch (SQLException e){
            System.out.println("Can't get movie list from DB");
        }finally {
            close(myStm,conn,rst);
        }
        return movies;
    }

    //TODO close()
    private void close(PreparedStatement preparedStatement, Connection connection, ResultSet resultSet) {
        try {
            if (connection != null)
                connection.close();

            if (preparedStatement != null)
                preparedStatement.close();

            if (resultSet != null)
                resultSet.close();

        } catch (SQLException e) {
            System.out.println("Can't close connection. " + e.getMessage());
        }
    }

    //TODO addMovie()
    public void addMovie(Movie movie) {
        //TODO Creating connection
        Connection conn = null;
        PreparedStatement myStm = null;
        String SQL = "INSERT INTO movie ( title, year ) VALUES(?, ?)";
        //We can't use 'example ' sign in mySQL queries
        try {
            conn = dataSource.getConnection();
            System.out.println("DB connected!");
            myStm = conn.prepareStatement(SQL);

            myStm.setString(1, movie.getTitle());
            myStm.setString(2, movie.getYear());

            myStm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Movie can't be added. " + e.getMessage());
        } finally {
            close(myStm, conn, null);
        }
    }

    //TODO getMovie()
    public Movie getMovie(int id) throws Exception {
        Connection conn = null;
        PreparedStatement myStm = null;
        ResultSet rst = null;
        String SQL = "SELECT * FROM movie WHERE movie.id=?";
        Movie movie = null;
        try {
            conn = dataSource.getConnection();
            myStm = conn.prepareStatement(SQL);

            myStm.setInt(1, id);
            rst = myStm.executeQuery();
            if (rst.next()) {
                movie = new Movie(rst.getInt("id"), rst.getString("title"), rst.getString("year"));
                movie.setWatched(rst.getBoolean("watched"));
            } else movie = null;
        } catch (SQLException e) {
            System.out.println("Can't get movie" + e.getMessage());
        } finally {
            close(myStm, conn, rst);
        }
        System.out.println("Movie: " + movie.getTitle() + movie.getYear());
        return movie;
    }

    //TODO Updating movies state in DB
    public void updateMovie(Movie movie) {
        Connection conn = null;
        PreparedStatement myStm = null;
        String SQL = "UPDATE movie SET movie.watched='1' WHERE movie.id= ?";
        try {
            conn = dataSource.getConnection();

            myStm = conn.prepareStatement(SQL);
            myStm.setInt(1, movie.getId());
            myStm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Can't update. " + e.getMessage());
        }finally {
            close(myStm,conn,null);
        }
    }

    //TODO deleteMovie()
    public void deleteMovie(Movie movie){
        Connection conn= null;
        PreparedStatement myStm = null;
        String SQL = "DELETE FROM movie WHERE movie.id= ?";
        try {
            conn = dataSource.getConnection();

            myStm = conn.prepareStatement(SQL);
            myStm.setInt(1, movie.getId());
            myStm.executeUpdate();
        }catch (SQLException e){
            System.out.println("Can't delete. "+e.getMessage());
        }finally {
            close(myStm,conn,null);
        }
    }
}
