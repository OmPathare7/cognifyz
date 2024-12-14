package level1;

import java.util.Random;
import java.util.Scanner;
public class guessNumber
{
	    public static void main(String[] args) 
	    {
	        Random r = new Random();
	        int num = r.nextInt(100)+1;
	        int tried = 0;

	        Scanner scanner = new Scanner(System.in);

	        System.out.println("I'm thinking of a number between 1 and 100");
	        System.out.println("Try to guess it!");

	        while (true) 
	        {
	            System.out.print("Enter your guess: ");
	            int guess = scanner.nextInt();
	            tried++;

	            if (guess < num) 
	            {
	                System.out.println("Too low!");
	            } 
	            else if (guess > num) 
	            {
	                System.out.println("Too high!");
	            } 
	            else 
	            {
	                System.out.println("Congratulations! You found the number in " + tried + " tries.");
	                break;
	            }
	        }
	    }
}


