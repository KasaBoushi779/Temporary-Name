import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
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
    public static void out(String output) {
        System.out.println(output);
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
            this.printSong(song);
            out("********************");
        }
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public MusicDatabase split(MusicDatabaseKernel.SearchField field,
            String value) {
        MusicDatabase newDB = new MusicDatabase();
        ArrayList<Song> splitSongs = this.removeEntries(field, value);

        for (Song song : splitSongs) {
            newDB.addEntry(song);
        }

        return newDB;
    }

    // CHECKSTYLE: ALLOW THIS METHOD TO BE OVERRIDDEN
    @Override
    public void append(MusicDatabase db) {
        for (Song song : db) {
            this.addEntry(song);
        }
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
}
