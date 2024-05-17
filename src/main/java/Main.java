import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);
    String selection = "";

    //used to populate the list with the questions
    PartyQuestions partyQuestions = new PartyQuestions();
    PartyMeter partyMeter = new PartyMeter();

    //bool for the while loop
    boolean isFinished = false;

    List<String> questions = partyQuestions.populateQuestions();

    //array to store the answers
    List<String> answers = new ArrayList<String>();
    
    //this is used to store the user's input after each question
    int currentQuestion = 0;

    System.out.println("Welcome to the Political Party Guesser. \nEnter 1, 2, 3, or 4 to select an option.");

    //Ask each question
    for (String question: questions) 
    { 
      System.out.println( "\n" + question);
      selection = input.nextLine();

      //If the user didn't input a choice they must re-enter
      while(!selection.equals("1") && !selection.equals("2") && !selection.equals("3") && !selection.equals("4"))
      {
        System.out.println("Invalid response. Please enter 1, 2, 3, or 4 to select an option.");
        selection = input.nextLine();
      }

      //The answer is recorded
      answers.add(currentQuestion, selection);
      System.out.println("Your response has been recorded." );
      currentQuestion++;

      //For debugging!
      //if(currentQuestion == 3)
      //{
      //  break;
      //}
    }

    partyMeter.guessParty(answers);
    input.close();
  }  

}