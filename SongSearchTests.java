import java.io.FileNotFoundException;
import java.util.List;

public class SongSearchTests {

  public static void main(String[] args) throws Exception {
    System.out.println("TestLoadFile: " + DataWrangler_TestLoadFile());
    System.out.println("TestloadAllFilesInDirectory(): " + DataWrangler_TestloadAllFilesInDirectory());
    System.out.println("DataWrangler_TestSongData: " + DataWrangler_TestSongData());
  }
  // Data Wrangler Code Tests

  /**
   * Checks the TestLoadFile method of the SongLoader class.
   * @return true if the implementation is correct, false otherwise
   * @throws FileNotFoundException
   */
  public static boolean DataWrangler_TestLoadFile() throws FileNotFoundException{
    SongLoader songLoader = new SongLoader();
    List<SongDataInterface> list = songLoader.loadFile("top10s.csv");
    //Checking to see if it returns title
    if(!(list.get(0).getTitle().equals("Hey, Soul Sister"))){
      return false;
    }

    //Checking to see if it returns artist
    if(!(list.get(0).getArtist().equals("Train"))){
      return false;
    }

    //Checking to see if it returns year
    if(!(list.get(0).getYearPublished() == 2010)){
      return false;
    }

    //Checking to see the size of the list to see if all contents stayed
    if(list.size() != 603){
      return false;
    }

    return true;
  }

  /**
   * Checks the loadAllFilesInDirectory method of the SongLoader class.
   * @return true if the implementation is correct, false otherwise
   * @throws FileNotFoundException
   */
  public static boolean DataWrangler_TestloadAllFilesInDirectory() throws FileNotFoundException{
    SongLoader songLoader = new SongLoader();
    List<SongDataInterface> list = songLoader.loadAllFilesInDirectory(".");
    //Checking the first element in the LoadAllFiles list(First 500 gets added before 10)
    if(!(list.get(0).getTitle().equals("Like a Rolling Stone"))){
      return false;
    }

    //Checking for the artist in the combined list
    if(!(list.get(0).getArtist().equals("Bob Dylan"))){
      return false;
    }

    //Checking the year it was published.
    if(list.get(0).getYearPublished() != 1965){
      return false;
    }

    //Checking the size
    if(list.size() != 1103){
      System.out.println(list.size());
      return false;
    }

    return true;
  }

  /**
   * Checks the SongData class implementation
   * @return true if the implementation is correct, false otherwise
   * @throws FileNotFoundException
   */
  public static boolean DataWrangler_TestSongData(){
    SongData songData = new SongData("Cars", "Rj", 2021);

    //checking Getters.
    if(!(songData.getArtist().equals("Rj"))){
      System.out.println(songData.getArtist());
      return false;
    }

    if (!songData.getTitle().equals("Cars")){
      return false;
    }

    if(songData.getYearPublished() != 2021){
      return false;
    }

    return true;
  }
  // Back End Developer Tests
  // Front End Developer Tests
  // Integration Manager Tests
}