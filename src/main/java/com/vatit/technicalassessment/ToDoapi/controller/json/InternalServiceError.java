package com.vatit.technicalassessment.ToDoapi.controller.json;

public class InternalServiceError {
    
    //JSON class for the Error Message.
    //Message Paramater: Contains a Static message.
    
    @io.swagger.annotations.ApiModelProperty(notes = "Error Message")
    @com.google.gson.annotations.SerializedName("message")
    @com.google.gson.annotations.Expose
    private String message;
    
    public InternalServiceError( ) {
    }
    
    public InternalServiceError( String aMessage ) {
        message = aMessage;
    }
    
    public String getMessage( ) {
        return message;
    }
    
    public void setMessage( String aMessage ) {
        message = aMessage;
    }
    
    @Override
    public String toString( ) {
        return new org.apache.commons.lang3.builder.ToStringBuilder(this).append("Message" ,message).toString();
    }
    
    @Override
    public int hashCode( ) {
        return new org.apache.commons.lang3.builder.HashCodeBuilder().append(message).toHashCode();
    }
    
    @Override
    public boolean equals( Object other ) {
        if ( other == this ) {
            return true;
        }
        if ( !(other instanceof com.vatit.technicalassessment.ToDoapi.controller.json.InternalServiceError) ) {
            return false;
        }
        com.vatit.technicalassessment.ToDoapi.controller.json.InternalServiceError rhs = ((com.vatit.technicalassessment.ToDoapi.controller.json.InternalServiceError) other);
        return new org.apache.commons.lang3.builder.EqualsBuilder().append(message ,rhs.message).isEquals();
    }
}
