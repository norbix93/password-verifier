My application reads the regular expressions from the requirements.csv document and compiles them into one pattern in the application. 
The description column is never used but it could be used in the UI so that the user knows which requirments his/her password has to meet in order to be accepted.

This way the code is dynamic as it could be extended with further requirements/patterns but at this point it has some limitations. 
A further idea for improval is to create a third column with integers that could set the desired number of times the pattern should be applied.
In addition, I have to think about a way how to make the order of requirements more dynamic - so that the code would still work if the customer told me that he/she desires the second character to be lowercase e.g.
