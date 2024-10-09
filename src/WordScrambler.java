public class WordScrambler {

    private String[] scrambledWords;

    public String[] getScrambledWords() {
        return scrambledWords;
    }

    public WordScrambler(String[] wordArr) {

        scrambledWords = mixedWords(wordArr);

    }

    private String recombine(String word1, String word2) {
        String result = "";
        result = word1.substring(0, word1.length()/2) + word2.substring(word2.length()/2);
        return result;
    }

    private String[] mixedWords(String[] words) {
        if (words.length % 2 != 0) {
            throw new IllegalArgumentException("Word Array must contain an even number of elements!");
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if (words[i].charAt(j) == ' ') {
                    throw new IllegalArgumentException("Word Array must contain single words only! " + words[i] + " contains more than one word!");
                }
            }
        }
        for (int i = 0; i < words.length-1; i+=2) {
            String result1 = recombine(words[i], words[i+1]);
            String result2 = recombine(words[i+1], words[i]);
            words[i] = result1;
            words[i+1] = result2;
        }
        return words;
    }

}
