import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.io.FileNotFoundException;
import java.util.Scanner;

// interface (implemented with proposal)
interface SongLoaderInterface {
  public List<SongDataInterface> loadFile(String csvFilePath) throws FileNotFoundException;
  public List<SongDataInterface> loadAllFilesInDirectory(String directoryPath) throws FileNotFoundException;
}

/**
 * This class houses the SongLoader class and its methods
 */
public class SongLoader implements SongLoaderInterface {
  /**
   * This method adds the SongData objects into a list.
   *
   * @param csvFilePath the file name
   * @return the songs in a list
   * @throws FileNotFoundException
   */
  @Override
  public List<SongDataInterface> loadFile(String csvFilePath) throws FileNotFoundException {
    Scanner scan = new Scanner(new File(csvFilePath));
    List<SongDataInterface> songs = new LinkedList<>();
    scan.nextLine();
    while (scan.hasNext()) {
      songs.add(HelperSongAdd(scan.nextLine(), csvFilePath));
    }
    return songs;
  }

  /**
   * This method goes through multiple files and adds all the songs in a list.
   *
   * @param directoryPath the directory path
   * @return all the songs in the directory in list format.
   * @throws FileNotFoundException
   */
  @Override
  public List<SongDataInterface> loadAllFilesInDirectory(String directoryPath) throws FileNotFoundException {
    File path = new File(directoryPath);
    File[] files= path.listFiles();
    List<SongDataInterface> songsAll = new LinkedList<>();
    for (File f : files) {
      if (f.toString().contains(".csv")) {
        if (f.toString().equals("./Top 500 Songs.csv")){
          List<SongDataInterface> song500 = loadFile("Top 500 Songs.csv");
          songsAll.addAll(song500);
        }
        if (f.toString().equals("./top10s.csv")){
          List<SongDataInterface> song10 = loadFile("top10s.csv");
          songsAll.addAll(song10);
        }
      }
    }
    return songsAll;
  }

  /**
   * This is a helper method that separates the lines in the file and returns each of the songs data
   * as an Object of SongData.
   *
   * @param line  the line that contains the song
   * @param fileType which of the files that are being sent
   * @return the SongData object containing artist, year, and title.
   */
  private SongData HelperSongAdd(String line, String fileType) {
    if (fileType.equals("Top 500 Songs.csv")) {
      int artist = 3;
      int year = 6;
      int title = 0;
      String[] sections = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
      sections[year] = sections[year].substring(sections[year].length() - 5, sections[year].length() - 1);
      SongData songParts = new SongData(sections[title], sections[artist], Integer.parseInt(sections[year].trim()));
      return songParts;
    }

    if (fileType.equals(("top10s.csv"))) {
      int artist = 2;
      int year = 4;
      int title = 1;
      String[] sections = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
      SongData songParts = new SongData(sections[title].replace("\"", ""),
              sections[artist].replace("\"", ""), Integer.parseInt(sections[year]));
      return songParts;
    }
    return null;
  }
}