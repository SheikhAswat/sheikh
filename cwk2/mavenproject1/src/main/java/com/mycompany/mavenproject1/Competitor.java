/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author CW
 */
abstract class Competitor {
        public abstract int[] getScores();
    public abstract void setScores(int[] scores);
    private int competitorNumber;
    private Name competitorName;
    private String level;
    private int age;
    private String country;

    public Competitor(int competitorNumber, Name competitorName, String level, int age, String country) {
        this.competitorNumber = competitorNumber;
        this.competitorName = competitorName;
        this.level = level;
        this.age = age;
        this.country = country;
    }

    public int getCompetitorNumber() {
        return competitorNumber;
    }

    public void setCompetitorNumber(int competitorNumber) {
        this.competitorNumber = competitorNumber;
    }

    public Name getCompetitorName() {
        return competitorName;
    }

    public void setCompetitorName(Name competitorName) {
        this.competitorName = competitorName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    // Abstract method for calculating overall score
    public abstract double getOverallScore();

    // Abstract method for getting short details
    public abstract String getShortDetails();

    // Abstract method for getting full details
    public abstract String getFullDetails();
}