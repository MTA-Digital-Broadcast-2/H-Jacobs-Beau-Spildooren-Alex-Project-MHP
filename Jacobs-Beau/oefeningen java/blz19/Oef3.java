
public class Oef3 {

      public static void main(String args[])
      {
       int i;
       double plusTwee = 1.0;
       double totaalGetal = 0.0;
       boolean plus = true;
       
       for(i=0;i<9999;i++)
       {
        if(plus)
        {
         totaalGetal += (1.0/plusTwee);
        }
        else
        {
         totaalGetal -= (1.0/plusTwee);
        }
        
        plus = !plus;
        plusTwee += 2.0;
       }
       totaalGetal *= 4.0;
       System.out.println("Pi = "+totaalGetal);
      }

}