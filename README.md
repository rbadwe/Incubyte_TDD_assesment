# Incubyte_TDD_assesment
assesment from incubyte for internship 2021

TDD from - https://osherove.com/tdd-kata-1 

### String Calculator

#### Create a simple String calculator with a method signature:

1. int Add(string numbers)
The method can take up to two numbers, separated by commas, and will return their sum. 
>for example “” or “1” or “1,2” as inputs.
>(for an empty string it will return 0) 

<hr>
2. Allow the Add method to handle an unknown amount of numbers
<hr>
3. Allow the Add method to handle new lines between numbers (instead of commas).
>the following input is ok: “1\n2,3” (will equal 6)
>the following input is NOT ok: “1,\n” (not need to prove it - just clarifying)
<hr>

4. Support different delimiters
to change a delimiter, the beginning of the string will contain a separate line that looks like this: 
>“//[delimiter]\n[numbers…]” for example “//;\n1;2” should return three where the default delimiter is ‘;’ .
>the first line is optional. all existing scenarios should still be supported
<hr>

5. Calling Add with a negative number will throw an exception “negatives not allowed” - and the negative that was passed. 
if there are multiple negatives, show all of them in the exception message.
<hr>

6. Numbers bigger than 1000 should be ignored, so adding 2 + 1001 = 2
<hr>

7. Delimiters can be of any length with the following format: 
> “//[delimiter]\n” for example: “//[***]\n1***2***3” should return 6
<hr>

8. Allow multiple delimiters like this: 
>“//[delim1][delim2]\n” for example “//[*][%]\n1*2%3” should return 6
<hr>

9. make sure you can also handle multiple delimiters with length longer than one char
