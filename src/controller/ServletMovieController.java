package controller;

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

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
        moviesList(request,response);
    }catch (Exception e){
        e.getMessage();
    }

    }

    private void addMovie(HttpServletRequest request, HttpServletResponse response) {
        String title = request.getParameter("title");
        String year = request.getParameter("year");

        Movie movie = new Movie(title,year);
        System.out.println(movie.getTitle() + movie.getYear());
        MovieDatabaseUtil.getInstance().addMovie(movie);
    }

    private void moviesList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Movie> movies = MovieDatabaseUtil.getInstance().getMovies();

        request.setAttribute("MOVIELIST",movies);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/movie-list.jsp");
        dispatcher.forward(request, response);
    }

}
