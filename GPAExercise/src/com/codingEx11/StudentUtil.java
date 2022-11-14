package com.codingEx11;


import java.util.Arrays;

public class StudentUtil {

    static double lower = 3.2;

    static double higher = 3.5;

    static int[] studentIdList = {1001, 1002};

    static char[][] studentsGrades = { { 'A', 'A', 'A', 'B' }, { 'A', 'B', ' ' } };

    public static double[] calculateGPA(int[] studentIdList, char[][] studentsGrades) throws IllegalArgumentException , MissingGradeException{
        if (studentIdList.length != studentsGrades.length)
            throw new IllegalArgumentException("studentIdList & studentsGrades are out-of-sync. studentIdList.length: " + studentIdList.length + ", studentsGrades.length: " + studentsGrades.length);

        double[] gpaList = new double[studentIdList.length];

        for (int i = 0; i < studentsGrades.length; i++) {
            double gpa = 0.0;

            for (int j = 0; j < studentsGrades[i].length; j++) {
                if (studentsGrades[i][j] == 'A') {
                    gpa += 4.0;
                } else if (studentsGrades[i][j] == 'B') {
                    gpa += 3.0;
                } else if (studentsGrades[i][j] == 'C') {
                    gpa += 2.0;
                } else if (studentsGrades[i][j] == ' ') {
                    throw new MissingGradeException("Student is yet to receive a grade", studentIdList[i]);
                }
            }

            gpaList[i] = gpa/studentsGrades[i].length;
        }

        return gpaList;
    }


    public static int[] getStudentsByGPA(double lower, double higher, int[] studentIdList, char[][] studentsGrades) throws MissingGradeException {
        if (lower < 0 || higher < 0 || lower > higher) {
            return null;
        }

        double[] gpaList = new double[studentIdList.length];
        try { gpaList= calculateGPA(studentIdList, studentsGrades);
        } catch (MissingGradeException exception) {
            System.out.println(exception.getStudentId());
            System.out.println(exception.getMessage());
            throw new InvalidDataException("Expected for grades", exception);
        }
        gpaList = calculateGPA(studentIdList, studentsGrades);


        int count = 0;
        for (double gpa : gpaList) {
            if (gpa >= lower && gpa <= higher) {
                count++;
            }
        }

        int[] result = new int[count];
        int index = 0;
        for (int i = 0; i <  gpaList.length; i++) {
            if (gpaList[i] >= lower && gpaList[i] <= higher) {
                result[index++] = studentIdList[i];
            }
        }

        return result;
    }
    public static void main(String[] args) throws MissingGradeException{
        System.out.println(Arrays.toString(getStudentsByGPA(lower, higher, studentIdList, studentsGrades)));
    }
}
