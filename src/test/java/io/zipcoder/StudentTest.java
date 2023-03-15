package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {
    @Test
    public void testConstructor(){
        // Given
        String expectedFirstName = "John";
        String expectedLastName = "Doe";
        Double[] examScore = {100.0, 100.0};
        int expectedExamsTaken = 2;

        // When
        Student student = new Student(expectedFirstName,expectedLastName,examScore);
        int actualExamsTaken = student.getNumberOfExamsTaken();

        // Then
        Assert.assertEquals(expectedFirstName,student.getFirstName());
        Assert.assertEquals(expectedLastName,student.getLastName());
        Assert.assertEquals(expectedExamsTaken,actualExamsTaken);

    }

    @Test
    public void testGetFirstName(){
        // Given
        String expectedFirstName = "John";
        Double[] examScore = {};

        // When
        Student student = new Student(expectedFirstName,"",examScore);

        // Then
        Assert.assertEquals(expectedFirstName,student.getFirstName());
    }

    @Test
    public void testSetFirstName(){
        // Given
        String expectedFirstName = "John";
        Double[] examScore = {};

        // When
        Student student = new Student(expectedFirstName,"",examScore);

        // Then
        Assert.assertEquals(expectedFirstName,student.getFirstName());
        student.setFirstName("Brian");
        expectedFirstName = "Brian";
        Assert.assertEquals(expectedFirstName,student.getFirstName());
    }

    @Test
    public void testGetLastName(){
        // Given
        String expectedLastName = "Mochi";
        Double[] examScore = {};

        // When
        Student student = new Student("",expectedLastName,examScore);

        // Then
        Assert.assertEquals(expectedLastName,student.getLastName());
    }

    @Test
    public void testSetLastName(){
        // Given
        String expectedLastName = "Mochi";
        Double[] examScore = {};

        // When
        Student student = new Student("",expectedLastName,examScore);

        // Then
        Assert.assertEquals(expectedLastName,student.getLastName());
        student.setLastName("Muffin");
        expectedLastName = "Muffin";
        Assert.assertEquals(expectedLastName,student.getLastName());
    }

    @Test
    public void testGetNumberOfExamsTaken(){
        // Given
        Double[] examScore = {100.0,100.0,100.0};
        int expectedExamTaken = 3;

        // When
        Student student = new Student("","",examScore);
        int actual = student.getNumberOfExamsTaken();

        // Then
        Assert.assertEquals(expectedExamTaken,actual);
    }

    @Test
    public void testGetExamScore(){
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0, 95.0, 123.0, 96.0 };
        Student student = new Student(firstName, lastName, examScores);
        String expected = "Exam Scores:\n\tExam 1 -> 100\n\tExam 2 -> 95\n\tExam 3 -> 123\n\tExam 4 -> 96\n";

        // When
        String output = student.getExamScores();

        // Then
        Assert.assertEquals(expected,output);
        //System.out.println(output);
    }

    @Test
    public void testAddExamScore(){
        // Given
        Double[] examScores = { };
        Student student = new Student("", "", examScores);
        String expected = "Exam Scores:\n\tExam 1 -> 100\n";

        // When
        student.addExamScore(100.0);
        String output = student.getExamScores();

        // Then
        Assert.assertEquals(expected,output);
        //System.out.println(output);
    }

    @Test
    public void testSetExamScore() {
        // : Given
        Double[] examScores = { 100.0 };
        Student student = new Student("", "", examScores);
        String expected = "Exam Scores:\n\tExam 1 -> 100\n";

        // When
        Assert.assertEquals(expected,student.getExamScores());
        student.setExamScore(1, 150.0);
        expected = "Exam Scores:\n\tExam 1 -> 150\n";
        String output = student.getExamScores();

        // Then
        Assert.assertEquals(expected,output);
        //System.out.println(output);
    }

    @Test
    public void testGetAverageExamScore(){
        // Given
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("", "", examScores);
        Double expected = 125.0;

        // When
        Double output = student.getAverageExamScore();

        // Then
        Assert.assertEquals(expected,output);
        //System.out.println(output);
    }

    @Test
    public void testToString(){
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student(firstName, lastName, examScores);
        String expected = "Student Name : Leon Hunter\n"+
                "> Average Score: 125.0\n"+
                "> Exam Scores:\n\tExam 1 -> 100\n\tExam 2 -> 150\n\tExam 3 -> 250\n\tExam 4 -> 0\n";
        // When
        String output = student.toString();

        // Then
        Assert.assertEquals(expected,output);
        //System.out.println(output);
    }
}