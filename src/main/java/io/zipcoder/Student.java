package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student implements Comparable<Student>{
    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores;

    public Student(String firstName, String lastName,Double[] examScores){
        this.firstName=firstName;
        this.lastName=lastName;
        this.examScores = new ArrayList<>(Arrays.asList(examScores));
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getNumberOfExamsTaken() {
        if(examScores!=null){
            return examScores.size();
        }
        return 0;
    }

    public String getExamScores(){
        StringBuilder sb = new StringBuilder("Exam Scores:\n");
        int count = 1;
        for(Double score : examScores){
            sb.append(String.format("\tExam %d -> %.0f\n",count,score));
            count++;
        }
        return sb.toString();
    }

    public void addExamScore(double examScore){
        examScores.add(examScore);
    }

    public void setExamScore(int examNumber,double newScore){
        examScores.set(examNumber-1,newScore);
    }

    public double getAverageExamScore(){
        double sum = 0;
        for(Double score : examScores){
            sum += score;
        }
        return sum/examScores.size();
    }

    @Override
    public String toString() {
        return "Student Name : "+firstName+" "+lastName+"\n"+
                            "> Average Score: "+getAverageExamScore()+"\n"+
                            "> "+getExamScores();
    }

    @Override
    public int compareTo(Student other) {
        if(this.getAverageExamScore() < other.getAverageExamScore()){
            return 1;
        } else if(this.getAverageExamScore() > other.getAverageExamScore()){
            return -1;
        } else{
            if(this.getFirstName().charAt(0) < other.getFirstName().charAt(0)){
                return 1;
            }
            else{
                return -1;
            }
        }
    }
}
