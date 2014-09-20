package com.habbitz;

/**
 * Created by ianosawaye on 2014-09-20.
 */
public class Profile
{

    private long primaryKey;
    private String firstname;
    private String lastname;
    private String email;
    private String username;
    private String password;
    private String taskList;


    public Profile(String firstname, String lastname, String password, String email)
    {
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.email = email;

    }

    public Profile()
    {
    }

    public void setFirstName(String firstname)
    {
        this.firstname = firstname;
    }

    public void setLastName(String lastname)
    {
        this.lastname = lastname;
    }

    public void setPassword(String password)
    {
        this.password = password ;
    }

    public void setId(long primKey)
    {
        this.primaryKey = primKey;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setEmail(String username)
    {
        this.username = username;
    }

    public void setTaskList(String taskList)
    {
        this.taskList = taskList;
    }

    public String getUsername()
    {
        return username;
    }

    public String getFirstName()
    {
        return firstname;
    }

    public String getLastName()
    {
        return lastname;
    }

    public String getPassword()
    {
        return password;
    }

    public long getId()
    {
       return primaryKey;
    }

    public String getTaskList()
    {
        return taskList;
    }


    public String getEmail() {
        return email;
    }

    // Will be used by the ArrayAdapter in the ListView
    @Override
    public String toString() {
        return getLastName() + " " + getLastName();
    }

}
