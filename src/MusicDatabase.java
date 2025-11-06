import java.util.ArrayList;
import java.util.Comparator;

/**
 * {@code MusicDatabaseKernel} enhanced with secondary methods.
 */
public interface MusicDatabase extends MusicDatabaseKernel {

    /*
     * I didn't see any comparator methods in the osu components that had them,
     * so I assume they're not needed here?
     */

    /**
     * Sorts the database based on the provided {@code Comparator}.
     *
     * @param order
     *            A {@code Comparator<MusicDatabase>} used to sort the database.
     * @ensures The database is sorted according to {@code order}
     * @updates this
     */
    void sort(Comparator<MusicDatabase> order);

    /**
     * Creates a database by reading from a properly formatted .csv file.
     *
     * @param inputPath
     *            The path to the .csv file
     * @requires {@code inputPath} is a valid input path AND the file it leads
     *           to is a .csv file AND it is formatted such that the first
     *           column is "title", the second is "artist", the third is
     *           "album", the fourth is "length", and the appropriate field
     *           values are below the 1-4th columns.
     * @ensures this contains all song data in the file {@code inputPath} points
     *          to
     * @updates this
     */
    void readFromFile(String inputPath);

    /**
     * Writes to a .csv file from the database.
     *
     * @param outputPath
     *            Path to create the .csv in. If "", the .csv file will be
     *            printed to .output/Music_Database.csv by default.
     * @requires {@code outputPath} is a valid file path or ""
     * @ensures All songs in this are printed to a .csv file in a manner such
     *          that the first column is "title", the second is "artist", the
     *          third is "album", the fourth is "length", and the appropriate
     *          field values are below the 1-4th columns.
     */
    void writeToFile(String outputPath);

    /**
     * Prints out the details of the given {@code song} with nice formatting.
     *
     * @param song
     *            The {@code Song} object to print.
     * @requires song != null
     * @ensures The title, artist, length, and album (if present) of the given
     *          song are printed to the console.
     * @updates console
     */
    void printSong(Song song);

    /**
     * Prints out the details of all the {@code song} objects in the given
     * {@code ArrayList} with nice formatting.
     *
     * @param songs
     *            The {@code ArrayList} of {@code Song} objects to print.
     * @requires songs != null
     * @ensures The title, artist, length, and album (if present) of each song
     *          in the given {@code ArrayList} are printed to the console.
     * @updates console
     */
    void printSongs(ArrayList<Song> songs);

    /**
     * Makes a new database with all songs in this that have a matching value in
     * either their "title", "artist", "length", "album" (chosen via the field
     * enum) field, and removes those songs from this. If no matches are found,
     * returns an empty {@code MusicDatabase}.
     *
     * @param field
     *            An enum that can be either "title", "artist", "length", or
     *            "album"
     * @param value
     *            The value to split by in the chosen field
     * @return A new {@code MusicDatabase} containing the songs meeting the
     *         given criteria
     * @ensures split = All songs meeting the given criteria AND this = #this /
     *          all songs in split
     * @updates this
     */
    MusicDatabase split(SearchField field, String value);

    /**
     * Appends db to this.
     *
     * @param db
     *            The {@code MusicDatabase} to append to this
     * @requires db != null
     * @ensures this = #this * db
     * @updates this
     */
    void merge(MusicDatabase db);
}
