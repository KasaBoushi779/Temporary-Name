import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Layered implementation of secondary methods for {@code MusicDatabase}.
 */
public class MusicDatabaseSecondary implements MusicDatabase {

    /*
     * ------------------------- Secondary methods -----------------------------
     */
    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public void sort(Comparator<MusicDatabase> order) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sort'");
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public void readFromFile(String inputPath) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "Unimplemented method 'readFromFile'");
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public void writeToFile(String outputPath) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "Unimplemented method 'writeToFile'");
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public void displaySong(MusicDatabaseKernel.Song song) {
        PrintWriter out = new PrintWriter(System.out);

        out.println("* Title: " + song.title());
        out.println("* Artist: " + song.artist());

        /*
         * Not all songs are part of an album, so this line will only print if a
         * song is part of an album
         */
        if (!song.album().equals("")) {
            out.println("* Album: " + song.album());
        }

        out.println("* Length: " + song.length());

        out.close();
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public void displaySongs(ArrayList<MusicDatabaseKernel.Song> songs) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "Unimplemented method 'displaySongs'");
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public MusicDatabase split(MusicDatabaseKernel.SearchField field,
            String value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'split'");
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public void merge(MusicDatabase db) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'merge'");
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "Unimplemented method 'toString'");
    }

    /**
     *
     * @param db
     * @return
     */
    public int equals(MusicDatabase db) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "Unimplemented method 'equals'");
    }

    /*
     * -------------------------- Kernel methods -------------------------------
     */

    /**
     * Inherited from MusicDatabaseKernel. Adds a {@code Song} object to the
     * database if a duplicate does not already exist.
     *
     * @param song
     *            An object of type {@code Song} to add to the database.
     * @requires song != null AND an identical Song object is not already in the
     *           database
     * @ensures this = #this * song
     * @updates this
     */
    @Override
    public void addEntry(MusicDatabaseKernel.Song song) {
    }

    @Override
    public MusicDatabaseKernel.Song getEntryInOrder(int n) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "Unimplemented method 'getEntryInOrder'");
    }

    @Override
    public ArrayList<MusicDatabaseKernel.Song> getEntries(
            MusicDatabaseKernel.SearchField field, String value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "Unimplemented method 'getEntries'");
    }

    @Override
    public ArrayList<MusicDatabaseKernel.Song> removeEntries(
            MusicDatabaseKernel.SearchField field, String value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "Unimplemented method 'removeEntries'");
    }

    @Override
    public MusicDatabaseKernel.Song removeEntry(MusicDatabaseKernel.Song song) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "Unimplemented method 'removeEntry'");
    }

    @Override
    public Boolean contains(MusicDatabaseKernel.Song song) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "Unimplemented method 'contains'");
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    @Override
    public Iterator<MusicDatabase> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "Unimplemented method 'iterator'");
    }

    /*
     * ------------------------ Standard methods -------------------------------
     */
    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public void clear() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clear'");
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public MusicDatabase newInstance() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "Unimplemented method 'newInstance'");
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public void transferFrom(MusicDatabase arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "Unimplemented method 'transferFrom'");
    }

}
