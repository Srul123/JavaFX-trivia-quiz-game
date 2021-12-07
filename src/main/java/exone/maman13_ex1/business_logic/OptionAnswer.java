package exone.maman13_ex1.business_logic;


/**
 * @ Maman 13 - EX1
 * @author Israel Heiblum 301823555
 */


public class OptionAnswer {
    String answerOption = "";
    boolean isTheAnswer = false;

    public OptionAnswer() {
    }

    public String getAnswerOption() {
        return answerOption;
    }

    public void setAnswerOption(String answerOption) {
        this.answerOption = answerOption;
    }

    public boolean isTheAnswer() {
        return isTheAnswer;
    }

    public void setTheAnswer(boolean theAnswer) {
        isTheAnswer = theAnswer;
    }
}
