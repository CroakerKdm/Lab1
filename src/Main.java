/**
 * @author Croaker
 * @version 1.0.0
 * @project Lab1
 * @class Main
 * @since 15.03.2021 - 18.04
 **/

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("distinctWords.txt");
        String text = new String(Files.readAllBytes(Paths.get("harry.txt")));
        String text1 = text.replaceAll("[^A-Za-z ']", "");
        String longestWord;
        int harryCounter = 0;
        int cLetterCounter = 0;

        String[] words = text1.split(" ");
        String[] sentences = text.split("\\n");

        longestWord = words[0];

        for (String word : words) {
            if (longestWord.length() <= word.length()) {
                longestWord = word;
            }
        }

        for (String sentence : sentences) {
            if (sentence.contains("Harry")) {
                harryCounter += 1;
            }
        }

        StringBuilder stringOfDistinct = new StringBuilder();

        for (String word : words) {
            if (!stringOfDistinct.toString().contains(word)) {
                stringOfDistinct.append(word).append(" ");
            }
        }

        String[] distinctWords = stringOfDistinct.toString().split(" ");
        int equalHashCountDistinct = 0;
        int equalHashCount = 0;

        for (String distinctWord : distinctWords) {
            if (distinctWord.charAt(0) == 'C') {
                cLetterCounter += 1;
            }
        }

        int[] arrayOfHashesDistinct = new int[distinctWords.length];
        for (int i = 0; i < distinctWords.length; i++) {
            arrayOfHashesDistinct[i] = distinctWords[i].hashCode();
        }

        Arrays.sort(arrayOfHashesDistinct);
        for (int i = 0; i < arrayOfHashesDistinct.length - 1; i++) {
            if (arrayOfHashesDistinct[i] == arrayOfHashesDistinct[i + 1]) {
                equalHashCountDistinct += 1;
            }
        }

        int[] arrayOfHashes = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            arrayOfHashes[i] = words[i].hashCode();
        }

        Arrays.sort(arrayOfHashes);
        for (int i = 0; i < arrayOfHashes.length - 1; i++) {
            if (arrayOfHashes[i] == arrayOfHashes[i + 1]) {
                equalHashCount += 1;
            }
        }

        System.out.println("Longest word: " + longestWord); //interestinglooking
        System.out.println("Harry Counter: " + harryCounter); //1084
        System.out.println("С Letter Counter: " + cLetterCounter); //463
        System.out.println("Equal Hash Count Of Distinct Words: " + equalHashCountDistinct); //0
        System.out.println("Equal Hash Count Of All Words: " + equalHashCount); //71424
    }
}
