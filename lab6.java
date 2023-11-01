
public class lab6 {

    /**
     * Main / Testing class for Lab6W
     * @author Ellis Fitzgerald
     * @version November 1st 2023
     * @param args
     */
    public static void main(String[] args) {
        LyricsReader myLyricReader = new LyricsReader();
        TermFrequencyCalculator myCalculator = new TermFrequencyCalculator();
        InverseDocumentFrequencyCalculator myIDFCalculator = new InverseDocumentFrequencyCalculator();
        SearchEngine mySearchEngine = new SearchEngine(myLyricReader, myCalculator, myIDFCalculator);
        System.out.println(mySearchEngine.search("All we hear is"));

    }

}
