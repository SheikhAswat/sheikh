/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;

/**
 *
 * @author CW
 */
public class Mavenproject1 {
  private static CompetitorList competitorList;
    private static AthleteCompetitor athleteCompetitor;
    private static GamerCompetitor gamerCompetitor;

    public static void main(String[] args) {
         
       // Initialize CompetitorList and competitors in the main method
        athleteCompetitor = new AthleteCompetitor(1, new Name("John", "M", "Doe"), "Pro", 25, "USA", new int[]{90, 85, 95});
        gamerCompetitor = new GamerCompetitor(2, new Name("Jane", "A", "Smith"), "Amateur", 22, "Canada", new int[]{75, 80, 85});

        // Create CompetitorList and add competitors
        competitorList = new CompetitorList();
        competitorList.addCompetitor(athleteCompetitor);
        competitorList.addCompetitor(gamerCompetitor);

     }
}
