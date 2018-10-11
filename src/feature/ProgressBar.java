package feature;

import model.Movie;
import model.MovieDatabaseUtil;

public class ProgressBar {
    private int allElements;
    private int doneElements;

    public ProgressBar() {
        this.allElements=0;
        this.doneElements=0;
    }

    private int getNumberOfMovies() {
       return MovieDatabaseUtil.getInstance().getMovies().size();
    }

    private int getNumberOfDoneMovies() {
        int numberOfWatchedMovies=0;
        for (Movie m: MovieDatabaseUtil.getInstance().getMovies()) {
            if(m.isWatched());
                numberOfWatchedMovies++;
        }
        return numberOfWatchedMovies;
    }

    private int getAllElements() {
        return allElements;
    }

    private void setAllElements(int allElements) {
        this.allElements = allElements;
    }

    private int getDoneElements() {
        return doneElements;
    }

    private void setDoneElements(int doneElements) {
        this.doneElements = doneElements;
    }

    public int progressCalculatorMovies() {
        setAllElements(getNumberOfMovies());
        setDoneElements(getNumberOfDoneMovies());

        return (getNumberOfDoneMovies()/getNumberOfMovies())*100;
    }
}
