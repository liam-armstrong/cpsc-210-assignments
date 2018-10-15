package ca.ubc.cpsc210.quizbuilder.test;

import ca.ubc.cpsc210.quizbuilder.model.question.Question;
import ca.ubc.cpsc210.quizbuilder.model.question.TrueFalseQuestion;
import ca.ubc.cpsc210.quizbuilder.model.questionslist.QuestionsList;
import ca.ubc.cpsc210.quizbuilder.model.quiz.DecrementMarksQuiz;
import ca.ubc.cpsc210.quizbuilder.model.quiz.Quiz;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

public class DecrementMarksQuizTests extends QuizBuilderTests {

    private Question q1, q2, q3;
    private QuestionsList qList;
    private Quiz testQuiz;

    @BeforeEach
    public void runBefore() {
        // feel free to modify this as needed
        q1 = new TrueFalseQuestion(3, "You are awesome.", true);
        q2 = new TrueFalseQuestion(3, "Donuts are bad for you.", true);
        q3 = new TrueFalseQuestion(3, "CPSC 210 is easy", false);
        qList = new QuestionsList();
        qList.addQuestion(q1);
        qList.addQuestion(q2);
        qList.addQuestion(q3);
        testQuiz = new DecrementMarksQuiz(qList);
    }

    @Test
    public void testCorrectAnswer() {
        testQuiz.getNextQuestion();
        super.tryRightAnswer(testQuiz, "true");
        testQuiz.getNextQuestion();
        super.tryRightAnswer(testQuiz, "true");
        testQuiz.getNextQuestion();
        super.tryRightAnswer(testQuiz, "false");
        Assertions.assertFalse(testQuiz.anymoreQuestions());
    }

    @Test
    public void testWrongAnswer() {
        Question q4 = testQuiz.getNextQuestion();
        Assertions.assertEquals(q1, q4);
        Assertions.assertEquals(3, q4.getMaxMark());
        super.tryWrongAnswer(testQuiz, "false");
        Assertions.assertEquals(2, q4.getMaxMark());
        super.tryWrongAnswer(testQuiz, "false");
        Assertions.assertEquals(1, q4.getMaxMark());
    }
}
