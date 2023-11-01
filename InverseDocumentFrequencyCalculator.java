package lab6;

import java.util.TreeMap;

/**
 * InverseDocumentFrequencyCalculator holds a method which finds the IDF of each
 * word in a collection
 * 
 * @author Jonah
 */
public class InverseDocumentFrequencyCalculator implements IInverseFreq {
	/**
	 * getInverseDocumentFrequency takes a TreeMap of String keys and values,
	 * calculates the frequency in each word using statistical formula for IDF
	 * returning a TreeMap of associated words and IDF values
	 * 
	 * @return result TreeMap of key words and IDF values
	 * @param songLyrics Treemap of Song and Lyric values
	 * @author Jonah
	 */
	@Override
	public TreeMap<String, Double> getInverseDocumentFrequency(TreeMap<String, String> songLyrics) {
		TreeMap<String, Double> result = new TreeMap<String, Double>();
		TreeMap<String, Integer> nX = new TreeMap<String, Integer>();
		int N = songLyrics.size();
		/*
		 * Searches through songs to find each song containing a certain word
		 * (searchWord), defaults to zero if word is not present, increments otherwise,
		 * puts them into nX treemap
		 */
		for (String songTitle : songLyrics.keySet()) {
			String lyric = songLyrics.get(songTitle);
			String[] words = lyric.split(" ");

			for (String word : words) {

				String searchWord = word.toLowerCase();
				nX.put(searchWord, nX.getOrDefault(searchWord, 0) + 1);
			}
		}

		// Calculate the Inverse Document Frequency (IDF) Values here
		// You might need to introduce other methods and additional variables

		// IDF for term X is calculated as ln of (N-n(X)+0.5)/(n(X)+0.5) plus
		// where N is total number of songs
		// and n(X) is the number of songs having term X

		/*
		 * IDF calc for every word searched and added to nX treemap
		 */
		for (String term : nX.keySet()) {
			int nXCount = nX.get(term);
			double idf = Math.log((N - nXCount + 0.5) / (nXCount + 0.5) + 1);

			result.put(term, idf);
		}

		return result;
	}

}