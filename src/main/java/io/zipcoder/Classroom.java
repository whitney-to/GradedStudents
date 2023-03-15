package io.zipcoder;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

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
        int i = 0;
        for(Student s : students){
            if(s==null){
                students[i] = student;
                break;
            }
            i++;
        }
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

    public void getStudentsByScore(){Arrays.sort(students);}

    public Map<Character,Student[]> getGradeBook(){
        // Initialize student map
        Map<Character,Student[]> gradeBook = initializeStudentMap();

        // average score of class
        double averageScore = this.getAverageExamScore();

        // iterate and put students in map
        for(Student student : students){
            if(student.getAverageExamScore() > averageScore*0.9){
                addInMap('A',student,gradeBook);
            } else if(student.getAverageExamScore() > averageScore*0.71){
                addInMap('B',student,gradeBook);
            } else if(student.getAverageExamScore() > averageScore*0.50){
                addInMap('C',student,gradeBook);
            } else if(student.getAverageExamScore() > averageScore*0.11){
                addInMap('D',student,gradeBook);
            } else {
                addInMap('F',student,gradeBook);
            }
        }

        return gradeBook;
    }

    public void addInMap(Character grade, Student student, Map<Character,Student[]> studentsMap){
        Student[] studentUpdate = new Student[studentsMap.get(grade).length+1];
        int i = 0 ;
        for(Student curStudent : studentsMap.get(grade)){
            studentUpdate[i] = curStudent;
            i++;
        }
        studentUpdate[i] = student;
        studentsMap.put(grade,studentUpdate);
    }

    public HashMap<Character,Student[]> initializeStudentMap(){
        HashMap<Character,Student[]> map = new HashMap<>();
        map.put('A',new Student[]{});
        map.put('B',new Student[]{});
        map.put('C',new Student[]{});
        map.put('D',new Student[]{});
        map.put('F',new Student[]{});
        return map;
    }



}
