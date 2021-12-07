package exone.maman13_ex1;

import exone.maman13_ex1.business_logic.OptionAnswer;
import exone.maman13_ex1.business_logic.Question;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @ Maman 13 - EX1
 * @author Israel Heiblum 301823555
 */


public class Quiz {
    ArrayList<Question> questions = new ArrayList<>();
    int totalQuestions = 0;
    int currentQuestionCounter = 0;

    public Quiz() {
    }


    public Question getNextQuestion() {
        if (currentQuestionCounter == totalQuestions) {
            System.out.println("You finished");
            return null;
        }
        Question question = questions.get(currentQuestionCounter);
        question = makeRandomQuestions(question);
        currentQuestionCounter++;
        return question;
    }

    public Question makeRandomQuestions(Question question) {
        ArrayList<OptionAnswer> answers = new ArrayList<>();
        answers.add(question.getOptionOne());
        answers.add(question.getOptionTwo());
        answers.add(question.getOptionThree());
        answers.add(question.getOptionFore());

        Collections.shuffle(answers);

        question.setOptionOne(answers.get(0));
        question.setOptionTwo(answers.get(1));
        question.setOptionThree(answers.get(2));
        question.setOptionFore(answers.get(3));

        return question;
    }

    public void readTextFileWithQuestions() throws FileNotFoundException {
        // absolute path to text file with questions
        String pathToFile = System.getProperty("user.dir") + "\\src\\main\\resources\\questions_template\\questions.txt";
        File file = new File(pathToFile);
        Scanner sc = new Scanner(file);
        int blockLinesSeperator = 0;
        ArrayList<Question> questions = new ArrayList<>();

        Question question = new Question();

        while (sc.hasNextLine()) {
            if (blockLinesSeperator % 5 == 0) {
                blockLinesSeperator = 0;
                question = new Question();
            }
            switch (blockLinesSeperator) {
                case 0 -> question.setQuestion(sc.nextLine());
                case 1 -> {
                    OptionAnswer one = new OptionAnswer();
                    one.setTheAnswer(true);
                    one.setAnswerOption(sc.nextLine());
                    question.setOptionOne(one);
                }
                case 2 -> {
                    OptionAnswer two = new OptionAnswer();
                    two.setTheAnswer(false);
                    two.setAnswerOption(sc.nextLine());
                    question.setOptionTwo(two);
                }
                case 3 -> {
                    OptionAnswer three = new OptionAnswer();
                    three.setTheAnswer(false);
                    three.setAnswerOption(sc.nextLine());
                    question.setOptionThree(three);
                }
                case 4 -> {
                    OptionAnswer fore = new OptionAnswer();
                    fore.setTheAnswer(false);
                    fore.setAnswerOption(sc.nextLine());
                    question.setOptionFore(fore);
                }
                default -> System.out.println("Error - no option exist");
            }
            blockLinesSeperator++;
            if (blockLinesSeperator == 5) {
                questions.add(question);
            }
        }
        sc.close();
        this.questions = questions;
        this.totalQuestions = questions.size();
    }


}
