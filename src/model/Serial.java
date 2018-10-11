package model;

public class Series {
    private String title;
    private int season;
    private int numberOfEpisodes;

    public Series(String title, String season, int numberOfEpisodes) {
        this.title = title;
        this.numberOfEpisodes = numberOfEpisodes;
    }

    private class Episode {

        private String titleOfEpisode;
        private int episodeNumber;

    }

}
