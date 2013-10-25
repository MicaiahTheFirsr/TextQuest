import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
public class TextQuest 
{
	static Scanner input = new Scanner(System.in);
	static int footsteps = 0;
	static String choice;
	static String fileName;
	static String direction;
	static Cave cave = new Cave();
	static Inventory inven = new Inventory();
	static House house = new House();
	static Desert desert = new Desert();
	public static void main(String[] args) 
	{
		MakeSound sound = new MakeSound();
		
		System.out.println(" Welcome to TextQuest! ");
		System.out.println("What is your name? ");
		inven.name = input.nextLine();
		if(inven.name.equals("god"))
		{
			inven.health = 100000;
			inven.sword = new DiamondSword();
		}
		
		userDirection();
		
		
	}
	
	
	
	public static void userDirection()
	{
		if(inven.hasMap == false)
		{
			System.out.println( inven.name + ", Which direction would you like to go? (North or South)");
			direction = input.nextLine();
			if(direction.equalsIgnoreCase("South"))
			{
				house.startHouse(input, inven);
			}
			else if(direction.equalsIgnoreCase("North"))
			{
				cave.startCave(input, inven);
			}
			else
			{
				System.out.println("Sorry I don't understand your choice!");
			}
				userDirection();
		}
		else if(inven.hasMap == true)
		{
			System.out.println( inven.name + ", Which direction would you like to go? (North or South or West)");
			direction = input.nextLine();
			if(direction.equalsIgnoreCase("South"))
			{
				house.startHouse(input, inven);
			}
			else if(direction.equalsIgnoreCase("North"))
			{
				cave.startCave(input, inven);
			}
			else if(direction.equalsIgnoreCase("West"))
			{
				desert.startDesert(input, inven);
			}
			else
			{
				System.out.println("Sorry I don't understand your choice!");
			}
				userDirection();
		}
		
	}
	
}
