package main.java.obj_class_methods_uml.assignment_problems;
import java.util.*;
public class CodeSprintJudgingDesk 
{
    interface ScoringRule 
    {
        double calculate(int idea, int execution, int presentation);
    }
    static class InnovationTrack implements ScoringRule 
    {
        public double calculate(int i, int e, int p) 
        {
            return i * 0.5 + e * 0.3 + p * 0.2;
        }
    }
    static class OpenTrack implements ScoringRule 
    {
        public double calculate(int i, int e, int p) 
        {
            return (i + e + p) / 3.0;
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
    static class Team 
    {
        String name;
        List<Student> members;
        ScoringRule track;
        Project project;
        Team(String name, List<Student> members, ScoringRule track) 
        {
            this.name = name;
            this.members = members;
            this.track = track;
        }
    }
    static class Project 
    {
        String name;
        double score;
        Project(String name) 
        {
            this.name = name;
        }
    }
    static class Judge 
    {
        void score(Project p, Team t, int i, int e, int pr, Hackathon h) 
        {
            if (h.state == State.PUBLISHED) 
            {
                System.out.println("Rescore rejected: Results have already been published.");
                return;
            }
            p.score = t.track.calculate(i, e, pr);
            h.state = State.JUDGING;
            System.out.println("Score recorded for '" + p.name + "'.");
        }
    }
    enum State { OPEN, JUDGING, PUBLISHED }
    static class Hackathon 
    {
        State state = State.OPEN;
        Set<String> registeredStudents = new HashSet<>();
        boolean register(Team t) 
        {
            if (state != State.OPEN) return false;
            if (t.members.size() < 2 || t.members.size() > 4) 
            {
                System.out.println("Registration failed: A team must have 2 to 4 members.");
                return false;
            }
            for (Student s : t.members) 
            {
                if (registeredStudents.contains(s.name)) 
                {
                    System.out.println("Registration failed: Student " + s.name + " already belongs to a team.");
                    return false;
                }
            }
            for (Student s : t.members)
                registeredStudents.add(s.name);
            System.out.println("Team " + t.name + " registered (" + t.members.size() + " members, " + (t.track instanceof InnovationTrack ? "Innovation" : "Open") + " track).");
            return true;
        }
        void submit(Team t, String name) 
        {
            if (state == State.PUBLISHED || t.project != null) 
            {
                System.out.println("Submission failed.");
                return;
            }
            t.project = new Project(name);
            System.out.println("Project '" + name + "' submitted by " + t.name + ".");
        }
        void publish(Team t) 
        {
            if (t.project != null)
                System.out.printf(Locale.US, "Final score: %.2f.%n", t.project.score);
            state = State.PUBLISHED;
            System.out.println("Results published.");
        }
    }
    public static void main(String[] args) 
    {
        Hackathon h = new Hackathon();
        Team t = new Team("ByteBusters", Arrays.asList(new Student("Asha"), new Student("Ravi"), new Student("Neha")), new InnovationTrack());
        h.register(t);
        Team invalid = new Team("SoloCoder", Arrays.asList(new Student("Kiran")), new OpenTrack());
        h.register(invalid);
        h.submit(t, "SmartAttend");
        Judge j = new Judge();
        j.score(t.project, t, 8, 7, 9, h);
        h.publish(t);
        j.score(t.project, t, 10, 7, 9, h);
    }
}