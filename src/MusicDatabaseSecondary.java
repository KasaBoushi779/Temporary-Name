import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Layered implementation of secondary methods for {@code MusicDatabase}.
 */
public abstract class MusicDatabaseSecondary implements MusicDatabase {

    /*
     * ----------------------------Utility methods------------------------------
     */

    /**
     * Simplified version of System.out.println for convenience.
     *
     * @param output
     *            The string to be printed to the console
     */
    private static void out(String output) {
        System.out.println(output);
    }

    /**
     * Checks whether the file at the given path is a correctly formatted tab
     * delimited .txt file.
     *
     * @param filePath
     *            The path to a .txt file
     * @return A boolean
     * @ensures isValidTDFile = Whether the file at the given path is a valid
     *          tab delimited .txt file.
     */
    private static Boolean isValidHeader(String line) {

    }

    /**
     * Checks whether a file is a plain .txt (text/plain) file.
     *
     * @param filePath
     *            The path to a file.
     * @requires filePath != null
     * @return A boolean
     * @ensures isTxt = Whether the file at the given path is a text/plain file
     */
    private static Boolean isTxt(String filePath) {
        Boolean isTxt = true;
        try {
            Path pathToFile = Paths.get(filePath);

            if (!Files.probeContentType(pathToFile).equals("text/plain")) {
                isTxt = false;
                throw new IllegalArgumentException(
                        "ERROR: file must be of type \".txt\", "
                                + "or more specifically, \"text/plain\"");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isTxt;
    }

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
        final int three = 3;
        try {
            isTxt(inputPath);

            BufferedReader rdr = new BufferedReader(new FileReader(inputPath));

            String line = rdr.readLine();
            /*
             * The previous call to readLine() got the headers of the file,
             * which we don't care about here, so we need to call readLine()
             * again to get the first row of actual data.
             */
            line = rdr.readLine();

            while (line != null) {
                String[] fields = line.split("\t");

                Song song = new Song(fields[0], fields[1], fields[2],
                        fields[three]);

                this.addEntry(song);

                line = rdr.readLine();
            }
            rdr.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public void writeToFile(String outputPath) {
        try {
            BufferedWriter wrtr = new BufferedWriter(
                    new FileWriter(outputPath));
            wrtr.write("Title\tArtist\tAlbum\tLength");
            wrtr.newLine();

            for (Song song : this) {
                wrtr.write(String.format("%s\t%s\t%s\t%s", song.title(),
                        song.artist(), song.album(), song.length()));
                wrtr.newLine();
            }
            wrtr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public void printSong(Song song) {
        assert song != null : "Violation of: song != null";

        out("* Title: " + song.title());
        out("* Artist: " + song.artist());
        /*
         * Not all songs are part of an album, so this line will only print if a
         * song is part of an album
         */
        if (!song.album().equals("")) {
            out("* Album: " + song.album());
        }
        out("* Length: " + song.length());
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public void printSongs(ArrayList<Song> songs) {
        assert songs != null : "Violation of: songs != null";

        out("Songs to be printed: " + songs.size());
        out("******************************");

        for (Song song : songs) {
            out("* Title: " + song.title());
            out("* Artist: " + song.artist());
            /*
             * Not all songs are part of an album, so this line will only print
             * if a song is part of an album
             */
            if (!song.album().equals("")) {
                out("* Album: " + song.album());
            }
            out("* Length: " + song.length());
            out("********************");
        }
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public MusicDatabase split(MusicDatabaseKernel.SearchField field,
            String value) {
        assert value != null : "Violation of: value != null";

        MusicDatabase newDB = this.newInstance();
        ArrayList<Song> splitSongs = this.removeEntries(field, value);

        for (Song song : splitSongs) {
            newDB.addEntry(song);
        }

        return newDB;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public void append(MusicDatabase db) {
        assert db != null : "Violation of: db != null";

        for (Song song : db) {
            if (!this.contains(song)) {
                this.addEntry(song);
            }
        }
    }

    /*
     * For the methods above and below, their functionality is identical, but
     * they take different parameters. Are they fine as is or should I combine
     * them into one overloaded method?
     */

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public void addEntries(ArrayList<Song> songs) {
        assert songs != null : "Violation of: songs != null";

        for (Song song : songs) {
            if (!this.contains(song)) {
                this.addEntry(song);
            }
        }
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(this.size());
        for (Song song : this) {
            result.append(String.format("%s\t%s\t%s\t%s\n", song.title(),
                    song.artist(), song.album(), song.length()));
        }

        return result.toString();
    }

    /**
     * Checks this and db for equality by comparing their string representations
     * lexicographically.
     *
     * @param db
     * @return an int representing how this and db compare to each other
     * @ensures If this < db, equals < 0; If this > db, equals > 0; If this ==
     *          db, equals == 0
     */
    public int equals(MusicDatabase db) {
        return (this.toString().compareTo(db.toString()));
    }
}
