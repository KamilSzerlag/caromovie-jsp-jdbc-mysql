package feature;

import info.movito.themoviedbapi.TmdbAccount;
import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.TmdbSearch;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.core.MovieResultsPage;
import info.movito.themoviedbapi.model.people.Person;

public class TheMovieDbApiUtil {

    private static TheMovieDbApiUtil instance = new TheMovieDbApiUtil();
    private static final String API_KEY = "8f71f02c156b4125bea53271de869735";
    private static TmdbApi tmdbApi;

    private TheMovieDbApiUtil() {

        this.tmdbApi = new TmdbApi(API_KEY);
    }

    public static TheMovieDbApiUtil getInstance() {
        return instance;
    }
}
