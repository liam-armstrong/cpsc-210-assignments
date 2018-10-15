package ca.ubc.cpsc210.quizbuilder.test;

import ca.ubc.cpsc210.quizbuilder.model.question.MultiplicationQuestion;
import ca.ubc.cpsc210.quizbuilder.model.question.Question;
import ca.ubc.cpsc210.quizbuilder.model.question.TrueFalseQuestion;
import ca.ubc.cpsc210.quizbuilder.model.questionslist.QuestionsList;
import ca.ubc.cpsc210.quizbuilder.model.quiz.DecrementMarksQuiz;
import ca.ubc.cpsc210.quizbuilder.model.quiz.EachAnswerMustBeRightQuiz;
import ca.ubc.cpsc210.quizbuilder.model.quiz.InstantFeedbackQuiz;
import ca.ubc.cpsc210.quizbuilder.model.quiz.Quiz;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class MultiplicationQuestionTest extends QuizBuilderTests {
    private Question q1, q2;
    private QuestionsList qList;
    private Quiz testQuiz;

    @BeforeEach
    public void runBefore() {
        q1 = new MultiplicationQuestion(5, 10, 10);
        q2 = new MultiplicationQuestion(5, 3, 3);
        qList = new QuestionsList();
        qList.addQuestion(q1);
        qList.addQuestion(q2);
        testQuiz = new EachAnswerMustBeRightQuiz(qList);
    }

    @Test
    public void TryCorrectAnswer() {
        testQuiz.getNextQuestion();
        super.tryRightAnswer(testQuiz, "100");
        testQuiz.getNextQuestion();
        super.tryRightAnswer(testQuiz, "9");
        Assertions.assertFalse(testQuiz.anymoreQuestions());
    }

    @Test
    public void TryWrongAnswers() {
        testQuiz.getNextQuestion();
        super.tryWrongAnswer(testQuiz, "1");
        testQuiz.getNextQuestion();
        super.tryWrongAnswer(testQuiz, "11");
        Assertions.assertFalse(testQuiz.anymoreQuestions());
    }

    @Test
    public void TryDouble() {
        testQuiz.getNextQuestion();
        super.tryWrongAnswer(testQuiz, "100.0");
        testQuiz.getNextQuestion();
        super.tryWrongAnswer(testQuiz, "9.0");
        Assertions.assertFalse(testQuiz.anymoreQuestions());
    }

    @Test
    public void TryString() {
        testQuiz.getNextQuestion();
        super.tryWrongAnswer(testQuiz, "a hundred");
        testQuiz.getNextQuestion();
        super.tryWrongAnswer(testQuiz, "like 9");
        Assertions.assertFalse(testQuiz.anymoreQuestions());
    }
}