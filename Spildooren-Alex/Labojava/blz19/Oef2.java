import java.lang.*;
/**
*"Oefxx" is een java applicatie
*@author Alex Spildooren
*/
public class Oef2{
	public static void main(String args[])
		{
		int i,b=0;
		String c[]={"zondag","maandag","dinsdag","woensdag","donderdag","vrijdgag","zaterdag"};
		for(i=1;i<29;i++)
		{
			
			if (b==7)
				{b=0;}
			
			System.out.println(c[b]+" "+i+" Februari");
			b++;
		}
		}
}
	
	