package exone.maman13_ex1.business_logic;

public class Question {
    String question = "";
    OptionAnswer optionOne = new OptionAnswer();
    OptionAnswer optionTwo = new OptionAnswer();
    OptionAnswer optionThree = new OptionAnswer();
    OptionAnswer optionFore = new OptionAnswer();

    public Question() {
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public OptionAnswer getOptionOne() {
        return optionOne;
    }

    public void setOptionOne(OptionAnswer optionOne) {
        this.optionOne = optionOne;
    }

    public OptionAnswer getOptionTwo() {
        return optionTwo;
    }

    public void setOptionTwo(OptionAnswer optionTwo) {
        this.optionTwo = optionTwo;
    }

    public OptionAnswer getOptionThree() {
        return optionThree;
    }

    public void setOptionThree(OptionAnswer optionThree) {
        this.optionThree = optionThree;
    }

    public OptionAnswer getOptionFore() {
        return optionFore;
    }

    public void setOptionFore(OptionAnswer optionFore) {
        this.optionFore = optionFore;
    }

    public OptionAnswer getOptionAnswer(String option) {
        OptionAnswer optionAnswer = new OptionAnswer();
        switch (option) {
            case "optionOne":
                optionAnswer = this.optionOne;
                break;
            case "optionTwo":
                optionAnswer = this.optionTwo;
                break;
            case "optionThree":
                optionAnswer = this.optionThree;
                break;
            case "optionFore":
                optionAnswer = this.optionFore;
                break;
            default:
                System.out.println("Can't find option");
        }
        return optionAnswer;
    }

}
