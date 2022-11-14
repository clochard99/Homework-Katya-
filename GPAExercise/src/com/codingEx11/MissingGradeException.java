package com.codingEx11;

public class MissingGradeException extends Exception {
    private int studentId;

    public MissingGradeException(String message, int studentId) {
        super(message);
        this.studentId = studentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public MissingGradeException(int studentId) {
        this.studentId = studentId;
    }

}
