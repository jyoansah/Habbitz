package com.habbitz;

/**
 * Created by BASE on 2014-09-20.
 */
public class Task {

    private String taskDescription;
    private String taskName;
    private long taskID;
    private boolean makeOrBrake = true; //true = make, false = brake.

    public Task(String taskDescription, int taskID, String taskName)
    {
        this.taskDescription = taskDescription;
        this.taskName = taskName;
    }

    public Task()
    {
    }

    public String getDescription() { return taskDescription; }
    public void setDescription(String val) { taskDescription = val; }

    public long getId() { return taskID; }
    public void setId(long val) { taskID = val; }

    public String getName() { return taskName; }
    public void setName(String val) { taskName = val; }

    public boolean getMkeBrk() { return makeOrBrake; }
    public void setMkeBrk(boolean val) { makeOrBrake = val; }

    // Will be used by the ArrayAdapter in the ListView
    @Override
    public String toString() {
        return  getName();
    }

}