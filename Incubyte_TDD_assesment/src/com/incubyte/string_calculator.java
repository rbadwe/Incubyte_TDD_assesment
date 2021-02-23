package com.incubyte;

public class string_calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      System.out.println( add("5656,2125,34343,3,9,00,2"));
       
	}
	
	// The method can take up to two numbers, separated by commas, and will return their sum. 
	public static int add(String numbers)

	{		
        // empty string
		if(numbers =="") return 0;
		
		
		if(numbers.contains(","))
		{
			// assuming there are only 2 numbers 
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
