package feature;

import com.sun.javafx.binding.StringFormatter;
import model.Movie;
import model.MovieDatabaseUtil;

public class ProgressBar {
    private double allElements;
    private double doneElements;

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
            if(m.isWatched())
                numberOfWatchedMovies++;
        }
        return numberOfWatchedMovies;
    }

    private double getAllElements() {
        return allElements;
    }

    private void setAllElements(int allElements) {
        this.allElements = allElements;
    }

    private double getDoneElements() {
        return doneElements;
    }

    private void setDoneElements(int doneElements) {
        this.doneElements = doneElements;
    }

    public String progressCalculatorMovies() {
        setAllElements(getNumberOfMovies());
        setDoneElements(getNumberOfDoneMovies());

        return  String.format("%.0f",(getDoneElements()/getAllElements())*100);
    }
}
