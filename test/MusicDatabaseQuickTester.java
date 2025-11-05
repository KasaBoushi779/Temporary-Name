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
     * Main method.
     *
     * @param args
     */
    public static void main(String[] args) {
        Song firstSong = new Song("AWAKE", "Hoshimachi Suisei", "3:18",
                "Shinsei Mokuroku");
        out(firstSong.title());
    }
}
