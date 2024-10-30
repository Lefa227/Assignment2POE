/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.part2poe;

/**
 *
 * @author RC_Student_lab
 */
public class Task {
   
    private String taskName;
    private int taskNumber;
    private String taskDescription;
    private String developerDetails;
    private int taskDuration;
    private String taskID;
    private String taskStatus;
    private static int totalHours = 0;

    public Task(String taskName, String taskDescription, String developerDetails, 
                int taskDuration, String taskStatus, int taskNumber) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
        this.taskNumber = taskNumber;
        this.taskID = createTaskID();
        totalHours += taskDuration;
    }

    public boolean checkTaskDescription() {
        return taskDescription.length() <= 50;
    }

    public String createTaskID() {
        String firstTwo = taskName.substring(0, 2).toUpperCase();
        String lastThree = developerDetails.substring(developerDetails.length() - 3).toUpperCase();
        return firstTwo + ":" + taskNumber + ":" + lastThree;
    }

    public String printTaskDetails() {
        return "Task Status: " + taskStatus + "\n" +
               "Developer Details: " + developerDetails + "\n" +
               "Task Number: " + taskNumber + "\n" +
               "Task Name: " + taskName + "\n" +
               "Task Description: " + taskDescription + "\n" +
               "Task ID: " + taskID + "\n" +
               "Duration: " + taskDuration + " hours";
    }

    public static int returnTotalHours() {
        return totalHours;
    }
}

