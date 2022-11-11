package com.congiuntivo;

public class Demo {
    public static void main(String[] args) {
        Essere essere = new Essere();
        Avere avere = new Avere();
        Andare andare = new Andare();
        Fare fare = new Fare();
        Dire dire = new Dire();
        System.out.println("The congiuntivo in Italian is used to talk about hopes, fears, doubts and other uncertain situations.\nThe Italian language is simple! You can notice that.");
        System.out.println(essere.getClass().getSimpleName());
        System.out.println(avere.getClass().getSimpleName());
        System.out.println(andare.getClass().getSimpleName());
        System.out.println(fare.getClass().getSimpleName());
        System.out.println(dire.getClass().getSimpleName());
    }
}
