package level2;

import java.util.Scanner;

public class temperatureConverter 
{
	public static void main(String[] args) 
	{
		Scanner scanner=new Scanner(System.in);
		while(true)
		{
		System.out.println("Welcome to Temperature Converter!");
		System.out.println("Select your conversion type :\n1.Celcius to Farenheit\n2.Farenheit to Celcius");
		int input=scanner.nextInt();
		
		switch (input) 
		{
		case 1: 
			{
				System.out.println("Enter temperature:");
				float ip=scanner.nextFloat();
				
				if (ip>-100000 && ip<100000) 
				{
					float fahrenheit=(float) (ip* 1.8 + 32);
					System.out.println("It is: "+fahrenheit +"F");
					break;
				} 
				else 
				{
					System.out.println("Value exceeds -1 lakhs to +1 lakhs");
					break;
				}
				
			}
		
		case 2:
			{
				System.out.println("Enter temperature:");
				float ip=scanner.nextFloat();
				
				if (ip>-100000 && ip<100000)
				{
					float celsius = (float) ((ip - 32) / 1.8);
					System.out.println("It is: " + celsius + "°C");
					break;
				}
				else 
				{
					System.out.println("Value exceeds -1 lakhs to +1 lakhs");
					break;
				}
			}
		}
		}
	}
}
