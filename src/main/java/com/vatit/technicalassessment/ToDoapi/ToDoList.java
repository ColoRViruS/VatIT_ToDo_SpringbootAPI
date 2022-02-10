package com.vatit.technicalassessment.ToDoapi;

public class ToDoList {
    
    
    protected static java.util.HashMap<String, com.vatit.technicalassessment.ToDoapi.controller.json.ToDo> mToDoHashMap = new java.util.HashMap<>();
    
    public static java.util.HashMap<String, com.vatit.technicalassessment.ToDoapi.controller.json.ToDo> getToDoHashMap( ) {
        return mToDoHashMap;
    }
    
    public static void UpdateToDO( com.vatit.technicalassessment.ToDoapi.controller.json.ToDo aToDo ) {
        mToDoHashMap.put(aToDo.getId() ,aToDo);
        
    }
    
    public static void addToDO( com.vatit.technicalassessment.ToDoapi.controller.json.ToDo aToDo ) {
        aToDo.setId(GenerateID());
        mToDoHashMap.put(aToDo.getId() ,aToDo);
    }
    
    private static String GenerateID( ) {
        return java.util.UUID.randomUUID().toString().substring(0 ,6);
    }
    
}


