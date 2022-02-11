package com.vatit.technicalassessment.ToDoapi;

public class ToDoList {
    
    //The in memory Hash-map used to store the ToDos with the ToDo's ID as the map's key
    
    protected static java.util.HashMap<String, com.vatit.technicalassessment.ToDoapi.controller.json.ToDo> mToDoHashMap = new java.util.HashMap<>();
    
    public static java.util.HashMap<String, com.vatit.technicalassessment.ToDoapi.controller.json.ToDo> getToDoHashMap( ) {
        return mToDoHashMap;
    }
    
    //Method to replace a ToDo
    public static void UpdateToDo( com.vatit.technicalassessment.ToDoapi.controller.json.ToDo aToDo ) {
        mToDoHashMap.put(aToDo.getId() ,aToDo);
    }
    
    //Add ToDo top the list.
    public static void addToDO( com.vatit.technicalassessment.ToDoapi.controller.json.ToDo aToDo ) {
        aToDo.setId(GenerateID());
        mToDoHashMap.put(aToDo.getId() ,aToDo);
    }
    
    //Generate a Unique ID by Generating a UUID at random and using the firt 6 charecters.
    private static String GenerateID( ) {
        return java.util.UUID.randomUUID().toString().substring(0 ,6);
    }
    
}


