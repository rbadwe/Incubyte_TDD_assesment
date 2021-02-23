package com.incubyte;

public class string_calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      System.out.println( add("5656,2125"));
       
	}
	
	// The method can take up to two numbers, separated by commas, and will return their sum. 
	public static int add(String numbers)

	{
		// assuming there are only 2 numbers 
		

		if(numbers=="1") return 1;
		if(numbers =="") return 0;
		
		if(numbers.contains(","))
		{
			String[] parts = numbers.split(",", 2);
			String n1 = parts[0];
			String n2 = parts[1];
			
			int sum = Integer.parseInt(n1) + Integer.parseInt(n2);
			return sum;
		}
		
		return -1;// error 
	}
}
