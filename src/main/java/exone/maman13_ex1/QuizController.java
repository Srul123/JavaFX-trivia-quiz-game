package exone.maman13_ex1;

import exone.maman13_ex1.business_logic.OptionAnswer;
import exone.maman13_ex1.business_logic.Question;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.io.FileNotFoundException;


/**
 * @ Maman 13 - EX1
 * @author Israel Heiblum 301823555
 */


public class QuizController {
    private Quiz quiz;

    private Question currentQuestion;

    private int countCorrectAnswers = 0;

    @FXML
    private Text answer;

    @FXML
    private Button nextQuestion;

    @FXML
    private Button optionOne;

    @FXML
    private Button optionTwo;

    @FXML
    private Button optionThree;

    @FXML
    private Button optionFore;

    @FXML
    private Text question;


    @FXML
    private Button startNewGame;

    @FXML
    public void initialize() throws FileNotFoundException {
        this.quiz = new Quiz();
        quiz.readTextFileWithQuestions();
        countCorrectAnswers = 0;
        currentQuestion = quiz.getNextQuestion();
        renderNextQuestion();
        startNewGame.setVisible(false);
    }

    @FXML
    void callNextQuestion(ActionEvent event) throws FileNotFoundException {
        System.out.println(event);
        currentQuestion = quiz.getNextQuestion();
        if (currentQuestion != null) {
            renderNextQuestion();
            nextQuestion.setDisable(true);
        } else {
            nextQuestion.setDisable(true);
            answer.setText("Game finished!!! \n you got total score: " + getResults());
            startNewGame.setVisible(true);
        }
    }

    @FXML
    void checkAnswer(ActionEvent event) {
        System.out.println(event);
        String buttonId = ((Button) event.getSource()).getId();
        OptionAnswer optionAnswer = currentQuestion.getOptionAnswer(buttonId);
        if (optionAnswer.isTheAnswer()) {
            answer.setText("You right (-:");
            countCorrectAnswers++;
        } else {
            answer.setText("You wrong )-:");
        }
        nextQuestion.setDisable(false);
        optionOne.setDisable(true);
        optionTwo.setDisable(true);
        optionThree.setDisable(true);
        optionFore.setDisable(true);
    }

    @FXML
    void playNewGame(ActionEvent event) throws FileNotFoundException {
        initialize();
    }

    private int getResults() {
        double result = (double) countCorrectAnswers / (double) quiz.totalQuestions;
        result = result * 100;
        return (int) Math.ceil(result);
    }

    private void renderNextQuestion() {
        question.setText(currentQuestion.getQuestion());
        optionOne.setText(currentQuestion.getOptionOne().getAnswerOption());
        optionOne.setDisable(false);
        optionTwo.setText(currentQuestion.getOptionTwo().getAnswerOption());
        optionTwo.setDisable(false);
        optionThree.setText(currentQuestion.getOptionThree().getAnswerOption());
        optionThree.setDisable(false);
        optionFore.setText(currentQuestion.getOptionFore().getAnswerOption());
        optionFore.setDisable(false);
        answer.setText("");
        nextQuestion.setDisable(true);
        nextQuestion.setText("Next question");
    }



}
