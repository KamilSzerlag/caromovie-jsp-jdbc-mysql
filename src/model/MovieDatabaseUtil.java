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

    private List<Movie> MovieList = new LinkedList<>();


    //TODO close
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

    //TODO addMovie
    public void addMovie(Movie movie) {
        //TODO Creating connection
        Connection conn = null;
        PreparedStatement myStm = null;
    //W mySQL nie mozemy stosowac ' ' przy zapytaniach
        try {
            String SQL = "INSERT INTO movie ( title, year ) VALUES(?, ?)";
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
    //TODO deleteMovie
}
