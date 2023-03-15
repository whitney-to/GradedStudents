package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ClassroomTest {
    @Test
    public void testConstructorWithInt() {
        // Given
        int expected = 20; //20 students

        // When
        Classroom classroom = new Classroom(expected);
        int actual = classroom.getStudents().length;

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testConstructorWithStudent() {
        // Given
        int expected = 1; //1 student
        Double[] examScore = {100.0, 100.0};
        Student student = new Student("","",examScore);


        // When
        Classroom classroom = new Classroom(new Student[]{student});
        int actual = classroom.getStudents().length;

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testNullaryConstructor() {
        // Given
        int expected = 30; //30 students
        Double[] examScore = {100.0, 100.0};
        Student student = new Student("","",examScore);


        // When
        Classroom classroom = new Classroom();
        int actual = classroom.getStudents().length;

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetStudent(){
        // Given
        Double[] examScore = {100.0, 100.0};

        Student student1 = new Student("","",examScore);
        Student student2 = new Student("","",examScore);

        Student[] expected = new Student[]{student1,student2};

        // When
        Classroom classroom = new Classroom(expected);
        Student[] actual = classroom.getStudents();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetAverageExamScore(){
        // : Given
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 25.0 };

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] students = {s1,s2};
        Classroom classroom = new Classroom(students);

        // When
        double expected = 125.0;
        double output = classroom.getAverageExamScore();

        // Then
        Assert.assertEquals(expected,output,0.1);
        System.out.println(output);
    }

    @Test
    public void testAddStudent(){
        // : Given
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Leon", "Hunter", examScores);

        // When
        Student[] preEnrollment = classroom.getStudents();
        classroom.addStudent(student);
        Student[] postEnrollment = classroom.getStudents();

        // Then
        String preEnrollmentAsString = Arrays.toString(preEnrollment);
        String postEnrollmentAsString = Arrays.toString(postEnrollment);

        System.out.println("===========================");
        System.out.println(preEnrollmentAsString);
        System.out.println("===========================");
        System.out.println(postEnrollmentAsString);
    }
}
