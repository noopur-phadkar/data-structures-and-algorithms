package data_strucutres.trie;

import java.util.ArrayList;

class trieNode{
    char letter;
    boolean isWord;
    ArrayList<trieNode> children = new ArrayList<trieNode>();

    public trieNode(char letter, boolean isWord){
        this.letter = letter;
        this.isWord = isWord;
    }

    public void addChild(trieNode newNode){
        this.children.add(newNode);
    }
}

class Trie{
    trieNode root;

    public Trie(){
        this.root = new trieNode('r', false);
    }

    public void addString(String word){
        /*
         * This function adds the String in the trie. 
         * To add a word it creates a new node per letter if the corresponding node does not already exist.
         * At the end of the path, it adds a special node to indicate that the path from the root to that node consists of a complete word. 
         */
        trieNode current = this.root;
        for ( char letter: word.toCharArray() ) {   // loop through every letter in the string to insert into trie
            boolean letterFound = false;            // flag to indicate if the corresponsding letter node is found in the children if the current node.
            trieNode childWithLetter = null;        // to store the correcponding child node.
            for ( trieNode child: current.children ) {  // loop through all children of current node
                if (child.letter == letter){        // if the corresponding node does exist, set the flag and store the child.
                    letterFound = true; 
                    childWithLetter = child;
                    break;
                }
            }
            if (!letterFound){                      // if letter is not found, create and inset a child for that letter.
                trieNode newNode = new trieNode(letter, false);
                current.addChild(newNode);
                current = newNode;                  // change current to new child to continue through rest of the string.
            } else {                                // if the letter is found, update the current to point to the corresponfing child node.
                current = childWithLetter;
            }
        }
        // Once full string is added to trie, add a special node (if it doesn't exist) to indicate that the above string is a full word.
        for ( trieNode child: current.children ) {  // loop through all children of current node
            if (child.letter == '*'){        //  find if letter exists in child
                return;
            }
        }
        current.addChild(new trieNode('*', true));
    }

    public boolean searchString(String word){
        /*
         * Tihs function searches for the string 'word' in the trie and returns a boolean. 
         * The function returns true if the word exists in the trie and if it is marked as a complete word.
         * The function returns false otherwise. 
         * A complete word is indicated by a special node. 
         */
        trieNode current = this.root;
        for ( char letter: word.toCharArray() ){    // loop through every letter in the string to search through the trie.
            boolean letterFound = false;            // flag to indicate if the corresponsding letter node is found in the children if the current node.
            trieNode childWithLetter = null;            // to store the correcponding child node.
            for ( trieNode child: current.children ){   // loop through all children of current node.
                if ( child.letter == letter ){      // if the corresponding node does exist, set the flag and store the child.
                    letterFound = true;
                    childWithLetter = child;
                    break;
                }
            }
            if (!letterFound){                      // if the corresponding node does not exist, return false.
                return false;
            }
            current = childWithLetter;              // update the current node to continue through rest of the string.
        }
        for ( trieNode child: current.children ){       // if the full string is found in the trie, check if the special complete word node exists.
            if ( child.letter == '*' ){
                return true;                        // return true if it does.
            }
        }
        return false;                               // return false if the special node does not exist.
    }
}

public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.addString("hello");
        System.out.println(trie.searchString("hell"));
        System.out.println(trie.searchString("hello"));
        trie.addString("hello");
        trie.addString("hell");
        System.out.println(trie.searchString("hell"));
    }
}
