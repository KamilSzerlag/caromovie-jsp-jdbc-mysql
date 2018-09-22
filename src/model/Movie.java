package model;

public class Movie {

    int id;
    String title;
    String year;
    boolean watched = false;

    public Movie(int id, String title, String year) {
        this.id = id;
        this.title = title;
        this.year = year;
    }

    public Movie(String title, String year) {
        this.title = title;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public boolean isWatched() {
        return watched;
    }

    public void setWatched(boolean watched) {
        this.watched = watched;
    }
}

