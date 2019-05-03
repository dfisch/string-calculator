Test Driven Development
===

1) Write a failing test
2) Write the simplest code that will make the test pass
3) refactor and remove all duplication

String Calculator TDD Kata
===

1) Given a single positive whole number in a string, return the number
2) Given 2 comma delimited numbers, return the sum
3) Given multiple comma delimited numbers, return the sum
4) Allow new line delimited string instead of commas
5) Support different delimiters, regardless of length, defined on the first line of the string prefixed with "//", 
  example "//;/n1;2" would return 3
6) If the string contains a negative number, throw an exception, the exception should contain 
  'negatives not allowed' and _all_ of the negative numbers in the message
7) Numbers bigger than 1000 should be ignored.  ex. "1,1001,2" returns 3