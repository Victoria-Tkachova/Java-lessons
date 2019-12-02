package Scanner;

import java.util.*;

public class WordsGame {

    static ArrayList<String> listOfWords = new ArrayList<>();
    String guess, madeWord;
    int wrongGuess;
    Scanner scan = new Scanner(System.in);
    List<Character> madeWordChar;
    String secretWord;
    String guessedWord;

    static {
        Collections.addAll(listOfWords, "elephant", "alphabet", "rabbit", "crime", "murder", "attic", "leg");
    }

    void wordsMaker() {
        Random wordsMaker = new Random();
        int wordIndex = wordsMaker.nextInt(listOfWords.size() - 1);
        guessedWord = listOfWords.get(wordIndex);
        System.out.println(guessedWord);
        StringBuilder starConverter = new StringBuilder();
        for (int i = 0; i < guessedWord.length(); i++) {
            starConverter.append("*");
        }
        secretWord = starConverter.toString();
        System.out.println(secretWord);
    }

    void guessLetter() {
        while (wrongGuess < 10) {
            System.out.println(secretWord);
            System.out.println("Guess any letter. Your letter is: ");
            Scanner scan = new Scanner(System.in);
            String choice = scan.nextLine().toLowerCase();
            int index = guessedWord.indexOf(choice);
            if (index == -1) {
                wrongGuess++;
                System.out.println("There is no such letter in the word!");
            }
            while (index != -1) {
                replaceStar(choice, index);
                if (secretWord.length() < index) {
                index = guessedWord.indexOf(choice, index + 1);} // проверка если буква последняя, может вылететь исключение
            }
            if (secretWord.equals(guessedWord) == true) {
                System.out.println("Well Done!");
                break;
            }
        }
    }

    private void replaceStar(String letter, int index) {
        char[] wordArray = secretWord.toCharArray();
        wordArray[index] = letter.charAt(0);
        secretWord = String.copyValueOf(wordArray);
    }


    List<Integer> getMaskPositions(String madeWord) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < madeWord.length(); i++) {
            result.add(Arrays.asList(madeWord).indexOf(i));
        }
        return result;
    }



    public static void main(String[] args) {
        System.out.println(listOfWords);
        WordsGame obj = new WordsGame();
        obj.wordsMaker();
        obj.guessLetter();


    }


}

