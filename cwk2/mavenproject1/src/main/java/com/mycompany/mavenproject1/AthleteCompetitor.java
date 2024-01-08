/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.util.Arrays;

/**
 *
 * @author CW
 */
class AthleteCompetitor extends Competitor {
    private int[] performanceScores;

 public AthleteCompetitor(int competitorNumber, Name competitorName, String level, int age, String country, int[] performanceScores) {
        super(competitorNumber, competitorName, level, age, country);
        this.performanceScores = performanceScores;
    }

    public int[] getPerformanceScores() {
        return performanceScores;
    }

    public void setPerformanceScores(int[] performanceScores) {
        this.performanceScores = performanceScores;
    }

    @Override
    public double getOverallScore() {
        // Calculate average performance score
        return Arrays.stream(performanceScores).average().orElse(0);
    }

    @Override
    public String getShortDetails() {
        // Return short details for athlete competitor
        return "CN " + getCompetitorNumber() + " (" + getCompetitorName().getInitials() + ") has overall score " + String.format("%.1f", getOverallScore()) + ".";
    }

     @Override
    public int[] getScores() {
        return getPerformanceScores();
    }
    
    @Override
    public void setScores(int[] scores) {
        setPerformanceScores(scores);
    }
    @Override
    public String getFullDetails() {
        // Return full details for athlete competitor
        return "Competitor number " + getCompetitorNumber() + ", name " + getCompetitorName().getFullName() +
                ", country " + getCountry() + ".\n" +
                getCompetitorName().getFirstName() + " is an Athlete aged " + getAge() +
                " and has an overall score of " + String.format("%.1f", getOverallScore()) +
                " with performance scores: " + Arrays.toString(performanceScores);
    }
}