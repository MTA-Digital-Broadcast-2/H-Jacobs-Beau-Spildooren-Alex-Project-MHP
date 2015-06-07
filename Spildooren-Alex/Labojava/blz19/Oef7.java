import java.lang.*;
import java.util.Arrays;

public class Oef7
{
	public static void main(String args[])
{
	int a[] = {12,34,56,78,123,234,99,88};
	int b[]=new int [8];
	int grootstegetal =0;
	int j;
	int n=0;

	for (int i = 0; i<8;i++)
	{
		for(int c=0;c<a.length;c++)
		{
			if (c !=0)
			{
				j=c-1;
			}
			else
			{
				j=0;
			}
	
			if(a[c] > a[j])
			{
			grootstegetal = a[c];
			for(int k = 0; k < a.length; k++) 
			{
                if(a[k] == grootstegetal) {
                    a[k] = 0;
                }
			}}
		}
		System.out.println(grootstegetal);
		b[i]=grootstegetal;
		
	}
	//System.out.println("array b ={"+b[0]+","+a[1]+","+a[2]+","+a[3]+","+a[4]+","+a[5]+","+a[6]+","+a[7]+"}");
	System.out.println(Arrays.toString(b));
	}
}