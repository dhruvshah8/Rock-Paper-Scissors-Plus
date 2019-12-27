/*
 * Program: Rock Paper Scissors Spock Lizard Game
 * Student Name: Dhruv Shah
 * Student Number: 597327
 * Description: Rock Paper Scissors Spock Lizard Game   
*/



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;


public class rockPaperScissors5 extends Applet implements ActionListener {
  
  
  JRadioButton rockB;
  JRadioButton paperB;
  JRadioButton scissorsB;
  JRadioButton lizardB;
  JRadioButton spockB;
  JLabel status;
  String playerC;
  String computerC;
  double random;
  JLabel pic1;
  JLabel pic2;
  JLabel score;
  JLabel scoreC;
  int scoreNum;
  int scoreNumC;
  
  
  public void init () {
    this.setLayout(null);
    
    
    
    JLabel title = new JLabel("Rock, Paper, Scissors Game");
    title.setBackground(Color.GRAY);
    title.setBounds(10, 0, 500, 100);
    title.setFont(new Font("", Font.PLAIN, 30));
    title.setForeground(Color.BLUE);
    
    
    rockB = new JRadioButton("Rock");
    rockB.setActionCommand ("rock");
    
    paperB = new JRadioButton("Paper");
    paperB.setActionCommand ("paper");
    
    scissorsB = new JRadioButton("Scissors");
    scissorsB.setActionCommand ("scissor");
    
    lizardB = new JRadioButton ("Lizard");
    lizardB.setActionCommand ("lizard");
    
    spockB = new JRadioButton ("Spock");
    spockB.setActionCommand ("spock");
    
    
    //the location of the Buttons
    rockB.setBounds(20, 120, 150, 25);
    paperB.setBounds(20, 160, 150, 25);
    scissorsB.setBounds(20, 200, 150, 25);
    spockB.setBounds(20, 280, 150, 25);
    lizardB.setBounds(20, 240, 150, 25);
    
    
    //labels for puic
    JLabel pickOne = new JLabel("Pick One:");
    pickOne.setBounds(15, 100, 100, 10);
    JLabel yourChoice = new JLabel("Your Choice:");
    yourChoice.setBounds(175, 100, 100, 10);
    JLabel computersChoice = new JLabel("Computer's Choice:");
    computersChoice.setBounds(330, 100, 170, 10);
    JLabel yourScore = new JLabel("Your Score:");
    yourScore.setBounds(245, 370, 75, 10);
    JLabel computersScore = new JLabel("Computer's Score:");
    computersScore.setBounds(350, 370, 120, 10);
    status = new JLabel("");
    status.setBounds(220, 281, 80, 10);
    score = new JLabel("0");
    score.setBounds(320, 370, 70, 10);
    scoreC = new JLabel("0");
    scoreC.setBounds(465, 370, 70, 10);
    
    //Creates JLabels which are set as icons to display user choice
    pic1 = new JLabel (createImageIcon ("grey.jpg"));
    pic1.setBounds(170, 120, 130, 150);
    pic2 = new JLabel (createImageIcon ("grey.jpg"));
    pic2.setBounds(315, 121, 130, 150);
    
    
    
    JButton playB = new JButton("Play");
    playB.setBounds(10, 350, 75, 40);
    playB.setActionCommand ("play");
    playB.addActionListener (this);
    JButton resetB = new JButton("Reset Scores");
    resetB.setBounds(110, 350, 100, 40);
    resetB.setActionCommand ("reset");
    resetB.addActionListener (this);
    
    
    
    add(title);
    add (rockB);
    add (paperB);
    add (scissorsB);
    add(lizardB);
    add(spockB);
    add (playB);
    add (resetB);
    add (pickOne);
    add (yourChoice);
    add (computersChoice);
    add (status);
    add (yourScore);
    add (computersScore);
    add (score);
    add (scoreC);
    add (pic1);
    add (pic2);
  }
  
  
  public void actionPerformed (ActionEvent e) {
    
    if (e.getActionCommand ().equals ("reset")) {
      
      scoreNum = 0;  //players score back to 0
      scoreNumC = 0; //computer's score back to 0
      
      pic1.setIcon(createImageIcon ("grey.gif"));
      pic2.setIcon(createImageIcon ("grey.gif"));
      
      //sets each score to 0
      score.setText("0"); 
      scoreC.setText("0");
      status.setText("");
    }
    
    //if user clicks play
    if (e.getActionCommand ().equals ("play")) {
      
      //sets the image to appropriate image and gives var playerC a value of what they selected 
      if (rockB.isSelected() == true) {
        playerC = "rock";
        pic1.setIcon(createImageIcon ("rock.jpg"));
      } else if (paperB.isSelected() == true) {
        playerC = "paper";
        pic1.setIcon(createImageIcon ("paper.jpg"));
      } else if (scissorsB.isSelected() == true ){
        playerC = "scissors";
        pic1.setIcon(createImageIcon ("scissors.png")); 
      }
      else if (lizardB.isSelected() == true ){
        playerC = "lizard";
        pic1.setIcon(createImageIcon ("lizard.jpg")); 
      }
      else{
        playerC = "spock";
        pic1.setIcon(createImageIcon ("spock.jpg")); 
      }
      
      
      random = Math.random();
      
      //if the num is less then 0.2 it is rock
      if (random < 0.2) {
        computerC = "rock";
        pic2.setIcon(createImageIcon ("rock.jpg"));
        
        //is it is less the 0.4
      } else if (random < 0.4) {
        computerC = "paper";
        pic2.setIcon(createImageIcon ("paper.jpg"));
      } 
      else if (random < 0.6) {      
        
        computerC = "scissors";
        pic2.setIcon(createImageIcon ("scissors.png"));
      }
      
      else if (random < 0.8) {      
        
        computerC = "lizard";
        pic2.setIcon(createImageIcon ("lizard.jpg"));
      }
      else {      
        
        computerC = "spock";
        pic2.setIcon(createImageIcon ("spock.jpg"));
      }
      
      //compares and set status 
      status.setText(run(playerC, computerC));
      
      //If the player wins the the players score with go up by one (++)
      if (status.getText() == "You win!") {
        
        scoreNum++;
        score.setText(Integer.toString(scoreNum));
        
       //if player looses then computer's score goes up by 1 (++)
      } else if (status.getText() == "You lose!") {
        
        scoreNumC++;
        scoreC.setText(Integer.toString(scoreNumC));
      }
    }
  }
  
  
  //finds who wins 
  public String run (String choice1, String choice2) {
    
    
   if (choice1 == choice2) {
      return "It's a tie!";
      
   } else if ((choice1 == "rock") && (choice2 == "paper")) {
      return "You lose!";
      
   } else if ((choice1 == "rock") && (choice2 == "scissors")) {
      return "You win!";

    } else if ((choice1 == "paper") && (choice2 == "rock")) {
      return "You win!";
      
    } else if ((choice1 == "paper") && (choice2 == "scissors")) {
      return "You lose!";
      
    } else if ((choice1 == "scissors") && (choice2 == "paper")) {
      return "You win!";
      
    } else if ((choice1 == "scissors") && (choice2 == "rock")){
      return "You lose!";

    } else if ((choice1 == "rock") && (choice2 == "lizard")){
      return "You win!";
      
    } else if ((choice1 == "lizard") && (choice2 == "rock")){
      return "You lose!";

    } else if ((choice1 == "spock") && (choice2 == "rock")){
      return "You win!";

    } else if ((choice1 == "rock") && (choice2 == "spock")){
      return "You lose!";

    } else if ((choice1 == "paper") && (choice2 == "spock")){
      return "You win!";
 
    } else if ((choice1 == "spock") && (choice2 == "paper")){
      return "You lose!";
  
    } else if ((choice1 == "lizard") && (choice2 == "paper")){
      return "You win!";
      
      } else if ((choice1 == "paper") && (choice2 == "lizard")){
      return "You lose!";
      
    } else if ((choice1 == "scissors") && (choice2 == "lizard")){
      return "You win!";
      
    } else if ((choice1 == "lizard") && (choice2 == "scissors")){
      return "You lose!";
      
    } else if ((choice1 == "spock") && (choice2 == "scissors")){
      return "You win!";
      
    } else if ((choice1 == "scissors") && (choice2 == "spock")){
      return "You lose!";
      
    } else if ((choice1 == "lizard") && (choice2 == "spock")){
      return "You win!";
      
    } else {
      return "You lose!";
    }
  }
  
 
  protected static ImageIcon createImageIcon (String path) {
    java.net.URL imgURL = rockPaperScissors5.class.getResource (path);
    if (imgURL != null) {
      return new ImageIcon (imgURL);
    } else {
      System.err.println ("Couldn’t find file: " + path);
      return null;
    }
  }
  
  
}
