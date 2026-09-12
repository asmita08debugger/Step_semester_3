package main.java.string_concepts.class_problems;
import java.util.Random;
import java.util.Scanner;
public class RockPaperScissors 
{
    static String playRound(String playerMove, String computerMove) 
    {
        if (playerMove.equals(computerMove))
            return "Draw";
        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) || (playerMove.equals("Paper") && computerMove.equals("Rock")) || (playerMove.equals("Scissors") && computerMove.equals("Paper")))
            return "Player Wins";
        return "Computer Wins";
    }
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        String[] moves = {"Rock", "Paper", "Scissors"};
        int wins = 0;
        int losses = 0;
        int draws = 0;
        System.out.println("Round | Player | Computer | Result");
        for (int round = 1; round <= 5; round++) 
        {
            System.out.print("Enter Rock, Paper or Scissors: ");
            String playerMove = sc.nextLine();
            String computerMove = moves[random.nextInt(3)];
            String result = playRound(playerMove, computerMove);
            System.out.println(round + " | " + playerMove + " | " + computerMove + " | " + result);
            if (result.equals("Player Wins")) 
            {
                wins++;
            } 
            else if (result.equals("Computer Wins")) 
            {
                losses++;
            } 
            else 
            {
                draws++;
            }
        }
        double winPercentage = (wins / 5.0) * 100;
        System.out.println("\nFinal Summary");
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.println("Win % = " + winPercentage + "%");
        sc.close();
    }
}