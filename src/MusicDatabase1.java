import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

/**
 * {@code MusicDatabase} represented as an {@link java.util.ArrayList
 * java.util.ArrayList} with implementations of primary methods.
 */
public class MusicDatabase1 extends MusicDatabaseSecondary {

    /*
     * Private members.
     */

    /**
     * The default initial size of the underlying {@code ArrayList} if the
     * no-argument constructor is used.
     */
    private static final int DEFAULT_SIZE = 20;

    /**
     * Representation of {@code this}.
     */
    private ArrayList<Song> db;

    /*
     * Constructors.
     */

    /**
     * No-argument constructor.
     */
    public MusicDatabase1() {
        this.createNewRep(DEFAULT_SIZE);
    }

    /**
     * Constructor that allows user to set initial size of the underlying
     * {@code ArrayList}.
     *
     * @param size
     *            The initial size of the underlying {@code ArrayList}
     */
    public MusicDatabase1(int size) {
        this.createNewRep(size);
    }

    /**
     * Creator of initial representation.
     *
     * @param initSize
     *            Determines how large the underlying {@code ArrayList} is
     *            initially
     */
    private void createNewRep(int initSize) {
        this.db = new ArrayList<Song>(initSize);
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public Iterator<Song> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "Unimplemented method 'iterator'");
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public void clear() {
        this.createNewRep(DEFAULT_SIZE);
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public MusicDatabase newInstance() {
        return new MusicDatabase1();
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public void transferFrom(MusicDatabase source) {
        assert source != null : "Violation of: source is not null";
        assert source != this : "Violation of: source is not this";
        assert source instanceof MusicDatabase1 : ""
                + "Violation of: source is of dynamic type MusicDatabase1";
        /*
         * This cast cannot fail since the assert above would have stopped
         * execution in that case.
         */
        MusicDatabase1 temp = (MusicDatabase1) source;
        this.db = temp.db;
        temp.createNewRep(DEFAULT_SIZE);
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public void addEntry(Song song) {
        assert song != null : "Violation of: song != null";
        assert !this.db.contains(song) : "Violation of: song is not in this";

        this.db.add(song);
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public Song getEntryInOrder(int n) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "Unimplemented method 'getEntryInOrder'");
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public ArrayList<Song> getEntries(MusicDatabaseKernel.SearchField field,
            String value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "Unimplemented method 'getEntries'");
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public ArrayList<Song> removeEntries(MusicDatabaseKernel.SearchField field,
            String value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "Unimplemented method 'removeEntries'");
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public Song removeEntry(Song song) {
        assert this.db.contains(song) : "Violation of: song is in this";

        this.db.remove(song);
        return song;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public Boolean contains(Song song) {
        return this.db.contains(song);
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public int size() {
        return this.db.size();
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public void sort(Comparator<Song> order) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sort'");
    }
}
