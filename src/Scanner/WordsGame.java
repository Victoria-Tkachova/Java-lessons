package Scanner;

import java.util.*;

public class WordsGame {

    static ArrayList<String> listOfWords = new ArrayList<>();
    String guess, madeWord;
    int totalGuess;
    Scanner scan = new Scanner(System.in);
    List<Character> madeWordChar;


    static {
        Collections.addAll(listOfWords, "elephant", "alphabet", "rabbit", "crime", "murder", "attic", "leg");
    }

    String wordsMaker(ArrayList listOfWords) {
        String madeWord = "";
        String madeWord1 = null;
        System.out.println("Choose the word!");
        Scanner scan = new Scanner(System.in);
        if (scan.hasNextLine()) {
            String st1 = scan.nextLine();
            for (int i = 0; i < listOfWords.size(); i++) {
                if (listOfWords.contains(st1) == true) {
                    madeWord1 = st1;
                } else {
                    System.out.println("There is no such word in the list. Try another word!");
                    // scan.nextLine();
                }
            }
        } else {
            System.out.println("It is not a word! Try again!");
        }
        for (int i = 0; i < madeWord1.length(); i++) {
            madeWord += "*";
        }

        return madeWord;
    }

    void guess(String madeWord) {
        List<Integer> madeWordPositions = getMaskPositions (madeWord);
        StringBuilder madeWord1 = new StringBuilder(madeWord);
        while (madeWord.toString().contains("*") && totalGuess < 10) {
            for (int i=0; i < madeWord.length(); i++) {
                char guess = getNextGuess();
                for (Integer position : madeWordPositions) {
                    if (madeWord1.charAt(position) == guess)
                    {
                        // guess is correct: replace the star with the right letter
                        madeWord1.setCharAt (position, guess);
                    }
                }
                // now re-display the masked word (showing any correctly-guessed letters):
                System.out.println(madeWord1);
            }
            // no more dashes left: all missing letters correctly guessed:
            System.out.println( "Well Done!" );
            break;
            }
        }



    List<Integer> getMaskPositions(String madeWord) {
        List<Integer> result = new ArrayList<>();
        for (int i=0; i < madeWord.length(); i++) {
            result.add(Arrays.asList(madeWord).indexOf(i));
        }
        return result;
    }

    char getNextGuess() {
        System.out.println("Guess any letter! Your letter is: ");
        guess = scan.next().toLowerCase();
        System.out.println(guess);
        totalGuess++;
        guess = guess.replaceAll("[^!-~\\u20000-\\uFE1F\\uFF00-\\uFFEF]", "");
        char[] charArray = guess.toCharArray();
        char result = charArray[0];
        return result;

    }


    public static void main (String[]args){
            System.out.println(listOfWords);
            WordsGame obj = new WordsGame();
            String guess = obj.wordsMaker(listOfWords);
            System.out.println(guess);
            obj.guess(guess);


        }



}

