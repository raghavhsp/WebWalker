package CodePracticeForInterview;

import java.util.ArrayList;

public class ReverseStringMaintaingSpaceOrder {
	
	public static void main (String ar[])
	{
		String str = "Hello Good Morning There World";
		
		ArrayList<Integer> spaceList = new ArrayList<>();
		
		for (int i=0 ; i<str.length()-1; i++)
		{
			if (str.charAt(i)==' ')
				spaceList.add(i);
		}
		
		str= str.replace(" ", "");
		
		
		StringBuilder strBuilder = new StringBuilder(str);
		strBuilder.reverse();
		
		for (Integer i : spaceList)
		{
			strBuilder.insert(i, " ");
		}
		
		System.out.println(strBuilder.toString());
	}

}