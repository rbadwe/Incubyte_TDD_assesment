package com.incubyte;

public class string_calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      System.out.println( add("3,4,5\n4\n9,3"));
       
	}
	
	// The method can take up to two numbers, separated by commas, and will return their sum. 
	public static int add(String numbers)

	{		
        // empty string
		if(numbers =="") return 0;
		
		// allow new line 
		numbers=numbers.replace('\n',',');
		
		if(numbers.contains(","))
		{
			// unknown number of numbers 
			String[] parts = numbers.split(",");
			int sum=0;
			for(int i=0;i<parts.length;i++)
			{
				 sum += Integer.parseInt(parts[i]);
			}
			
			return sum;
		}
		
		
		// only one digit 
		return Integer.parseInt(numbers);
	}
}
