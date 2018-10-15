package ca.ubc.cpsc210.quizbuilder.model.quiz;

import ca.ubc.cpsc210.quizbuilder.model.exceptions.OutOfTriesException;
import ca.ubc.cpsc210.quizbuilder.model.exceptions.RetryAnswerException;
import ca.ubc.cpsc210.quizbuilder.model.exceptions.TimeIsUpException;
import ca.ubc.cpsc210.quizbuilder.model.questionslist.QuestionsList;
import ca.ubc.cpsc210.quizbuilder.model.quiz.Quiz;

public class DecrementMarksQuiz extends EachAnswerMustBeRightQuiz{
    private double attemptNum;

    public DecrementMarksQuiz(QuestionsList qList) {
        super(qList);
    }

    @Override
    public String submitAnswer(String answer) throws RetryAnswerException, OutOfTriesException {
        try {
            super.submitAnswer(answer);
        }
        catch (RetryAnswerException e) {
            attemptNum = this.curQuestion.getMaxMark();
            if(attemptNum == 1){
                throw new OutOfTriesException("Sorry! You're out of tries");
            }
            this.curQuestion.setMaxMark(attemptNum - 1);
            throw e;
        }
        return "";
    }
}
