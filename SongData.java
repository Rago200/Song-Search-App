interface SongDataInterface {
  public String getTitle();
  public String getArtist();
  public int getYearPublished();
}

/**
 * This class houses the SongData Object.
 */
public class SongData implements SongDataInterface {

  private String title;
  private String artist;
  private int year;

  /**
   * The constructor for SongData class
   * @param title title of the song
   * @param artist artist of the song
   * @param year year the song was released
   */
  public SongData (String title, String artist, int year){
    this.title = title;
    this.artist = artist;
    this.year = year;
  }

  /**
   * Gets the title of the song
   * @return title of the song
   */
  @Override
  public String getTitle() {
    return title;
  }

  /**
   * Gets the artist of the song
   * @return artist of the song
   */
  @Override
  public String getArtist() {
    // TODO Auto-generated method stub
    return artist;
  }

  /**
   * Gets the year the song was published
   * @return year the song was published
   */
  @Override
  public int getYearPublished() {
    // TODO Auto-generated method stub
    return year;
  }
}
