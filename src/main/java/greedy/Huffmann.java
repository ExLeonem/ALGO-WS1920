package greedy;

import divide_conquer.search_sort.Order;
import supplementary.structures.trees.BinaryTree;

import java.util.*;


public class Huffmann {

    private Map<String, Integer> alphabet;
    private PriorityQueue<BinaryTree<String>> encodeUnits;
    private BinaryTree<String> binEncoding;


    public Huffmann(String ...values) {
        this.alphabet = this.buildTable(values);
        this.encodeUnits = this.buildEncodeUnits();
        this.binEncoding = this.buildEncodingTree();
    }


    /**
     * Calculates the huffmann codes for the given alphabet
     * @param values -
     * @return an array of strings representing the encoded string values.
     */
    public String[] encode(String ...values) {

        // Get encoding for each string
        BinaryTree<String> unitTree = this.getBinEncoding();
        LinkedList<String> encodings = new LinkedList<String>();
        for (int i = 0; i < values.length; i++) {

            // Get Encoding for each character
            String encoding = "";
            for (int j = 0; j < values[i].length(); j++) {
                encoding += this.recurseAndCollect(unitTree, String.valueOf(values[i].charAt(j)), "");
            }
            encodings.push(encoding);
        }

        return encodings.toArray(new String[encodings.size()]);
    }


    public String recurseAndCollect(BinaryTree<String> encodingTree, String toSearch, String acc) {

        // Binary tree is null, character not found
        if (encodingTree == null) {
            return "";
        }

        String encodeUnit = encodingTree.getCurrentNodeValue();
        if (encodeUnit.equals(toSearch)) {
            return acc;
        }

        String leftEncoding = this.recurseAndCollect(encodingTree.getLeft(), toSearch, acc + "0");
        String rightEncoding = this.recurseAndCollect(encodingTree.getRight(), toSearch, acc + "1");


        if (!leftEncoding.equals("")) {
            return leftEncoding;
        }
        return rightEncoding;
    }

    /**
     * Encode a single value into a huffmann code.
     *
     * @param value - string value be encoded into an huffmann code.
     * @return string representing the encoded value.
     */
    public String encode(String value) {

        // Save elements into list

        // Sort array of elemnts
        BinaryTree<String> binEncoding = this.getBinEncoding();
        String encoding = "";
        String tmp = "";

        for (int i = 0; i < value.length(); i++) {
            tmp = this.recurseAndCollect(binEncoding, String.valueOf(value.charAt(i)), "");

            if (!tmp.equals("")) {
                encoding += tmp;
                continue;
            }

            // Character that is not encoded! Throw Exception ?
        }

        return encoding;
    }

    /**
     * Builds the initial alphabet of <Word, Count>
     *
     * @param values
     * @return
     */
    public Map<String, Integer> buildTable(String ...values) {

        Map<String, Integer> alphabet = new HashMap<String, Integer>();
        int wordCounter = 0;
        String alphaKey = "";
        for (String value : values) {

            // Update key counter
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
     * Builds a priority queue of unique character occurences
     *
     * @return Priority queue of character occurences
     */
    private PriorityQueue<BinaryTree<String>> buildEncodeUnits() {

        Comparator<BinaryTree<String>> treeComparator = new Comparator<BinaryTree<String>>() {
            @Override
            public int compare(BinaryTree<String> o1, BinaryTree<String> o2) {
                int firstWeight = o1.getWeight();
                int secondWeight = o2.getWeight();
                if (firstWeight > secondWeight) {
                    return 1;
                } else if (firstWeight == secondWeight) {
                    return 0;
                }
                return -1;
            }
        };

        PriorityQueue<BinaryTree<String>> units = new PriorityQueue<BinaryTree<String>>(treeComparator);
        Map<String, Integer> alphabet = this.getAlphabet();
        String[] keys = alphabet.keySet().toArray(new String[alphabet.size()]);
        for (String key: keys) {
            units.add(new BinaryTree<String>(key, alphabet.get(key)));
        }

        return units;
    }

    public BinaryTree<String> buildEncodingTree() {

        PriorityQueue<BinaryTree<String>> encoding = new PriorityQueue<BinaryTree<String>>(this.getEncodeUnits());
        BinaryTree<String> leftTree = null;
        BinaryTree<String> tempTree = null;


        // Edge case, only single charracter encodeable -> put into a subtree to stay recursivly iterateable
        if (encoding.size() == 1) {
            leftTree = encoding.remove();
            BinaryTree<String> newSubTree = new BinaryTree<String>("", leftTree.getWeight());
            newSubTree.setLeft(leftTree);

            return newSubTree;
        }


        // Select two smallest subtrees append
        while (!encoding.isEmpty() && encoding.size() > 0) {

            if (leftTree == null) {
                leftTree = encoding.remove();
                continue;
            }

            tempTree = encoding.remove();

            // Merge sub-trees and append
            if (leftTree.getWeight() > tempTree.getWeight()) {
                BinaryTree<String> subTree = this.mergeTrees(tempTree, leftTree);
                encoding.add(subTree);
            } else {
                BinaryTree<String> subtree = this.mergeTrees(leftTree, tempTree);
                encoding.add(subtree);
            }

            // Reset trees
            leftTree = null;
            tempTree = null;
        }

        return leftTree;
    }


    /**
     * Merges two binary-trees to a new binary tree
     * @param left - left sub-binary tree
     * @param right - right sub-binary tree
     * @return merge binary tree
     */
    private BinaryTree<String> mergeTrees(BinaryTree<String> left, BinaryTree<String> right) {

        BinaryTree<String> copyLeft = left.clone();
        BinaryTree<String> copyRight = right.clone();

        BinaryTree<String> merged = new BinaryTree<String>("",copyLeft.getWeight() + copyRight.getWeight());
        merged.setLeft(copyLeft);
        merged.setRight(copyRight);

        return merged;
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


    // ------------------------------
    // Utilities
    // ------------------------------

    public void printTree() {
        this.printTree(-1);
    }

    public void printTree(int depth) {
        BinaryTree<String> tree = this.getBinEncoding();
        this.printTree(tree, 0, depth, "");
    }


    public void printTree(BinaryTree<String> subtree, int depth, int inDepth, String prefix) {

        // Recursion stop
        if (subtree == null || (inDepth >= 0 && depth > inDepth)) {
            return;
        }

        // Constraint printing tree structure
        if (inDepth >= 0 && (inDepth == depth) || inDepth < 0) {
            // Print information of current tree node
            System.out.println("#################\n"+ prefix + "| Depth: " + depth + "| Node: " + subtree.toString() + "\n+++++++++++++++++");
        }

        // Recurse into subtrees
        depth++;
        this.printTree(subtree.getLeft(), depth, inDepth,  "Left-Subtree");
        this.printTree(subtree.getRight(), depth, inDepth, "Right-Subtree");
    }


    // -------------------------
    // Setter/-Getter
    // ------------------------

    public void setAlphabet(Map<String, Integer> alphabet) {
        this.alphabet = alphabet;
    }

    public void setEncodeUnits(PriorityQueue<BinaryTree<String>> encodeUnits) {
        this.encodeUnits = encodeUnits;
    }

    public void setBinEncoding(BinaryTree<String> binEncoding) {
        this.binEncoding = binEncoding;
    }

    public Map<String, Integer> getAlphabet() {
        return this.alphabet;
    }

    public PriorityQueue<BinaryTree<String>> getEncodeUnits() {
        return this.encodeUnits;
    }

    private BinaryTree<String> getBinEncoding() {
        return this.binEncoding;
    }



    // Node class encapsulating encoding units fort Sorting
    class EncodeUnit implements Comparable<EncodeUnit>, Cloneable {

        private String singleCharacter;
        private String code;
        private int counter;

        public EncodeUnit(String singleCharacter, int counter) {
            this.singleCharacter = singleCharacter;
            this.counter = counter;
        }

        public EncodeUnit(String singleCharacter, int counter, String code) {
            this.singleCharacter = singleCharacter;
            this.counter = counter;
            this.code = code;
        }


        // Check if given character equals the encoded character
        public boolean encodeChar(String character) {
            if (this.getSingleCharacter().equals(character)) {
                return true;
            }
            return false;
        }


        @Override
        public int compareTo(EncodeUnit o) {
            if (o.getCounter() > this.getCounter()) {
                return -1;
            } else if (o.getCounter() == this.getCounter()) {
                return 0;
            }

            return 1;
        }


        @Override
        public EncodeUnit clone() {
            return new EncodeUnit(this.getSingleCharacter(), this.getCounter(), this.getCode());
        }


        @Override
        public String toString() {
            return "Character: " + this.getSingleCharacter() + ", " + this.getCounter();
        }


        // ----------------------------
        // Setter/-Getter
        // ----------------------------

        public void setSingleCharacter(String singleCharacter) {
            this.singleCharacter = singleCharacter;
        }

        public void setCounter(int counter) {
            this.counter = counter;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getSingleCharacter() {
            return singleCharacter;
        }

        public int getCounter() {
            return counter;
        }

        public String getCode() {
            return this.code;
        }
    }
}
