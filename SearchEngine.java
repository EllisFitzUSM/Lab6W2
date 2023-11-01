package Lab6;

import java.util.TreeMap;


/*
 * Subtask 3: You will complete SearchEngine class, the method search. When users search for
 * something, it is expressed as a String, query, which has several words. For example, the query
 * “All we hear is”, has four words. For each word, you have to calculate the TFxIDF (provided by
 * your other team members) score per song. The summation of these scores is the search engine
 * score for that song. The song with the highest score is the top result and its title should be
 * returned.
 * 
 * To calculate the score for each song, find the corresponding TF values for that song. Then for
 * each word in the query, multiply the TF and IDF values of that word
 * 
 * 
 */



public class SearchEngine {
    // TreeMap of songs title and TreeMap of words and their TFvalues for that song
    TreeMap<String, TreeMap<String, Double>> TFValues;
    
    // TreeMap of words and their IDF values
    TreeMap<String, Double> IDFValues;
    
    // TreeMap of song titles and their lyrics
    TreeMap<String, String> songTitleLyrics;
    public SearchEngine(LyricsReader lyricsReader, ITermFrequency TF, IInverseFreq IDF)
    {
        songTitleLyrics = lyricsReader.songLyricsMap;
        TFValues = TF.getTermFrequency(songTitleLyrics);
        IDFValues = IDF.getInverseDocumentFrequency(songTitleLyrics);        
    }
    
    
    /**
     * @author Jove Emmons
     * 
     * @param String query The lyrics to be searched for. This can be multiple words separated by spaces (" ")
     * 
     * @return The String name of the song that matches the query lyrics best
     */
    public String search(String query)
    {
        String[] queryWords = query.split(" ");
        
        String resultSong = "";
        double maxScore = -1;
      
        // Iterating on each song to calculate its TF-IDF value for the query
        for(String songTitle: songTitleLyrics.keySet()){
            // TF-IDF score for the current song
            double score = 0;
            
            // Iterating 
            for(String queryWord: queryWords){
                // Here you should get the corresponding TF and IDF values of that query word
                // And then modify the code to calculate the TF-IDF value
                
                // Score for a song, is summation of TF*IDF values for each query word
                // Note that IDF are global and not related to a specific song
                // But TF values for a query word is different among different songs
                
                ////////////////////////////
                //WRITE HERE
                //////////////////////////
            	
            	
            	
            	Double TFtemp = ( TFValues.get(songTitle) ).get(queryWord);
            	
            	Double IDFtemp = IDFValues.get(queryWord);
            	
            	score += TFtemp * IDFtemp;
            	
            }
            
            if (score>maxScore)
            {
                maxScore = score;
                resultSong = songTitle;
            }
        }
        
        // You should return the name of the song with the highest TF-IDF value
        return resultSong;
    }
}
