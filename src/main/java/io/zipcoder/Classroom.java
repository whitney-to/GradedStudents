package io.zipcoder;

import java.util.Arrays;

public class Classroom {
    private Student[] students;

    public Classroom(int maxNumberOfStudents) {
        this.students = new Student[maxNumberOfStudents];
    }

    public Classroom(Student[] students) {
        this.students = students;
    }

    public Classroom() {
        this.students = new Student[30];
    }

    public Student[] getStudents() {
        return this.students;
    }

    public double getAverageExamScore(){
        double sum = 0;
        for(Student student : students){
            sum += student.getAverageExamScore();
        }
        return sum/students.length;
    }

    public void addStudent(Student student){
        Student[] newStudents = new Student[students.length+1];
        int i = 0;
        for(Student s : students){
            newStudents[i] = s;
            i++;
        }
        newStudents[i] = student;
        this.students = newStudents;
    }

    public void removeStudent(String firstName, String lastName){
        for(Student s : students){
            if(s.getFirstName().equals(firstName) &&
                s.getLastName().equals(lastName)){
                s = students[students.length-1];
                students[students.length-1] = null;
            }
        }
    }

    public void getStudentsByScore(){
        Arrays.sort(students);
    }

    public void getGradeBook(){

    }

}
