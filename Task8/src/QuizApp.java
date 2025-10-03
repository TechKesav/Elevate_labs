package Task8.src;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Question> quiz = new ArrayList<>();
        quiz.add(new Question(
                "What is the capital of France?",
                Arrays.asList("1. Berlin", "2. Madrid", "3. Paris", "4. Rome"),
                2
        ));
        quiz.add(new Question(
                "Which language is used for Android app development?",
                Arrays.asList("1. Swift", "2. Kotlin", "3. Ruby", "4. Go"),
                1
        ));
        quiz.add(new Question(
                "Who developed Java?",
                Arrays.asList("1. Dennis Ritchie", "2. James Gosling", "3. Guido van Rossum", "4. Bjarne Stroustrup"),
                1
        ));

        int score = 0;

        System.out.println("===== Welcome to the Online Quiz =====\n");
        for (int i = 0; i < quiz.size(); i++) {
            Question q = quiz.get(i);
            System.out.println("Q" + (i + 1) + ": " + q.getQuestionText());

            for (String option : q.getOptions()) {
                System.out.println(option);
            }

            System.out.print("Your answer (enter option number): ");
            int answer = sc.nextInt() - 1;

            if (q.isCorrect(answer)) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println(" Wrong!\n");
            }
        }
        System.out.println("===== Quiz Finished =====");
        System.out.println("Your Score: " + score + " / " + quiz.size());

        sc.close();
    }
}

