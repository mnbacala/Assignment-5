
package assignment05;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Martin Bacala C202 Programming Assignment 5 The method outputs
 * results for BinarySearchTree and displays average number of words, words not
 * found, words found and their comparisons, and words not found in their
 * comparisons.
 */
public class Assignment05 {

    /**
     *
     */
    public static void main(String[] args) throws FileNotFoundException {
        long wordsFound = 0;
        long wordsNotFound = 0;
        long compsFound = 0;
        long compsNotFound = 0;
        int[] count = new int[1];

        BinarySearchTree[] dict = new BinarySearchTree[26];
        for (int i = 0; i < dict.length; i++) {
            dict[i] = new BinarySearchTree<String>();
        }//for

        java.io.File readFile = new java.io.File("random_dictionary.txt");
        Scanner input = new Scanner(readFile);

        //Adds all words into BinarySearchTree sorted by 'a'
        while (input.hasNextLine()) {
            String s = input.nextLine();
            s = s.replaceAll("\\s+", "");
            s = s.toLowerCase();
            dict[s.charAt(0) - 97].insert(s);
        }//while

        java.io.File readFile1 = new java.io.File("oliver.txt");
        Scanner scanOliver = new Scanner(readFile1);
        while (scanOliver.hasNext()) {
            //String wordstr = 
            //dict [(int)wordstr.charAt(0) - 97].insert(wordstr) ; 
            try {
                String wordsToSearch = scanOliver.next();
                wordsToSearch = wordsToSearch.replaceAll("[^a-zA-Z]", "");
                wordsToSearch = wordsToSearch.toLowerCase();
                int indexSearch = (wordsToSearch.charAt(0) - 97);
                if (dict[indexSearch].search(wordsToSearch, count)) {
                    wordsFound++;
                    compsFound += count[0];
                }//if
                else {
                    wordsNotFound++;
                    compsNotFound += count[0];
                }//else
            }//try
            catch (StringIndexOutOfBoundsException e) {
                scanOliver.next();
            }//catch
        }//while

        Assignment05 a = new Assignment05();
        float avgCompsFound = compsFound / wordsFound;
        System.out.println("Average Number of Words Found: " + avgCompsFound);
        float avgCompsNotFound = compsNotFound / wordsNotFound;
        System.out.println("Average Number of Words Not Found: " + avgCompsNotFound);
        System.out.println("Number of Words Found: " + wordsFound + " in " + compsFound + " comparisons");
        System.out.println("Number of Words Not Found: " + wordsNotFound + " in " + compsNotFound + " comparisons");
    }//main

}//Assignment05
