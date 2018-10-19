package controller;

import feature.ProgressBar;
import model.Movie;
import model.MovieDatabaseUtil;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet("/ServletMovieController")
public class ServletMovieController extends HttpServlet {

    @Resource(name = "jdbc/movie_user_database")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();
        MovieDatabaseUtil.getInstance().setDataSource(dataSource);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

//            TODO updateProgressBar method to removing
            if (request.getParameter("command").equals("UPDATE_PROGRESS"))
                updateProgressBar(request, response);


        } catch (Exception e) {
            e.getMessage();
        }

    }

    //TODO Update doGet method for different methods used in JSP file
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            if (request.getParameter("command")==null)
                moviesList(request, response);
            if (request.getParameter("command").equals("ADD"))
                addMovie(request, response);
            if (request.getParameter("command").equals("DELETE"))
                deleteMovie(request, response);
            if (request.getParameter("command").equals("UPDATE"))
                updateStatus(request, response);

        } catch (Exception e) {
            e.getMessage();
        }

    }

    private void addMovie(HttpServletRequest request, HttpServletResponse response) {
        String title = request.getParameter("title");
        String year = request.getParameter("year");

        Movie movie = new Movie(title, year);
        System.out.println(movie.getTitle() + movie.getYear());
        MovieDatabaseUtil.getInstance().addMovie(movie);
        try {
            moviesList(request, response);
        } catch (Exception e) {
            System.out.println("Can't reach Movies List");
        }
    }

    private void moviesList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Movie> movies = MovieDatabaseUtil.getInstance().getMovies();

//        Progress bar added to movie list
        ProgressBar progressBar = new ProgressBar();
        String progress = progressBar.progressCalculatorMovies();
        request.setAttribute("PROGRESS", progress);
        request.setAttribute("MOVIE_LIST", movies);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/movie-list.jsp");
        dispatcher.forward(request, response);
    }


    private void updateStatus(HttpServletRequest request, HttpServletResponse response) throws Exception {
//  TODO changing Parameter to ID for easier and better movie identification
        try {
            Movie movie = MovieDatabaseUtil.getInstance().getMovie(Integer.parseInt(request.getParameter("id")));
            System.out.println("SERVLET UPDATE STATUS METHOD: Movie title: " + movie.getTitle());
            MovieDatabaseUtil.getInstance().updateMovie(movie);
        } catch (Exception e) {
            System.out.println("Can't get movie from database" + e.getMessage());
        }
        moviesList(request, response);
    }

    private void deleteMovie(HttpServletRequest request, HttpServletResponse response) throws Exception {
//  TODO changing Parameter to ID for easier and better movie identification
        try {
            Movie movie = MovieDatabaseUtil.getInstance().getMovie(Integer.parseInt(request.getParameter("id")));
            System.out.println("SERVLET DELETE METHOD : Movie title: " + movie.getTitle());
            MovieDatabaseUtil.getInstance().deleteMovie(movie);
        } catch (Exception e) {
            System.out.println("Can't delete movie from database" + e.getMessage());
        }
        moviesList(request, response);
    }

    private void updateProgressBar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ProgressBar progressBar = new ProgressBar();
        String progress = progressBar.progressCalculatorMovies();
        List<Movie> movies = MovieDatabaseUtil.getInstance().getMovies();
        request.setAttribute("MOVIE_LIST", movies);
        request.setAttribute("PROGRESS", progress);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/movie-list.jsp");
        dispatcher.forward(request, response);

    }

}
