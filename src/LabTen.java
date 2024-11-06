import java.util.Arrays;
import java.util.Scanner;
public class LabTen {
    public static void main(String[] args) {
        System.out.print("1.----------------\n");
        int player1 = getPlayerChoice("Player 1: ");
        int player2 = getPlayerChoice("Player 2: ");

        System.out.print(determineWinner(player1, player2));
        wins(determineWinner(player1,player2)); //Passes method into wins method to check winner

        System.out.print("2.-----------------\n");

        String[] words = {"apple", "banana", "cherry", "date", "elderberry"};
        //Call the playGame method
        playGame(words);

        System.out.print("3.-------------\n");
        int[] numbers = {1,2,3,4,5,6,7,10,11};
        System.out.print(Arrays.toString(copyArr(numbers)));
        System.out.print("\n4.----------------\n");
        double[]grades={98.6,78.2,56.9};
        double exam = 88.8;
        System.out.print(Arrays.toString(newGrades(grades,exam)));

        System.out.print("\n5.-----------------\n");
    int[] a={56,9,17,6,2,0,1,199,256,94};
    evenOdd(a);

    }
    public static String determineWinner(int player1, int player2) {
        String[] choices={"rock","paper","scissors"};

        if (choices[player1].equals(choices[0])  && choices[player2].equals(choices[2])) {
            return "Player 1 wins!";
        } else if (choices[player1].equals(choices[2]) && choices[player2].equals(choices[1])) {
            return "Player 1 wins!";
        } else if (choices[player1].equals(choices[1])  && choices[player2].equals(choices[0])) {
            return "Player 1 wins!";
        } else if (choices[player1].equals(choices[player2])) {
            return "It's a tie!";} else {
            return "Player 2 wins!";
        }
    }
    public static int getPlayerChoice(String player) {
        Scanner input = new Scanner(System.in);
        System.out.print(STR."\{player}, enter your choice (0 = rock, 1 = paper, 2 = scissors): ");
        return input.nextInt();
    }


        public static void wins(String str){
        int player1Wins = 0;
        int player2Wins = 0;
        int[] wins ={player1Wins,player2Wins};
        if(str.equals("Player 1 wins!")){
            player1Wins++;
            wins[0]= player1Wins;
        }else if(str.equals("Player 2 wins!")){
            player2Wins++;
            wins[1]=player2Wins;
        }
        System.out.println(STR."\nPlayer 1 Wins: \{player1Wins} \nPlayer 2 Wins: \{player2Wins}");
    }


public static void playGame(String[] words) {
//Choose a random word
    int rand = (int)(Math.random()*words.length);
    String randomWord = words[rand];
//Create a char array to store the guessed word

//Fill the guessed word with stars
    char[] letters = randomWord.toCharArray();
    char[]hiddenArr = new char[letters.length];
//Print the guessed word (initially all stars)
    Arrays.fill(hiddenArr, '*');
//Start a scanner for the users input
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a letter: ");

//Get the users guessCount
//Create a variable to store the number of guesses
    int guessCount =0;
//Create a loop to play the game
while(guessCount <6 && hasStars(hiddenArr)){

    System.out.println("Current word: " + Arrays.toString(hiddenArr)+"\n Guess a letter: ");
//Prompt the user to guessCount a letter
    char userGuess = input.next().charAt(0);
    //Create a boolean to check if the guessCount is correct
    boolean found = false;
    //Check if the user has guessed the word or run out of guesses
    for(int i =0; i< letters.length; i++){
        if(userGuess == letters[i]){
            //Loop through the word to check if the guessCount is correct
            hiddenArr[i]= userGuess;//reveals letter //If the guessCount is correct, reveal the letter
            //Set correctGuess to true
            found = true;
        }
    }
        if(found){
            System.out.println("Good guess!");

        }else{
            //If the guessCount is incorrect, increment the number of guesses
            guessCount++;
            System.out.print("The letter " + userGuess +" is not in this word\n");
        }

        if(Arrays.equals(hiddenArr, letters)){
            //If the user has guessed the word, print a message
            System.out.println("Congratulations you have guessed the word " + randomWord);
            return;
        }

    }
//If the user has run out of guesses, print a message
    System.out.println("Hangman! Game over! The word is "+randomWord);
}
















public static boolean hasStars(char[] array) {
    for (int i = 0; i < array.length; i++) {
        if (array[i] == '*') {
            return true;
        }
    }
    return false;
}
//Question 3
    public static int[] copyArr(int[] nums){
       return Arrays.copyOf(nums, nums.length);


    }
//Question 4
    public static double[] newGrades(double[] nums, double num){
        double[]newGrades = Arrays.copyOf(nums,nums.length +1);

        newGrades[nums.length]=num;
    return newGrades;
    }
//    Question 5
    public static void evenOdd(int[] nums){
        int[] even= {};
        int[] odd = {};
        int evenCount = 0;
        int oddCount = 0;
        for(int num: nums){
            if(num %2 ==0){
                evenCount++;


            } else {
                oddCount++;

            }
        }

        even=new int[evenCount];
        odd =new int[oddCount];
        int evenIndex = 0;
        int oddIndex = 0;
        for(int num: nums){
            if(num % 2==0){
                even[evenIndex++]= num;
            }
            else{
                odd[oddIndex++]=num;
            }
        }
System.out.print(STR."The even array is \{Arrays.toString(even)}\nThe odd array is \{Arrays.toString(odd)}");


    }


}

//Create a method to check if the guessed word has any stars left




