package ca.ubc.cpsc210.quizbuilder.model.question;

public class MultiplicationQuestion extends Question{
    private int a;
    private int b;

    public MultiplicationQuestion(double maxMark, int factor1, int factor2) {
        super(maxMark, Integer.toString(factor1) + " * " + Integer.toString(factor2) + " = ");
        this.a = factor1;
        this.b = factor2;
    }

    @Override
    public boolean isCorrect(String answer) {
        int answerI;
        try {
            answerI = Integer.parseInt(answer);
        }
        catch(NumberFormatException e)
        {
            return false;
        }
        return a * b == answerI;
    }
}
