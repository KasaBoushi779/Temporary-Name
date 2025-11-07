import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Class for quick tests.
 */
public final class MusicDatabaseQuickTester {

    /**
     * Simplified version of System.out.println for convenience.
     *
     * @param output
     */
    public static void out(String output) {
        System.out.println(output);
    }

    /**
     * Private constructor to prevent instantiation.
     */
    private MusicDatabaseQuickTester() {
    }

    /**
     * s.
     *
     * @param song
     */
    public static void printSong(Song song) {
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

    /**
     * s.
     *
     * @param inputPath
     */
    public static void readFromFile(String inputPath, ArrayList<Song> songs) {
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

                songs.add(song);

                line = rdr.readLine();
            }
            rdr.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * s.
     *
     * @param outputPath
     * @param songs
     */
    public static void writeToFile(String outputPath, ArrayList<Song> songs) {
        try {
            BufferedWriter wrtr = new BufferedWriter(
                    new FileWriter(outputPath));

            wrtr.write("Title\tArtist\tAlbum\tLength");
            wrtr.newLine();

            for (Song song : songs) {
                wrtr.write(String.format("%s\t%s\t%s\t%s", song.title(),
                        song.artist(), song.album(), song.length()));
                wrtr.newLine();
            }

            wrtr.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<Song> songs = new ArrayList<Song>();

        Path tempPath = Paths.get("data\\input\\file1.txt");

        try {
            out(Files.probeContentType(tempPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        readFromFile("data\\input\\file1.txt", songs);

        //writeToFile("data\\output\\out1.txt", songs);
    }
}
