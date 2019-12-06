package greedy;

import supplementary.structures.trees.BinaryTree;

import java.util.HashMap;
import java.util.Map;

public class Huffmann {

    private Map<String, Integer> alphabet;
    private BinaryTree binTree = new BinaryTree();

    public Huffmann(String ...values) {
        this.alphabet = this.buildAlphabet(values);
    }


    /**
     * Calculates the huffmann codes for the given alphabet
     * @param values -
     */
    public void getEncoding(String ...values) {

    }


    /**
     * Encode a single String value.
     *
     * @param value - string to be encoded
     * @return - encode a single string value
     */
    public String getEncoding(String value) {



        return "";
    }



    /**
     * Builds the initial alphabet of <Word, Count>
     *
     * @param values
     * @return
     */
    public Map<String, Integer> buildAlphabet(String ...values) {

        Map<String, Integer> alphabet = new HashMap<String, Integer>();
        int wordCounter = 0;
        String alphaKey = "";
        for (String value : values) {

            // Update key counter
            value = value.toLowerCase();
            for (int i = 0; i < value.length(); i++) {

                alphaKey = Character.toString(value.charAt(i));
                if (alphabet.containsKey(alphaKey)) {
                    wordCounter = alphabet.get(alphaKey);
                    alphabet.put(alphaKey, wordCounter + 1);
                    continue;
                }

                // Insert missing key
                alphabet.put(alphaKey, 1);
            }
        }

        return alphabet;
    }


    /**
     * Adding additional word to the alphabet to update the encoding table.
     *
     * @param words - array of new words to add to the alphabet
     */
    public void addWord(String ...words) {

        Map<String, Integer> alphabet = this.getAlphabet();
        String alphaKey = "";
        int wordCounter = 0;
        for (String word: words) {

            word = word.toLowerCase();
            for (int i = 0; i < word.length(); i++) {

                // Update key counter
                alphaKey = Character.toString(word.charAt(i));
                if (alphabet.containsKey(word.charAt(i))) {
                    wordCounter = alphabet.get(alphaKey);
                    alphabet.put(alphaKey, wordCounter + 1);
                    continue;
                }

                // Insert missing key
                alphabet.put(alphaKey, 1);
            }
        }

        // Update the objects alphabet
        this.setAlphabet(alphabet);
    }



    // -------------------------
    // Setter/-Getter
    // ------------------------


    public Map<String, Integer> getAlphabet() {
        return this.alphabet;
    }

    public void setAlphabet(Map<String, Integer> alphabet) {
        this.alphabet = alphabet;
    }
}
