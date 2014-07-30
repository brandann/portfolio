import java.util.Random;

public class Matrix
{
	//private 
	public static void main(String[] args)
	{
		String[] str = 
		{
		"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r",
		"s","t","u","v","z","x","y","z",
		"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R",
		"S","T","U","V","W","X","Y","Z",
		"1","2","3","4","5","6","7","8","9","0",
		"~","!","@","#","$","%","^","&","*","(",")","_","-","=","+","[","]","{",
		"}",";",".",",",":","?",">","<"
		};
		
		Random r = new Random();
		
		for (int i = 1; i <= 100000; ++i)
		{
			int space = r.nextInt(3);
			if (space == 0)
			{
			int num = r.nextInt(81);
			System.out.print(str[num]);
			}
			else
			System.out.print(" ");
			try
				{Thread.sleep(1L);}
			catch(Exception e)
				{System.out.println(e);}
		}
	}	
}