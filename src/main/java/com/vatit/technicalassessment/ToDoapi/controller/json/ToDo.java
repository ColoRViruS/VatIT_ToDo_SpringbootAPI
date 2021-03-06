package com.vatit.technicalassessment.ToDoapi.controller.json;

public class ToDo {
    
    //JSON class for the ToDo Item.
    //id Paramater: Represents a Unique ID for each ToDo.
    //Name Paramater: The task's name.
    //Completed Paramater: a flag to indicate the completeness of the Task.
    
    @io.swagger.annotations.ApiModelProperty(notes = "The unique id of the ToDo")
    @com.google.gson.annotations.SerializedName("id")
    @com.google.gson.annotations.Expose
    String  id;
    @io.swagger.annotations.ApiModelProperty(notes = "Name of the ToDo")
    @com.google.gson.annotations.SerializedName("name")
    @com.google.gson.annotations.Expose
    String  name;
    @io.swagger.annotations.ApiModelProperty(notes = "Flag for if the ToDo is Completed or Not")
    @com.google.gson.annotations.SerializedName("completed")
    @com.google.gson.annotations.Expose
    boolean completed;
    
    public ToDo( ) {
    }
    
    public ToDo( String id ,String name ,boolean completed ) {
        id = id;
        name = name;
        completed = completed;
    }
    
    public ToDo( String aName ,boolean aCompleted ) {
        name = aName;
        completed = aCompleted;
    }
    
    public String getId( ) {
        return id;
    }
    
    public void setId( String aId ) {
        id = aId;
    }
    
    public String getName( ) {
        return name;
    }
    
    public void setName( String aName ) {
        name = aName;
    }
    
    public boolean isCompleted( ) {
        return completed;
    }
    
    public void setCompleted( boolean aCompleted ) {
        completed = aCompleted;
    }
    
    @Override
    public String toString( ) {
        return new org.apache.commons.lang3.builder.ToStringBuilder(this)
          .append("id" ,id)
          .append("name" ,name)
          .append("completed" ,completed)
          .toString();
    }
    
    @Override
    public int hashCode( ) {
        return new org.apache.commons.lang3.builder.HashCodeBuilder()
          .append(id)
          .append(name)
          .append(completed)
          .toHashCode();
    }
    
    @Override
    public boolean equals( Object other ) {
        if ( other == this ) {
            return true;
        }
        if ( !(other instanceof ToDo) ) {
            return false;
        }
        ToDo rhs = ((ToDo) other);
        return new org.apache.commons.lang3.builder.EqualsBuilder()
          .append(id ,rhs.id)
          .append(name ,rhs.name)
          .append(completed ,rhs.completed)
          
          .isEquals();
    }
    
}
