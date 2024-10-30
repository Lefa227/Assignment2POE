/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.part2poe;

import javax.swing.JOptionPane;

/**
 *
 * @author RC_Student_lab
 */
public class Part2POE {
    
    private static boolean isLoggedIn = false;
    private static Task[] tasks;
    private static int currentTaskCount = 0;

    public static void main(String[] args) {
        showWelcomeMessage();
        login();
        
        
        // Create an instance of Register with the username, password, first name, and last name
        Register register = new Register();
        
        
        if (isLoggedIn) {
            int numTasks = Integer.parseInt(JOptionPane.showInputDialog(
                "Enter the number of tasks you wish to create:"));
            tasks = new Task[numTasks];
            
            while (true) {
                String choice = showMenu();
                
                switch (choice) {
                    case "1":
                        if (currentTaskCount < numTasks) {
                            addTask();
                        } else {
                            JOptionPane.showMessageDialog(null, 
                                "Please add a task description within the required range!");
                        }
                        break;
                    case "2":
                        JOptionPane.showMessageDialog(null, "Coming Soon");
                        break;
                    case "3":
                        System.exit(0);
                    default:
                        JOptionPane.showMessageDialog(null, 
                            "Invalid option. Please try again.");
                }
            }
        }
    }

    private static void showWelcomeMessage() {
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");
    }

    private static void login() {
        String firstname = JOptionPane.showInputDialog(null, "Enter your first name:");
        String lastname = JOptionPane.showInputDialog(null, "Enter your last name:");
        String username = JOptionPane.showInputDialog("Enter username:");
        String password = JOptionPane.showInputDialog("Enter password:");
        
        // Simple login validation - in real application, this should be more secure
        if (username != null && password != null && 
            username.equals("Lef_2") && password.equals("Mestalla@2023")) {
            isLoggedIn = true;
        } else {
            JOptionPane.showMessageDialog(null, "Invalid credentials!");
            System.exit(0);
        }
    }

    private static String showMenu() {
        return JOptionPane.showInputDialog(
            "Select an option:\n" +
            "1) Add tasks\n" +
            "2) Show report\n" +
            "3) Quit");
    }

    private static void addTask() {
        String taskName = JOptionPane.showInputDialog("Enter task name:");
        String taskDescription = JOptionPane.showInputDialog("Enter task description:");
        String developerDetails = JOptionPane.showInputDialog(
            "Enter developer details (first and last name):");
        int taskDuration = Integer.parseInt(JOptionPane.showInputDialog(
            "Enter task duration (hours):"));
        
        String[] statusOptions = {"To do", "Done", "Doing"};
        String taskStatus = (String) JOptionPane.showInputDialog(null, 
            "Select task status:",
            "Task Status",
            JOptionPane.QUESTION_MESSAGE,
            null,
            statusOptions,
            statusOptions[0]);

        Task newTask = new Task(taskName, taskDescription, developerDetails, 
                              taskDuration, taskStatus, currentTaskCount);

        if (newTask.checkTaskDescription()) {
            tasks[currentTaskCount] = newTask;
            JOptionPane.showMessageDialog(null, 
                "Task successfully captured\n\n" + newTask.printTaskDetails());
            
            if (currentTaskCount == tasks.length - 1) {
                JOptionPane.showMessageDialog(null, 
                    "Total hours for all tasks: " + Task.returnTotalHours());
            }
            
            currentTaskCount++;
        } else {
            JOptionPane.showMessageDialog(null, 
                "Please enter a task description of less than 50 characters");
        }
    }
}
    

