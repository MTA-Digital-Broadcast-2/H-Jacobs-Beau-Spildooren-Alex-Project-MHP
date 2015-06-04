
public class Oef7 {

      public static void main(String args[])
      {
       int a[] = {12,34,56,78,123,234,99,88};
       int b[];
       b = new int[8];
       int grootsteGetal;
       int grootsteIndex;

       for(int j = 0;j<b.length;j++)
       {
        grootsteGetal = 0;
        grootsteIndex = 0;

        for(int i = 0;i<a.length;i++)
        {

         if(a[i]>grootsteGetal)
         {
          grootsteGetal = a[i];
          grootsteIndex = i;
         }

        }

        b[j] = grootsteGetal;
        a[grootsteIndex] = 0;

       }
       
        System.out.println(b[0] + " " + b[1] + " " + b[2] + " " + b[3] + " " + 
                           b[4] + " " + b[5] + " " + b[6] + " " + b[7] );
      }

}