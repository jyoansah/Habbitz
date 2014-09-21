package com.habbitz;

/**
 * Created by ianosawaye on 2014-09-20.
 */
public class Cal
{

    private long calId;
    private long userId;
    private long taskId;
    private long dateStarted;
    private String taskCount;

    public Cal()
    {

    }

    public void setUserId(long userId)
    {
        this.userId = userId;
    }

    public void setDateStarted(long dateStarted)
    {
        this.dateStarted = dateStarted;
    }

    public void setTaskCount(String taskCount)
    {
        this.taskCount = taskCount;
    }

    public void setTaskId(long Id)
    {
        taskId = Id;
    }

    public void setId(long cId)
    {
        calId = cId;
    }

    public long getUserId()
    {
        return userId;
    }

    public long getDateStarted()
    {
        return dateStarted;
    }

    public String getTaskCount()
    {
        return taskCount;
    }

    public long getTaskId()
    {
       return taskId;
    }

    public long getId()
    {
        return calId;
    }

    // Will be used by the ArrayAdapter in the ListView
    @Override
    public String toString() {
        return "User: " + getUserId() + " -> Task: " + getTaskId();
    }



}
