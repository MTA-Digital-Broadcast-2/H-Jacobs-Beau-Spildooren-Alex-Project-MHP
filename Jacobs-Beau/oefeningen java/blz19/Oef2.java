

public class Oef2 {

      public static void main(String args[])
      {
       int dag = 6;
       int i;
       String[] dagen = {"Maandag","Dinsdag","Woensdag","Donderdag",
                         "Vrijdag","Zaterdag","Zondag"};
       
       
       for(i=1;i<29;i++)
       {
        System.out.println(dagen[dag]+" "+i+" februari");
  
  
  
        if (dag>=6)
        {
         dag = 0;
        } 
        else 
        {
         dag++;
        }
       }
      }


}