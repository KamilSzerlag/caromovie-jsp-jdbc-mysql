package test;

import feature.TheMovieDbApiUtil;
import info.movito.themoviedbapi.model.MovieDb;
import model.MovieDatabaseUtil;

import java.util.List;

import static org.junit.Assert.*;

public class TheMovieDbApiUtilTest {

    @org.junit.Test
    public void getListFoundMovies() {

       List<MovieDb> movieDbs = TheMovieDbApiUtil.getInstance().getListFoundMovies("Batman",2014);
        for (MovieDb m : movieDbs ){
            System.out.println(m.getTitle());
        }
    }
    @org.junit.Test
    public void parserIntTest(){
        String stringNumber = "2014";
        int number_int = Integer.parseInt(stringNumber);
        assertEquals(2014,number_int,0);
    }
}