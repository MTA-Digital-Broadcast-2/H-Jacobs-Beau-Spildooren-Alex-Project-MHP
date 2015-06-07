import java.lang.*;

public class Oef6
{
	public static void main(String args[])
{
int a[] = {12,34,56,78,123,234,99,88};
int grootstegetal =0;
int j;

for (int i = 0; i<a.length;i++){
if (i !=0)
{
j=i-1;
}
else
{
j=0;
}
if(a[i] > a[j])
{
grootstegetal = a[i];
}
}
System.out.println("Het grootste getal is " + grootstegetal);
}
}