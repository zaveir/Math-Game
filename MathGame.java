package project;

import java.util.Scanner;
import java.lang.Math;

public class MathGame
{
	private String playerName;
	private int winningScore;
	private int score;
	private int totalRounds;
	private int rounds;
	
	public MathGame()
	{
		playerName = "";
		winningScore = (int)(Math.random() * 6) + 5;
		score = 0;
		totalRounds = (int)(Math.random() * 6) + 15;
		rounds = 1;
	}
	
	private static int[] add()
	{
		int num1 = (int)(Math.random() * 50) + 1;
		int num2 = (int)(Math.random() * 50) + 1;
		int answer = num1 + num2;
		int[] nums = {num1, num2, answer};
		return nums;
	}
	
	private static int[] subtract()
	{
		int num1 = (int)(Math.random() * 50) + 1;
		int num2 = (int)(Math.random() * 50) + 1;
		int answer;
		int[] nums = new int[3];
		if (num1 >= num2)
		{
			answer = num1 - num2;
			nums[0] = num1;
			nums[1] = num2;
		}
		else
		{
			answer = num2 - num1;
			nums[0] = num2;
			nums[1] = num1;
		}
		nums[2] = answer;
		return nums;
	}
	
	private static int[] multiply()
	{
		int num1 = (int)(Math.random() * 12) + 1;
		int num2 = (int)(Math.random() * 12) + 1;
		int answer = num1 * num2;
		int[] nums = {num1, num2, answer};
		return nums;
	}
	
	private static int[] divide()
	{
		int num1 = (int)(Math.random() * 12) + 1;
		int num2 = (int)(Math.random() * 12) + 1;
		int product = num1 * num2;
		int answer = num1;
		int[] nums = {product, num2, answer};
		return nums;
	}
	
	public void play()
	{
		Scanner input = new Scanner(System.in);
		System.out.print("What is your name? ");
		playerName = input.nextLine();
		
		System.out.println("\nWinning Score: " + winningScore);
		System.out.println("Total Rounds: " + totalRounds);
		
		while (score >= 0 && score < winningScore && rounds <= totalRounds)
		{
			System.out.println("\nCurrent Round: " + rounds);
			System.out.println("Current Score: " + score);
			int operation = (int)(Math.random() * 4) + 1;
			int[] nums = new int[3];
			String opSymbol = "";
			
			
			if (operation == 1)
			{
				nums = add();
				opSymbol = "+";
			}
			else if (operation == 2)
			{
				nums = subtract();
				opSymbol = "-";
			}
			else if (operation == 3)
			{
				nums = multiply();
				opSymbol = "x";
			}
			else
			{
				nums = divide();
				opSymbol = "/";
			}
			
			System.out.print(playerName + ", " + nums[0] + " " + opSymbol + " " + nums[1] + " = ");
			if (input.nextInt() == nums[2])
			{
				System.out.println("Correct!\n");
				score++;
			}
			else
			{
				System.out.println("Incorrect.\n");
				score--;
			}
			
			rounds++;
		}
		
		System.out.println("Current Score: " + score);
		
		if (score >= winningScore)
		{
			System.out.println("\nCongratulations " + playerName + ", you won!");
		}
		else
		{
			System.out.println("\nI'm sorry " + playerName + ", you lost :(");
		}
	}
	
	public static void main(String[] args)
	{
		MathGame myGame = new MathGame();
		myGame.play();
	}
}
