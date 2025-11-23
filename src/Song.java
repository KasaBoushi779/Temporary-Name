/**
 * A record class meant to hold song data. Parameters are self explanatory.
 *
 * @param title
 * @param artist
 * @param length
 * @param album
 * @return
 */
public record Song(String title, String artist, String album, String length) {

    /**
     * Song constructor.
     *
     * @param title
     * @param artist
     * @param album
     * @param length
     */
    public Song(String title, String artist, String album, String length) {
        final int four = 4;

        assert title != "" : "Violation of: title != \"\"";
        assert artist != "" : "Violation of: artist != \"\"";
        assert length.split(":").length < four : ""
                + "Violation of: Songs can have a length of at most 99:99:99";

        this.title = title;
        this.artist = artist;
        this.album = album;
        this.length = length;
    }
}
