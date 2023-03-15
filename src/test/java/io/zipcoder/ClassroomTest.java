package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

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
//        System.out.println(output);
    }

    @Test
    public void testAddStudent(){
        // : Given
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Leon", "Hunter", examScores);

        Student[] expectedPreEnrollment = new Student[1];
        Student[] expectedPostEnrollment = new Student[]{student};

        // When
        // Then
        Student[] actualPreEnrollment = classroom.getStudents();
        String preEnrollmentAsString = Arrays.toString(actualPreEnrollment);
        Assert.assertEquals(expectedPreEnrollment,actualPreEnrollment);

        classroom.addStudent(student);

        Student[] actualPostEnrollment = classroom.getStudents();
        String postEnrollmentAsString = Arrays.toString(actualPostEnrollment);
        Assert.assertEquals(expectedPostEnrollment,actualPostEnrollment);

        // Print
//        System.out.println("===========================");
//        System.out.println(preEnrollmentAsString);
//        System.out.println("===========================");
//        System.out.println(postEnrollmentAsString);
    }

    @Test
    public void testRemoveStudent(){
        // : Given
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Leon", "Hunter", examScores);

        Student[] expectedPreRemove = new Student[]{student};
        Student[] expectedPostRemove = new Student[]{null};

        // When
        // Then
        classroom.addStudent(student);
        Student[] actualPreRemove = classroom.getStudents();
        Assert.assertEquals(expectedPreRemove,actualPreRemove);

        classroom.removeStudent(student.getFirstName(),student.getLastName());

        Student[] actualPostRemove = classroom.getStudents();
        Assert.assertEquals(expectedPostRemove,actualPostRemove);

        // Print
//        String preRemove = Arrays.toString(actualPreRemove);
//        String postRemove = Arrays.toString(actualPostRemove);
//
//        System.out.println("===========================");
//        System.out.println(preRemove);
//        System.out.println("===========================");
//        System.out.println(postRemove);
    }

    @Test
    public void testGetStudentsByScore(){
        // Given
        Double[] examScores1 = { 200.0, 200.0, 200.0, 200.0 };
        Double[] examScores2 = { 100.0, 100.0, 100.0, 100.0 };
        Double[] examScores3 = { 300.0, 300.0, 300.0, 300.0 };

        Student student1 = new Student("", "", examScores1);
        Student student2 = new Student("", "", examScores2);
        Student student3 = new Student("", "", examScores3);

        Student[] expectedBeforeSort = {student1,student2,student3};
        Student[] expectedAfterSort = {student3,student1,student2};

        // When
        Classroom classroom = new Classroom(new Student[]{student1,student2,student3});

        Student[] actualBeforeSort = classroom.getStudents();
        Assert.assertEquals(expectedBeforeSort,actualBeforeSort);

        classroom.getStudentsByScore();
        Student[] actualAfterSort = classroom.getStudents();

        // Then
        Assert.assertEquals(expectedAfterSort,actualAfterSort);
    }

    @Test
    public void testGetGradeBook(){
        // Given
        Student student1 = new Student("", "", new Double[] {105.0});
        Student student2 = new Student("", "", new Double[] {100.0});
        Student student3 = new Student("", "", new Double[] {100.0});
        Student student4 = new Student("", "", new Double[] {80.0});
        Student student5 = new Student("", "", new Double[] {100.0});
        Student student6 = new Student("", "", new Double[] {60.0});
        Student student7 = new Student("", "", new Double[] {100.0});
        Student student8 = new Student("", "", new Double[] {40.0});
        Student student9 = new Student("", "", new Double[] {20.0});
        Student student10 = new Student("", "", new Double[] {5.0});
        // average score = 71.0

        Classroom classroom = new Classroom(new Student[]{student1,student2,student3,
                    student4,student5,student6,student7,student8,student9,student10});

        Student[] studentA = new Student[]{student1,student2,student3,student4,student5,student7};
        Student[] studentB = new Student[]{student6};
        Student[] studentC = new Student[]{student8};
        Student[] studentD = new Student[]{student9};
        Student[] studentF = new Student[]{student10};

        // When
        Map<Character, Student[]> gradeBook = classroom.getGradeBook();

        // Then
        Assert.assertEquals(studentA,gradeBook.get('A')); // students with score > 63.9
        Assert.assertEquals(studentB,gradeBook.get('B')); // students with score > 50.4
        Assert.assertEquals(studentC,gradeBook.get('C')); // students with score > 35.5
        Assert.assertEquals(studentD,gradeBook.get('D')); // students with score > 7.81
        Assert.assertEquals(studentF,gradeBook.get('F')); // students with score <= 7.81
    }
}
