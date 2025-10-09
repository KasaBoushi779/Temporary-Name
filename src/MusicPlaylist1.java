import java.util.ArrayList;

/**
 * A class with some implementations of musicPlaylist methods meant to show
 * viability of the design.
 */
public class MusicPlaylist1 {

    /**
     * An internal class containing song data, with methods to set and get
     * parameters (title, artist, album, length).
     */
    public final class Song {

        /*
         * Private members--------------------------------
         */

        /**
         * Song title.
         */
        private String title;

        /**
         * Song artist.
         */
        private String artist;

        /**
         * The album the song is from.
         */
        private String album;

        /**
         * Song length.
         */
        private String length;

        /*
         * Methods------------------------------------------
         */

        /**
         * Returns {@code this.title}.
         *
         * @return The title of the song
         */
        public String title() {
            return this.title;
        }

        /**
         * Returns {@code this.artist}.
         *
         * @return The artist of the song
         */
        public String artist() {
            return this.artist;
        }

        /**
         * Returns {@code this.album}.
         *
         * @return The album of the song
         */
        public String album() {
            return this.album;
        }

        /**
         * Returns {@code this.length}.
         *
         * @return The length of the song
         */
        public String length() {
            return this.length;
        }

        /**
         * Sets {@code this.title} to the input parameter {@code title}.
         *
         * @param title
         *            The title to set this.title to.
         * @requires title != null && title != ""
         */
        public void setTitle(String title) {
            assert title != null : "Violation of : title != null";
            assert title != "" : "Violation of : title != \"\"";

            this.title = title;
        }

        /**
         * Sets {@code this.artist} to the input parameter {@code artist}.
         *
         * @param artist
         *            The value to set this.artist to.
         * @requires artist != null
         */
        public void setArtist(String artist) {
            assert artist != null : "Violation of : artist != null";

            this.artist = artist;
        }

        /**
         * Sets {@code this.album} to the input parameter {@code album}.
         *
         * @param album
         *            The value to set this.album to.
         * @requires album != null
         */
        public void setAlbum(String album) {
            assert album != null : "Violation of : album != null";

            this.album = album;
        }

        /**
         * Sets {@code this.length} to the input parameter {@code length}.
         *
         * @param length
         *            The value to set this.length to.
         * @requires length != null
         */
        public void setLength(String length) {
            assert length != null : "Violation of : length != null";

            this.length = length;
        }

        /**
         * Constructor that requires a title, but leaves the other parameters as
         * optional.
         *
         * @param title
         *            Title of the song
         * @param artist
         *            Artist of the song
         * @param album
         *            Album of the song
         * @param length
         *            Length of the song
         * @requires title != null && title != ""
         */
        public Song(String title, String artist, String album, String length) {
            assert title != null : "Violation of : title != null";
            assert title != "" : "Violation of : title != \"\"";

            this.title = title;

            /*
             * I did some research on methods of making optional parameters
             * other than method overloading, and this was something I found.
             * I'm guessing it's not ideal since most sources I found suggested
             * the builder method and didn't even mention using null values, so
             * in a real implementation I would likely use the builder method.
             * I'm not entirely sure why this null method is a bad one though.
             */
            if (artist != null) {
                this.artist = artist;
            }

            if (album != null) {
                this.album = album;
            }

            if (length != null) {
                this.length = length;
            }
        }
    }

    /**
     * Set containing {@code Song} objects used to represent the playlist.
     */
    private ArrayList<Song> songs;

    /**
     * Tracks whether the database is currently fully sorted. It will be set to
     * false every time a value is added, and set to true whenever the sort
     * method is called.
     */
    private boolean fullySorted = false;

    /**
     * No argument constructor.
     */
    public MusicPlaylist1() {
        this.songs = new ArrayList<Song>();
    }

    /**
     * Adds an entry to the database.
     *
     * @param title
     *            The title of the song
     * @param artist
     *            The artist of the song
     * @param album
     *            The album the song is from
     * @param length
     *            The length of the song
     * @requires title != null AND title != ""
     */
    public void addEntry(String title, String artist, String album,
            String length) {
        assert title != null : "Violation of: title != null";
        assert title != "" : "Violation of: title != \"\"";

        Song song = new Song(title, artist, album, length);

        this.songs.add(song);

        this.fullySorted = false;
    }

    /**
     * Adds an entry to the database.
     *
     * @param song
     *            An object of type {@code Song} to add to the database.
     * @requires song != null
     */
    public void addEntry(Song song) {
        assert song != null : "Violation of: song != null";

        this.songs.add(song);

        this.fullySorted = false;
    }

    /**
     * A method that takes a parameter ("title", "artist", "album", "length"),
     * to search by and a value to use to search.
     *
     * @param para
     * @param value
     * @return An array of all Songs with a parameter matching the given value.
     * @requires para == "title" || para == "artist" || para == "album" || para
     *           == "length" && value != null
     */
    public ArrayList<Song> getEntries(String para, String value) {
        assert para == "title" || para == "artist" || para == "album"
                || para == "length" : "Violation of : para == "
                        + "\"title\" OR \"artist\" OR \"album\" OR \"length\"";
        final int five = 5;

        ArrayList<Song> foundSongs = new ArrayList<Song>(five);

        if (para == "title") {
            for (Song song : this.songs) {
                if (song.title() == value) {
                    foundSongs.add(song);
                }
            }

        } else if (para == "artist") {
            for (Song song : this.songs) {
                if (song.artist() == value) {
                    foundSongs.add(song);
                }
            }

        } else if (para == "album") {
            for (Song song : this.songs) {
                if (song.album() == value) {
                    foundSongs.add(song);
                }
            }

        } else if (para == "length") {
            for (Song song : this.songs) {
                if (song.length() == value) {
                    foundSongs.add(song);
                }
            }
        }

        return foundSongs;
    }

    /**
     * Main method.
     */
    public static void main() {

    }
}
