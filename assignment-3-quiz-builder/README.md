# Quiz Builder

The Quiz Builder application defines classes to represent a quiz that a student might take. In this assignment you will add a new type of question having to do with multiplication and add a new type of quiz. The new type of quiz requires the student taking the quiz to re-enter an answer, if they entered an incorrect answer, and also automatically deducts one from the mark for the question on each incorrect answer attempt. When the potential points have run out for a question, the system moves on to the next question.

*Learning Goals*

- Working with a type hierarchy
- Working with exception handelling in Java 
______
## Task 1

Create a new class called `MultiplicationQuestion` in the `ca.ubc.cpsc210.quizbuilder.model.question package`
The MultiplicationQuestion class must extend the Question class and represents questions of the form factor1 * factor2 = ???.
For example: `2 * 3 = ???`
This class must implement the following constructor:
`public MultiplicationQuestion(double maxMark, int factor1, int factor2)`
You must also specify, test and implement any methods that must be overridden or added to provide the desired functionality. Note that a skeleton test class has been provided for you along with some useful helper methods in its superclass.
Your code needs to work only for answer submissions that are integers. That is, you must assume that "6" is the right answer for the question above, while "6.0" is not. Further, your code must work properly (catching a NumberFormatException) for the case when the user supplies an answer that is not an int (for instance, a number over 2147483647, or one containing a non-numeric character). In this case MultiplicationQuestion.isCorrect() should return false.
You can use the following method to convert a String object to an int:
`int answerI = Integer.parseInt(answerS);`
If you want to interactively test your new question class -- there are two commented-out lines in QuizRunner that create a new instance of MultiplicationQuestion and add it to the list of sample questions that you can answer when you run the program. These lines follow lines containing the comment: Un-comment next line to test MultiplicationQuestion.

NOTE: AutoTest will not be able to compile (and therefore grade) your submission until your code contains a properly defined MultiplicationQuestion class and a DecrementMarksQuiz class (see Task 2). So there is no point in requesting a grade from AutoTest at this point.
______
## Task 2

Create a new class, called DecrementMarksQuiz, and add it to the ca.ubc.cpsc210.quizbuilder.model.quiz package.

This class must extend EachAnswerMustBeRightQuiz and represents a new kind of quiz. If the user takes this quiz and they submit an incorrect answer they can retry the answer (just like with the EachAnswerMustBeRightQuiz quiz type), but their maximum mark for that question is decremented by one. They get as many tries as there are marks initially set for the question. When the user runs out of tries, the program should throw an OutOfTriesException (provided) that gracefully allows them to move on to the next question (but gives them no points for this one). You do not have to worry about catching the exception for our purposes -- you will see that it is already caught in QuizRunner and the AutoTest reference tests. But in your own testing, you will need to handle the OutOfTriesException, and also test that it is thrown at the correct time.

You must specify, test and implement a constructor and any methods that must be overridden or added to provide the desired functionality. Note that a skeleton test class has been provided for you along with some useful helper methods in its superclass.

If you want to interactively test your new quiz class there are a few commented-out lines in QuizRunner that create the new quiz type and allow you to try it out interactively when you run the program. To find these lines, look for the comments: Un-comment next ... line(s) to interactively test DecrementMarksQuiz, and un-comment the line(s) below.

NOTE: Before you request a grade from AutoTest check that you have defined the MultiplicationQuestion class and  DecrementMarksQuiz class in the right packages (as specified above).