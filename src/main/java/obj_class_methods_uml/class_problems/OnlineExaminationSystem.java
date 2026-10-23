package main.java.obj_class_methods_uml.class_problems;
import java.util.*;
public class OnlineExaminationSystem 
{
    interface Question 
    {
        boolean checkAnswer(String answer);
    }
    static class MCQ implements Question 
    {
        int number;
        String correctAnswer;
        MCQ(int number, String correctAnswer) 
        {
            this.number = number;
            this.correctAnswer = correctAnswer;
        }
        public boolean checkAnswer(String answer) 
        {
            return correctAnswer.equalsIgnoreCase(answer);
        }
    }
    static class Student 
    {
        String name;
        Student(String name) 
        {
            this.name = name;
        }
    }
    static class Examination 
    {
        String title;
        List<Question> questions = new ArrayList<>();
        Examination(String title) 
        {
            this.title = title;
        }
        void addQuestion(Question q) 
        {
            questions.add(q);
        }
    }
    static class Attempt 
    {
        Student student;
        Examination exam;
        List<String> answers = new ArrayList<>();
        boolean submitted = false;
        Attempt(Student student, Examination exam) 
        {
            this.student = student;
            this.exam = exam;
            System.out.println("Examination '" + exam.title + "' started by Student.");
        }
        void answer(String answer) 
        {
            if (!submitted) 
            {
                answers.add(answer);
                System.out.println("Question " + answers.size() + " answered with '" + answer + "'.");
            }
        }
        void submit() 
        {
            if (submitted) 
            {
                System.out.println("Attempt already submitted.");
                return;
            }
            submitted = true;
            int score = 0;
            for (int i = 0; i < answers.size(); i++) 
                {
                if (exam.questions.get(i).checkAnswer(answers.get(i))) 
                {
                    score++;
                }
            }
            System.out.println("Examination '" + exam.title + "' submitted successfully.");
            System.out.println("Result for '" + exam.title + "' attempt: " + score + "/" + exam.questions.size() + " correct.");
        }
    }
    public static void main(String[] args) 
    {
        Student s = new Student("Student");
        Examination e = new Examination("Math Quiz");
        e.addQuestion(new MCQ(1, "A"));
        e.addQuestion(new MCQ(2, "B"));
        Attempt a = new Attempt(s, e);
        a.answer("A");
        a.answer("C");
        a.submit();
    }
}