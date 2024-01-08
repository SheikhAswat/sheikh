/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.mavenproject1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CW
 */
public class CompetitorGUI extends javax.swing.JFrame {

    private CompetitorList competitorList;

    // Components for the GUI
    private JButton viewScoresButton;
    private JButton viewTableButton;
    private JButton viewDetailsButton;
    private JButton removeCompetitorButton;
    private JButton closeButton;

    /**
     * Creates new form CompetitorGUI
     */
    public CompetitorGUI() {
        initComponents();
    }

    public CompetitorGUI(CompetitorList competitorList) {
        this.competitorList = competitorList;
        initializeComponents();
        createGUI();
    }

    private void initializeComponents() {
        viewScoresButton = new JButton("View Scores");
        viewTableButton = new JButton("View Table");
        viewDetailsButton = new JButton("View Details");
        removeCompetitorButton = new JButton("Remove Competitor");
        closeButton = new JButton("Close");

        viewScoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Take input for competitor number from the user (you can use a JTextField or any other input method)
                String competitorNumberInput = JOptionPane.showInputDialog("Enter Competitor Number:");

                // Validate the input (ensure it's a valid integer)
                try {
                    int competitorNumber = Integer.parseInt(competitorNumberInput);

                    // Find the competitor with the specified number
                    Competitor athleteCompetitor = findCompetitorByNumber(competitorNumber);

                    // Display the details of the competitor in a dialog box
                    if (athleteCompetitor != null) {
                        JOptionPane.showMessageDialog(null, athleteCompetitor.getFullDetails(), "Competitor Details", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Competitor with number " + competitorNumber + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid competitor number. Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        viewTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Use similar object style
                Competitor competitor = new AthleteCompetitor(
                        456,
                        new Name("Alice", "B", "Smith"),
                        "Beginner",
                        22,
                        "Canada",
                        new int[]{85, 78, 92}
                );

                // Create a JTable
                JFrame frame = new JFrame("Competitor Details");
                String[] columnNames = {"Attribute", "Value"};
                Object[][] data = {
                    {"Competitor Number", competitor.getCompetitorNumber()},
                    {"Name", ((AthleteCompetitor) competitor).getCompetitorName().getFullName()},
                    {"Level", competitor.getLevel()},
                    {"Age", competitor.getAge()},
                    {"Country", competitor.getCountry()},
                    {"Performance Scores", Arrays.toString(((AthleteCompetitor) competitor).getPerformanceScores())}
                };

                JTable table = new JTable(data, columnNames);

                // Add the table to a scroll pane
                JScrollPane scrollPane = new JScrollPane(table);
                frame.add(scrollPane);

                // Set up the frame
                frame.setSize(400, 300);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setVisible(true);
            }
        });

        viewDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Take input for competitor number from the user (you can use a JTextField or any other input method)
                String competitorNumberInput = JOptionPane.showInputDialog("Enter Competitor Number to see details:");

                // Validate the input (ensure it's a valid integer)
                try {
                    int competitorNumber = Integer.parseInt(competitorNumberInput);

                    // Find the competitor with the specified number
                    Competitor athleteCompetitor = findCompetitorByNumber(competitorNumber);

                    // Display the details of the competitor in a dialog box
                    if (athleteCompetitor != null) {
                        JOptionPane.showMessageDialog(null, athleteCompetitor.getFullDetails(), "Competitor Details", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Competitor with number " + competitorNumber + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid competitor number. Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        removeCompetitorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Take input for competitor number from the user (you can use a JTextField or any other input method)
                String competitorNumberInput = JOptionPane.showInputDialog("Enter Competitor Number to remove:");

                JOptionPane.showMessageDialog(null, "Competitor with number " + competitorNumberInput + " is removed");

            }
        });

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call a method to handle the close action
                System.exit(0);

            }
        });
    }

    private static Competitor findCompetitorByNumber(int competitorNumber) {
        // Implement the logic to find and return the competitor with the specified number
        // (replace this with your actual logic)

        // Sample Competitors
        Competitor competitor1 = new AthleteCompetitor(
                123,
                new Name("John", "A", "Doe"),
                "Athlete",
                25,
                "USA",
                new int[]{90, 85, 88}
        );

        Competitor competitor2 = new AthleteCompetitor(
                456,
                new Name("Alice", "B", "Smith"),
                "Gamer",
                22,
                "Canada",
                new int[]{85, 78, 92}
        );

        Competitor competitor3 = new AthleteCompetitor(
                789,
                new Name("Bob", "C", "Johnson"),
                "Athlete",
                30,
                "UK",
                new int[]{95, 88, 91}
        );

        Competitor competitor4 = new GamerCompetitor(
                101,
                new Name("Jane", "D", "Smith"),
                "Gamer",
                30,
                "UK",
                new int[]{95, 92, 89}
        );

        Competitor competitor5 = new AthleteCompetitor(
                102,
                new Name("Charlie", "E", "Brown"),
                "Athlete",
                27,
                "France",
                new int[]{92, 89, 90}
        );

        Competitor competitor6 = new GamerCompetitor(
                103,
                new Name("Emma", "F", "Miller"),
                "Gamer",
                24,
                "Italy",
                new int[]{94, 91, 93}
        );

        Competitor competitor7 = new AthleteCompetitor(
                104,
                new Name("Michael", "G", "Jones"),
                "Athlete",
                28,
                "Spain",
                new int[]{89, 87, 82}
        );

        Competitor competitor8 = new GamerCompetitor(
                105,
                new Name("Sophia", "H", "Davis"),
                "Gamer",
                29,
                "Japan",
                new int[]{91, 90, 95}
        );

        Competitor competitor9 = new AthleteCompetitor(
                106,
                new Name("David", "I", "White"),
                "Athlete",
                23,
                "Australia",
                new int[]{87, 88, 91}
        );

        Competitor competitor10 = new GamerCompetitor(
                107,
                new Name("Olivia", "J", "Johnson"),
                "Gamer",
                31,
                "South Korea",
                new int[]{93, 92, 96}
        );

        Competitor competitor11 = new AthleteCompetitor(
                108,
                new Name("James", "K", "Smith"),
                "Athlete",
                29,
                "Brazil",
                new int[]{85, 86, 89}
        );

        Competitor competitor12 = new GamerCompetitor(
                109,
                new Name("Emily", "L", "Brown"),
                "Gamer",
                26,
                "China",
                new int[]{88, 87, 91}
        );

        Competitor competitor13 = new AthleteCompetitor(
                110,
                new Name("William", "M", "Miller"),
                "Athlete",
                24,
                "India",
                new int[]{94, 93, 95}
        );

        Competitor competitor14 = new GamerCompetitor(
                111,
                new Name("Ava", "N", "Jones"),
                "Gamer",
                27,
                "Russia",
                new int[]{89, 90, 88}
        );

        Competitor competitor15 = new AthleteCompetitor(
                112,
                new Name("Ethan", "O", "Anderson"),
                "Athlete",
                28,
                "Mexico",
                new int[]{92, 98, 92}
        );

        if (competitor1.getCompetitorNumber() == competitorNumber) {
            return competitor1;
        } else if (competitor2.getCompetitorNumber() == competitorNumber) {
            return competitor2;
        } else if (competitor3.getCompetitorNumber() == competitorNumber) {
            return competitor3;
        } 
         else if (competitor4.getCompetitorNumber() == competitorNumber) {
            return competitor4;
        }
          else if (competitor5.getCompetitorNumber() == competitorNumber) {
            return competitor5;
        }
           else if (competitor6.getCompetitorNumber() == competitorNumber) {
            return competitor6;
        }
            else if (competitor7.getCompetitorNumber() == competitorNumber) {
            return competitor7;
        }
             else if (competitor8.getCompetitorNumber() == competitorNumber) {
            return competitor8;
        }
              else if (competitor9.getCompetitorNumber() == competitorNumber) {
            return competitor9;
        }
               else if (competitor10.getCompetitorNumber() == competitorNumber) {
            return competitor10;
        }
                else if (competitor11.getCompetitorNumber() == competitorNumber) {
            return competitor11;
        }
                 else if (competitor12.getCompetitorNumber() == competitorNumber) {
            return competitor12;
        }
                  else if (competitor13.getCompetitorNumber() == competitorNumber) {
            return competitor13;
        }
                   else if (competitor14.getCompetitorNumber() == competitorNumber) {
            return competitor14;
        }
                    else if (competitor15.getCompetitorNumber() == competitorNumber) {
            return competitor3;
        }
               else {
            return null; // Return null if no match is found
        }
    }

    private void createGUI() {
        // Create the main frame
        setTitle("Competitor Management System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel to hold the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(6, 1));
        buttonPanel.add(viewScoresButton);
        buttonPanel.add(viewTableButton);
        buttonPanel.add(viewDetailsButton);
        buttonPanel.add(removeCompetitorButton);
        buttonPanel.add(closeButton);

        // Add the panel to the frame
        add(buttonPanel);

        // Set the frame to be visible
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 private void writeCompetitorReportToFile() {
        String report = competitorList.generateCompetitorReport();
        try (PrintWriter writer = new PrintWriter(new FileWriter("CompetitorReport.txt"))) {
            writer.println(report);
            JOptionPane.showMessageDialog(null, "Competitor report written to CompetitorReport.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readCompetitorsFromFile(CompetitorList competitorList, String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    Integer.parseInt(line.split(",")[0]);
                } catch (NumberFormatException e) {
                    continue;
                }

                String[] data = line.split(",");
                if (data.length < 8) {
                    System.out.println("Invalid data format. Skipping the line: " + line);
                    continue;
                }

                int competitorNumber = Integer.parseInt(data[0]);
                Name competitorName = new Name(data[1], data[2], data[3]);
                String type = data[4];
                int age;
                try {
                    age = Integer.parseInt(data[5]);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid age format. Skipping the line: " + line);
                    continue;
                }

                String country = data[6];
                String[] scoreStr = data[7].split("\\s+");
                int[] scores = new int[scoreStr.length];
                for (int i = 0; i < scoreStr.length; i++) {
                    try {
                        scores[i] = Integer.parseInt(scoreStr[i]);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid score format. Skipping the line: " + line);
                        continue;
                    }
                }

                // Check the type and create the appropriate Competitor subclass
                Competitor competitor = null;
                switch (type.toLowerCase()) {
                    case "athlete":
                        competitor = new AthleteCompetitor(competitorNumber, competitorName, "", age, country, scores);
                        break;
                    case "gamer":
                        competitor = new GamerCompetitor(competitorNumber, competitorName, "", age, country, scores);
                        break;
                    default:
                        System.out.println("Unrecognized competitor type: " + type + ". Skipping the line: " + line);
                }

                if (competitor != null) {
                    competitorList.addCompetitor(competitor);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CompetitorList competitorList = new CompetitorList();
 
                CompetitorGUI gui = new CompetitorGUI(competitorList);
            }
        });

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    }
}
