package com.incubyte;
import java.util.*;


// exception for negative numbers
class MyException extends Exception
{
 public MyException(ArrayList<Integer> str)
 {
  System.out.println("negatives not allowed"+str);
 }
}

public class string_calculator  {

	public static void main(String[] args) throws MyException 
	{
		// TODO Auto-generated method stub
      System.out.println( add("//[***]\n1***2***3"));
	}

	
	public static int add(String numbers) throws MyException

	{		
        // empty string
		if(numbers =="") return 0;
		
		String delimiter = ""+','; // the default delimiter
	    // support different delimiters
		// case for string delimiters
		
		// getting rid of reserved characters ( in regex) replace with default delimiter
		if(numbers.contains("*")) numbers = numbers.replace("*",delimiter);
		if(numbers.startsWith("//["))
		{
			String s = numbers;
			s = s.substring(s.indexOf("[") + 1);
			s = s.substring(0, s.indexOf("]"));
			//System.out.println("delimiter is"+s);
			delimiter = s;
			/// cut the initial defining part
			//System.out.println("the ip string is "+ numbers.substring(numbers.indexOf("]") + 2));
			numbers = numbers.substring(numbers.indexOf("]") + 2);
			

		}
		else if(numbers.startsWith("//"))
		{
			delimiter = ""+numbers.charAt(2);
			
		//	System.out.println("delimiter is "+ delimiter);
			// cut the initial part of numbers 
			numbers = numbers.substring(4);
			
		}
		// allow new line 
		numbers=numbers.replace("\n",delimiter);
		
		if(numbers.contains(delimiter))
		{
			// unknown number of numbers 
			String[] parts = numbers.split(delimiter);
			int sum=0 ;
			ArrayList<Integer> al = new ArrayList<>(); 
			for(int i=0;i<parts.length;i++)
			{
				
				// negative exception
				 int temp = Integer.parseInt(parts[i]);
				 if(temp < 0) 
					 al.add(Integer.valueOf(temp));
				 // numbers greater than 1000 should be ignores 
				 if(temp >1000)
				 {
					 continue;
				 }
				 sum += temp;
			}
			
			try
			{
			 if(!al.isEmpty()) throw new MyException(al);

			}
			catch(MyException m)
			{
				System.out.println(m);
						   
			}
			return sum;
		}
		
		
		// only one digit 
		return Integer.parseInt(numbers);
	}
}