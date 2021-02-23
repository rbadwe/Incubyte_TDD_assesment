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

	public static void main(String[] args) throws MyException {
		// TODO Auto-generated method stub
      System.out.println( add("//;\n34;8\n-9;1;-8989"));
	}
	
	
	
	
	
    // support different delimiters
	public static int add(String numbers) throws MyException

	{		
        // empty string
		if(numbers =="") return 0;
		
		char delimiter = ','; // the default delimiter
		if(numbers.startsWith("//"))
		{
			delimiter = numbers.charAt(2);
			
			// cut the initial part of numbers 
			numbers = numbers.substring(4);
			
		}
		// allow new line 
		numbers=numbers.replace('\n',delimiter);
		
		if(numbers.contains(Character.toString(delimiter)))
		{
			// unknown number of numbers 
			String[] parts = numbers.split(Character.toString(delimiter));
			int sum=0 ;
			ArrayList<Integer> al = new ArrayList<>(); 
			for(int i=0;i<parts.length;i++)
			{
				
				// negative exception
				 int temp = Integer.parseInt(parts[i]);
				 if(temp < 0) 
					 al.add(Integer.valueOf(temp));
					 
				 sum += Integer.parseInt(parts[i]);
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
