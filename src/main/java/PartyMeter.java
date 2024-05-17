import java.util.*;
import java.io.*;
import java.io.FileWriter;

//The party meter class grades the answers provided by the user
public class PartyMeter
{
  private static Scanner file;
  static int rows;
  
  private File democratFile = new File("democrat.csv");
  private File republicanFile = new File("republican.csv");
  private File socialistFile = new File("socialist.csv");
  private File greenpartyFile = new File("greenparty.csv");

  //The file the program will write to when updating the political party data
  //private File partyData;
  
  //List of the elements in the file
  private List<String> userData;
  private List<String> partyData;
  

  public PartyMeter() 
  {
    //if this file does not exist, none have been created, so create and populate the rows
    if (!democratFile.exists())
    {
      File[] partyFiles = new File[]{democratFile, republicanFile, socialistFile, greenpartyFile}; 

      for (File partyFile: partyFiles) 
      {
        try 
        {
          partyFile.createNewFile(); // if file already exists will do nothing 

          try
          {
            FileWriter writer = new FileWriter(partyFile); 

            //fill the 20 questions rows with blank data
            for (int i = 0; i < 20; i++)
            {
              System.out.println("Writing row " + i + " " + partyFile.getName());
              
              writer.write( "0,0,0,0" + System.lineSeparator());

            }
            writer.close();
          }

          catch (IOException e) 
          {
            e.printStackTrace();
            System.out.println("Saving to a text file failed...");
          }
        } 
          
        catch (IOException e) 
        {
          System.out.println("An error occurred while creating the file: " + e.getMessage());
        }
      }
    }

  }

  //Determines the users party and passes that information along to the results recorder
  public void selectParty(String party, List<String> answers)
  {
    if (party.toLowerCase().equals("democrat"))
    {
      System.out.println("Ah so you're a democrat!");
      prepareResults(democratFile, answers);
    }

    else if (party.toLowerCase().equals("republican"))
    {
      prepareResults(republicanFile, answers);
    }

    else if (party.toLowerCase().equals("socialist"))
    {
      prepareResults(socialistFile, answers);
    }

    else if (party.toLowerCase().equals("greenparty"))
    {
      prepareResults(greenpartyFile, answers);
    }
  }

  //Sets up the users answers to be checked against party answers
  public void prepareResults(File partyFile, List<String> answers) 
  {
    
    ArrayList<ArrayList<String>> questionContainer = new ArrayList<ArrayList<String>>();

    try {
        //file = new Scanner(Paths.get("democrat.csv"));
        file = new Scanner(partyFile);
      
    } catch (IOException e) {
        System.out.println("An error occurred while reading the file: " + e.getMessage());
    }


    while (file.hasNextLine()) 
    {
   
   
        ArrayList<String> answersContainer = new ArrayList<String>();
        final String nextLine = file.nextLine();
 
        final String[] selection = nextLine.split(",");


        for (int i = 0; i < selection.length; i++) {
            answersContainer.add(selection[i]);
        }
      
        questionContainer.add(answersContainer);
  
        rows++;
        Arrays.fill(selection, null); // to clear out the 'items' array

    }

    for (int i = 0; i < answers.size(); i++) 
    {

      //the selection is the position of the choice the user made for the question (1, 2, 3, 4)
      
      int selection = Integer.parseInt(answers.get(i)) - 1;

      System.out.println("You answered " + answers.get(i) + " for question " + (i + 1));
      
      //the selection Value is the actual score/value for that choice for their selected party
      //(ex. Democrats selected this value 10 times)
      
      
      
      int selectionValue = Integer.parseInt(questionContainer.get(i).get(selection));

      //This takes the current question being analyzed, and adds 1 point to the selected answer for the party
      //(ex. If the democrats selected A 4 times and was selected by the user it would go to 5)
      
      questionContainer.get(i).set(selection, Integer.toString(selectionValue + 1));
      
      System.out.println("Question " + (i + 1) + " is now " + questionContainer.get(i));


    }

    recordResults(partyFile, questionContainer, answers);
    
  }

  //records the users answers to their party
  public void recordResults(File partyFile, ArrayList<ArrayList<String>> answers, List<String> userAnswers)
  {
    try
    {
        FileWriter writer = new FileWriter(partyFile); 
        for(ArrayList<String> answer: answers) {
          writer.write(answer.get(0) + "," + answer.get(1) + "," + answer.get(2) + "," + answer.get(3) + System.lineSeparator());
        }
      writer.close();
    }

    
    catch (IOException e) {
        e.printStackTrace();
        System.out.println("Saving to a text file failed...");
    }

    System.out.println("I've updated my knowledge banks! Thank you for helping me improve my guessing skills!");
    //guessParty(userAnswers);

  }


  // uses the current data for the party's responses with the user's answers to guess the user's party
  public void guessParty(List<String> answers)
  {
    //containers to hold to previous results of all the parties for comparison along with party scores
    double democrat = 0;
    ArrayList<ArrayList<String>> democratContainer = new ArrayList<ArrayList<String>>();
    
    double republican = 0;
    ArrayList<ArrayList<String>> republicanContainer = new ArrayList<ArrayList<String>>();
    
    double socialist = 0;
    ArrayList<ArrayList<String>> socialistContainer = new ArrayList<ArrayList<String>>();
    
    double greenparty = 0;
    ArrayList<ArrayList<String>> greenpartyContainer = new ArrayList<ArrayList<String>>();

    ArrayList<ArrayList<ArrayList<String>>> partyContainers = new ArrayList<ArrayList<ArrayList<String>>>();
    partyContainers.add(democratContainer);
    partyContainers.add(republicanContainer);
    partyContainers.add(socialistContainer);
    partyContainers.add(greenpartyContainer);

    //used to track which container to load each party's answers to
    int containerCount = 0;

    //used to iterate through the files
    File[] partyFiles = new File[]{democratFile, republicanFile, socialistFile, greenpartyFile};

    //scans each file for their party answers and adds them to their respective container
    for (File partyFile: partyFiles)
    {
        try {
            //file = new Scanner(Paths.get("democrat.csv"));
            file = new Scanner(partyFile);

        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }


        while (file.hasNextLine()) 
        {
            ArrayList<String> answersContainer = new ArrayList<String>();
            final String nextLine = file.nextLine();

            final String[] selection = nextLine.split(",");

            for (int i = 0; i < selection.length; i++) {
                answersContainer.add(selection[i]);
            }
            partyContainers.get(containerCount).add(answersContainer);
            //democratContainer.add(answersContainer);

            rows++;
            Arrays.fill(selection, null); // to clear out the 'items' array

        }

        containerCount++;
    }
    
    //compares the user's answer for each question to each party's total answers for that question
    //and adds 1 to the party's score who had the highest number of responses
    for (int i = 0; i < answers.size(); i++) 
    {
      //this is the answer the user originally chose, this will be used to compare the parties
      //which will determine the dominant party for that answer and add 1 to the score
      int answerChoice = Integer.parseInt(answers.get(i)) - 1;

      //the parties current score get placed in ints along with a leading score initialized to 0
      int democratScore = Integer.parseInt(democratContainer.get(i).get(answerChoice));
      int republicanScore = Integer.parseInt(republicanContainer.get(i).get(answerChoice));
      int socialistScore = Integer.parseInt(socialistContainer.get(i).get(answerChoice));
      int greenpartyScore = Integer.parseInt(greenpartyContainer.get(i).get(answerChoice));

      ArrayList<Integer> partyScores = new ArrayList<Integer>();
      partyScores.add(democratScore);
      partyScores.add(republicanScore);
      partyScores.add(socialistScore);
      partyScores.add(greenpartyScore);

      //sorts to party scores to consistently check the ranking order in the weigh scores method
      Collections.sort(partyScores);

      democrat += weighScores(partyScores, democratScore);
      republican += weighScores(partyScores, republicanScore);
      socialist += weighScores(partyScores, socialistScore);
      greenparty += weighScores(partyScores, greenpartyScore);
      
    }

    //takes all of the scores added up and places them in a list to determine which party had the most points
    ArrayList<Double> finalScores = new ArrayList<Double>();
    finalScores.add(democrat);
    finalScores.add(republican);
    finalScores.add(socialist);
    finalScores.add(greenparty);

    double winningScore = Collections.max(finalScores);

    //compares the scores to determine the party to guess
    if (winningScore == democrat)
    {
      System.out.println("Your responses tell me that your values are Democratic!");
    }

    else if (winningScore == republican)
    {
      System.out.println("Your responses tell me that your values are Republican!");
    }

    else if (winningScore == socialist)
    {
      System.out.println("Your responses tell me that your values are Socialist!");
    }

    else if (winningScore == greenparty)
    {
      System.out.println("Your responses tell me that your values are Green Party!");
    }

    //asks the user for their party in order to associate their answers with their actually party
    askParty(answers);

  }

  // returns a value based on the place each party came in for an answer, last place awards nothing
  public double weighScores(ArrayList<Integer> partyScores, int partyScore)
  {
    double weight = 0;

    if (partyScore == partyScores.get(1))
    {
      weight += 0.50;
    }

    else if (partyScore == partyScores.get(2))
    {
      weight += 0.75;
    }

    else if (partyScore == partyScores.get(3))
    {
      weight += 1;
    }

    return weight;
  }
  
  //asks the user what their actual party is so it can update its data appropriately
  public void askParty(List<String> answers)
  {
    System.out.println("What is your actual political affiliation? \n1.Democrat \n2.Republican \n3.Socialist \n4.Green Party");

    Scanner input = new Scanner(System.in);
    String selection = "";
    selection = input.nextLine();

    //If the user didn't input a choice they must re-enter
    while(!selection.equals("1") && !selection.equals("2") && !selection.equals("3") && !selection.equals("4"))
    {
      System.out.println("Invalid response. Please enter 1, 2, 3, or 4 to select an option.");
      selection = input.nextLine();
    }
    
    if (selection.equals("1"))
    {
      selectParty("democrat", answers);
    }

    else if (selection.equals("2"))
    {
      selectParty("republican", answers);
    }

    else if (selection.equals("3"))
    {
      selectParty("socialist", answers);
    }

    else if (selection.equals("4"))
    {
      selectParty("greenparty", answers);
    }
  }
}