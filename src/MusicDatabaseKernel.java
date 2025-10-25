import java.util.ArrayList;

import components.standard.Standard;

/**
 * Component meant to model a database of music with primary methods. (Note: by
 * package-wide convention, all references are non-null.)
 */
public interface MusicDatabaseKernel extends Standard<MusicDatabase> {

    /**
     * An enum for methods only intended to accept the four fields of the
     * {@code Song} class as one of their parameters (i.e. methods searching by
     * field).
     */
    enum SearchField {
        /**
         * See above, this comment is just to remove a checkstyle issue.
         */
        TITLE, ARTIST, LENGTH, ALBUM
    }

    /**
     * Adds a {@code Song} object made from the given parameters into the
     * database.
     *
     * @param title
     *            The title of the song
     * @param artist
     *            The artist of the song
     * @param length
     *            The length of the song
     * @param album
     *            The album the song is from
     * @requires title, artist, and length are neither null nor ""
     * @ensures {@code this = #this * song}
     * @updates {@code this}
     */
    void addEntry(String title, String artist, String length, String album);

    /**
     * Adds a {@code Song} object made from the given parameters into the
     * database. Album is left at the default value, which is an empty string.
     *
     * @param title
     *            The title of the song
     * @param artist
     *            The artist of the song
     * @param length
     *            The length of the song
     * @requires title, artist, and length are neither null nor ""
     * @ensures {@code this = #this * song}
     * @updates {@code this}
     */
    void addEntry(String title, String artist, String length);

    /**
     * Adds a premade {@code Song} object to the database.
     *
     * @param song
     *            An object of type {@code Song} to add to the database.
     * @requires song != null
     * @ensures {@code this = #this * song}
     * @updates {@code this}
     */
    void addEntry(Song song);

    /**
     * A method that takes an enum (which can be "title", "artist", "album", or
     * "length"), and a value to use to find matches within the {@code Song}
     * objects of the database. It then returns an {@code ArrayList} of all
     * matches found.
     *
     * @param field
     *            An enum representing the {@code Song} field to search through
     * @param value
     *            A string value to search by
     * @return An {@code ArrayList} of all {@code Songs} with a field matching
     *         the given value.
     * @requires value != null
     * @ensures getEntries = All Songs that have a value in {@code field}
     *          matching the {@code value} parameter
     */
    ArrayList<Song> getEntries(SearchField field, String value);
}
