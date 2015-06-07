import java.lang.*;

public class Oef3
{
	public static void main(String args[])
	{

	int i;
        
	boolean bewerking = false;
        
	float som = 1;
 
       
	for(i = 1; i < 10001; i++) 
		{

            	if(!bewerking) 
			{
                
			som -= 1 / (float) (i + (i+1));
                
			bewerking = true;
  
			} 
		else 
			{
                
			som += 1 / (float) (i + (i+1));
                
			bewerking = false;
            
			}
       
		 }
        
		System.out.println("pi = " + (4 * som));
   
 	}
    
}
