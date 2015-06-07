import java.lang.*;

public class Oef5
{
	public static void main(String args[])
	{
int priemgetallen = 2;
int delers;    
boolean priem;

while (priemgetallen<100)
		{
		priemgetallen+=1;
		delers=2;
		priem=false;

		while((delers<priemgetallen) & (!priem)) {
		if ((priemgetallen%delers)==0) {
		priem=true;
		}
delers+=1;
		}	
if (!priem){
System.out.println(priemgetallen + " is geen priemgetal");
}
}
}
}