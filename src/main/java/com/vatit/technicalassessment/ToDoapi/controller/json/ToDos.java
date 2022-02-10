package com.vatit.technicalassessment.ToDoapi.controller.json;

public class ToDos {
    
    @com.google.gson.annotations.SerializedName("todos")
    @com.google.gson.annotations.Expose
    private java.util.ArrayList<com.vatit.technicalassessment.ToDoapi.controller.json.ToDo> toDos;
    
    /**
     * No args constructor for use in serialization
     */
    public ToDos( ) {
    }
    
    /**
     * @param toDos
     */
    public ToDos( java.util.ArrayList<com.vatit.technicalassessment.ToDoapi.controller.json.ToDo> toDos ) {
        super();
        this.toDos = toDos;
    }
    
    public java.util.ArrayList<com.vatit.technicalassessment.ToDoapi.controller.json.ToDo> getToDos( ) {
        return toDos;
    }
    
    public void setToDos( java.util.ArrayList<com.vatit.technicalassessment.ToDoapi.controller.json.ToDo> aToDos ) {
        toDos = aToDos;
    }
    
    @Override
    public String toString( ) {
        return new org.apache.commons.lang3.builder.ToStringBuilder(this).append("todos" ,toDos).toString();
    }
    
    @Override
    public int hashCode( ) {
        return new org.apache.commons.lang3.builder.HashCodeBuilder().append(toDos).toHashCode();
    }
    
    @Override
    public boolean equals( Object other ) {
        if ( other == this ) {
            return true;
        }
        if ( !(other instanceof com.vatit.technicalassessment.ToDoapi.controller.json.ToDos) ) {
            return false;
        }
        com.vatit.technicalassessment.ToDoapi.controller.json.ToDos rhs = ((com.vatit.technicalassessment.ToDoapi.controller.json.ToDos) other);
        return new org.apache.commons.lang3.builder.EqualsBuilder().append(toDos ,rhs.toDos).isEquals();
    }
}
