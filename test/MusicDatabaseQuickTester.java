import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
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
     * Throws an exception and prints an error message if the given line is not
     * a valid header.
     *
     * @param line
     *            A line of text from a tab delimited file
     * @ensures isValidHeader throws an exception if line is a valid header in
     *          the format "Title\tArtist\tAlbum\tLength".
     */
    private static void isValidHeader(String line) {
        if (!line.equals("Title\tArtist\tAlbum\tLength")) {
            throw new IllegalArgumentException(
                    "ERROR: Header is incorrectly formatted. "
                            + "Header should be in the form"
                            + " \"Title\\tArtist\\tAlbum\\tLength\", "
                            + "where \\t is a tab");
        }
    }

    /**
     * Throws an exception if the given line of data is not properly formatted.
     * See the ensures tag for details.
     *
     * @param line
     *            A line of text
     * @ensures An exception with a descriptive message is thrown for each
     *          individual case: 1. If the number of values separated by tabs is
     *          not four 2. If the first value in the line (title) is null or an
     *          empty string 3. If the second value in the line (artist) is null
     *          or an empty string 4. If the fourth value in the line (length)
     *          is null or an empty string
     */
    private static void isValidDataRow(String line) {
        /*
         * Splits line along any tabs, including empty strings.
         */
        String[] fields = line.split("\t", -1);
        /*
         * Checks the number of tabs in the input to make sure there are four
         * values, even if album is blank.
         */
        final int four = 4;
        if (fields.length != four) {
            throw new IllegalArgumentException(
                    "ERROR: the given line is invalid. There must be four "
                            + "separate values separated by three total tabs "
                            + "in each row of data.");
        }
        /*
         * Checks to make sure title (index 0), artist (index 1), and length
         * (index 3) are not null.
         */
        if (fields[0] == null || fields[0] == "") {
            throw new IllegalArgumentException(""
                    + "ERROR: Title is blank, a title is required for every data row.");
        }
        if (fields[1] == null || fields[1] == "") {
            throw new IllegalArgumentException(
                    "" + "ERROR: Artist is blank, an artist is required"
                            + " for every data row.");
        }
        final int three = 3;
        if (fields[three] == null || fields[three] == "") {
            throw new IllegalArgumentException(""
                    + "ERROR: Length is blank, a length is required for every data row.");
        }
    }

    /**
     * Throws an exception if the given line of data is not properly formatted.
     * See the ensures tag for details. Also prints the number of the row
     * currently being checked.
     *
     * @param line
     *            A line of text
     * @param rowNum
     *            The row currently being checked
     * @ensures An exception with a descriptive message is thrown for each
     *          individual case: 1. If the number of values separated by tabs is
     *          not four 2. If the first value in the line (title) is null or an
     *          empty string 3. If the second value in the line (artist) is null
     *          or an empty string 4. If the fourth value in the line (length)
     *          is null or an empty string
     */
    private static void isValidDataRow(String line, int rowNum) {
        /*
         * Splits line along any tabs, including empty strings.
         */
        String[] fields = line.split("\t", -1);
        /*
         * Checks the number of tabs in the input to make sure there are four
         * values, even if album is blank.
         */
        final int four = 4;
        if (fields.length != four) {
            throw new IllegalArgumentException("ERROR on row " + rowNum
                    + ": the given line is invalid. There must be four "
                    + "separate values separated by three total tabs "
                    + "in each row of data.");
        }
        /*
         * Checks to make sure title (index 0), artist (index 1), and length
         * (index 3) are not null.
         */
        if (fields[0] == null || fields[0] == "") {
            throw new IllegalArgumentException("ERROR on row " + rowNum
                    + ": Title is blank, a title is required for every data row.");
        }
        if (fields[1] == null || fields[1] == "") {
            throw new IllegalArgumentException("ERROR on row " + rowNum
                    + ": Artist is blank, an artist is required"
                    + " for every data row.");
        }
        final int three = 3;
        if (fields[three] == null || fields[three] == "") {
            throw new IllegalArgumentException("ERROR on row " + rowNum
                    + ": Length is blank, a length is required for every data row.");
        }
    }

    /**
     * Throws an exception and prints an error message if the file at the given
     * file path is not a .txt file.
     *
     * @param filePath
     *            The path to a file.
     * @requires filePath != null
     * @ensures isTxt = Whether the file at the given path is a text/plain file
     */
    private static void isTxt(String filePath) {
        assert filePath != null : "Violation of: filePath != null";

        try {
            Path pathToFile = Paths.get(filePath);

            if (!Files.probeContentType(pathToFile).equals("text/plain")) {
                throw new IllegalArgumentException(
                        "ERROR: file must be of type \".txt\", "
                                + "or more specifically, \"text/plain\"");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * s.
     *
     * @param outputPath
     */
    // public static void writeToFile(String outputPath) {
    //     // TO DO
    //     assert outputPath != null : "Violation of: outputPath != null";

    //     String path = outputPath;
    //     if (outputPath == "") {
    //         path = "data\\output\\Music_Database";
    //     }

    //     try (BufferedWriter wrtr = new BufferedWriter(new FileWriter(path))) {
    //         wrtr.write("Title\tArtist\tAlbum\tLength");
    //         wrtr.newLine();
    //         out("Success!");
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    // }

    public static void writeToFile(String outputPath) {
        assert outputPath != null : "Violation of: outputPath != null";

        BufferedWriter wrtr = null;
        try {
            String path = outputPath;
            if (outputPath == "") {
                path = "data\\output\\testOutput2.txt";
            }

            File outputFile = new File(path);
            outputFile.mkdirs();
            wrtr = new BufferedWriter(new FileWriter(outputFile));

            wrtr.write("Title\tArtist\tAlbum\tLength");
            wrtr.newLine();

            wrtr.flush();
            out("Success!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (wrtr != null) {
                    wrtr.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        // ArrayList<Song> songs = new ArrayList<Song>();

        // Path tempPath = Paths.get("data\\input\\file1.txt");

        // try {
        // out(Files.probeContentType(tempPath));
        // } catch (IOException e) {
        // e.printStackTrace();
        // }

        // readFromFile("data\\input\\file1.txt", songs);

        // writeToFile("data\\output\\out1.txt", songs);
        try (BufferedReader rdr = new BufferedReader(
                new FileReader("data\\input\\file1.txt"))) {

            String line = rdr.readLine();
            out(line);
            isValidHeader(line);

            line = rdr.readLine();
            out(line);
            isValidDataRow(line, 2);

            line = "Bye Bye Rainy\tHoshimachi Suisei\t\t3:20";
            out(line);
            isValidDataRow(line, 99);

            line = rdr.readLine();
            out(line);
            isValidDataRow(line, 3);

            // ".\\test\\testOutput"
            writeToFile("");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
