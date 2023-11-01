package Lab6;

import java.util.TreeMap;

/**
 * @version November 1st 2023
 * @author Ellis Fitzgerald
 * TermFrequencyCalculator
 */
public class TermFrequencyCalculator implements ITermFrequency {

    /**
     * @author Ellis Fitzgerald
     * @param songLyrics - The TreeMap that represents a key type of songTitle (String) and value type of lyrics (String)
     * @return a TreeMap of type term (String) with its corresponding frequency
     */
    @Override
    public TreeMap<String, TreeMap<String, Double>> getTermFrequency(TreeMap<String, String> songLyrics) {
        TreeMap<String, TreeMap<String, Double>> result = new TreeMap<String, TreeMap<String, Double>> ();
        
        double avgSongLength = averageSongLength(songLyrics);
        
        for(String songTitle: songLyrics.keySet())
        {
            // For each song you have to create TF values
            TreeMap<String, Double> tempMap = new TreeMap<String, Double>();

            // current lyrics
            String lyric = songLyrics.get(songTitle);
            String[] words = lyric.split(" ");
            
            // Calculate the Term Frequency (TF) Values here and save them in tempMap
            
            // You might need to introduce other methods and additional variables
            
            // TF for Term (word) X in Song S is calculated as 
            // f(X,S) . (2.2) / (f(X,S) + 1.2 . (0.25+0.75 .|S|/AvgS)
            // where f(X,S) is the frequency of term X in song S
            // |S| is the length of song in terms of number of words
            // AvgS is the average length of songs based on number of words
            
            ////////////////////////////
            for(String word : words) {
                if(tempMap.get(word) != null) {
                    double wordFrequency = wordOccurences(word, words) / words.length;
                    double numerator = wordFrequency * 2.2;
                    double denominator = wordFrequency + 1.2 * (0.25 + 0.75 * words.length / avgSongLength);
                    tempMap.put(word, numerator / denominator);
     
                }
            }
            //////////////////////////
            
            // After Calculaion
            result.put(songTitle, tempMap);
        }
        
        return result;
    }
    
    /**
     * @author Ellis Fitzgerald
     * @param songLyrics
     * @return averageSongLength in the number of lyrics in the song
     */
    public double averageSongLength(TreeMap<String, String> songLyrics) {
        int sum;
        for(String songTitle : songLyrics.keySet()) {
            String[] currentSongLyrics = songLyrics.get(songTitle).split(" ");
            sum += currentSongLyrics.length;
        }
        return sum / songLyrics.size();
    }
    
    /**
     * @author Ellis Fitzgerald
     * @param wordToCheck - The word to find all occurences in {@codelyrics}
     * @param lyrics - All the words in the song
     * @return - The number representing how many times {@codewordToCheck} occurs in the song lyrics
     */
    public double wordOccurences(String wordToCheck, String[] lyrics) {
        int occurences = 0;
        for(String lyric : lyrics) {
            if(lyric.equals(wordToCheck)) {
                occurences++;
            }
        }
        return occurences;
    }

}
