import java.lang.*;

public class Oef1 
	{

	public static void main(String args[])
	{
		
	int firstdigit = 1;
	int seconddigit = 1;
	int sum;

	for (int i = 0; i < 9; i++)
	{
		firstdigit = 1;

		for (int j = 0; j < 9; j++)
		{
			sum = firstdigit* seconddigit;
			System.out.println(firstdigit + " x " + seconddigit + " = " + sum);
			firstdigit++;
		}
		seconddigit++;
		System.out.println("");

	}
		
	}
	}