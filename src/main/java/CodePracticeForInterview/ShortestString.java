package CodePracticeForInterview;

public class ShortestString {
	
	public static void main (String str[])
	{
		String string= "Java is fun programming";
		
		String[] words =string.split("a");
		
		
		
		String shortestString=null;
		
		for (String word : words)
		{
			System.out.println(word);
		}
		
		System.out.println("Shortest Word in give string ("+string+") is :"+shortestString);
		
	}

}
