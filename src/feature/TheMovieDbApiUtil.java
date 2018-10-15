package feature;


import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.TmdbSearch;
import info.movito.themoviedbapi.model.Artwork;
import info.movito.themoviedbapi.model.ArtworkType;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.MovieImages;

import java.util.List;

public class TheMovieDbApiUtil {

    private static TheMovieDbApiUtil instance = new TheMovieDbApiUtil();
    private static final String API_KEY = "8f71f02c156b4125bea53271de869735";
    public static final String LANGUAGE = "en";
    private static TmdbApi tmdbApi;

    private TheMovieDbApiUtil() {

        this.tmdbApi = new TmdbApi(API_KEY);
    }

    public static TheMovieDbApiUtil getInstance() {
        return instance;
    }

    public List<MovieDb> getListFoundMovies(String title, int year) {
        TmdbSearch foundMovies = tmdbApi.getSearch();
        return foundMovies.searchMovie(title, year, LANGUAGE, true, 0).getResults();
    }

    public int getMovieId(MovieDb movie) {
        return movie.getId();
    }

    public String getMovieTitle(MovieDb movie) {
        TmdbMovies tempMovie = tmdbApi.getMovies();
        return tempMovie.getMovie(getMovieId(movie), LANGUAGE).getTitle();
    }

    public List<Artwork> getMovieImage(MovieDb movie) {
        TmdbMovies tempMovie = tmdbApi.getMovies();
        return tempMovie.getMovie(getMovieId(movie),LANGUAGE).getImages(ArtworkType.POSTER);
    }



}
