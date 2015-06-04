
public class Oef5 {

      public static void main(String args[])
      {
       boolean noPriem = false;       

       for (int i=3;i<100;i++)
       {
        noPriem = false;        

        for(int j=2;j<i;j++)
        {
         if (i%j == 0)
         {
          noPriem = true;
         }
        }

        if (!noPriem)
        {
         System.out.println(i+"\n");
        }

       }
      }

}