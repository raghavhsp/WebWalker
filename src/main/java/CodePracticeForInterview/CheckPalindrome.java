package CodePracticeForInterview;

public class CheckPalindrome {
	
	public static void main (String ar[])
	{
		String first="ara";
		
		
		StringBuilder strBuilder = new StringBuilder(first);
		StringBuilder reversedString = strBuilder.reverse();
		System.out.println(reversedString.toString().equals(first));
	}

}
