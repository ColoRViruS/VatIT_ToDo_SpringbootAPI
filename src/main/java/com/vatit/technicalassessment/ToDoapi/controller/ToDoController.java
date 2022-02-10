package com.vatit.technicalassessment.ToDoapi.controller;

@org.springframework.web.bind.annotation.RestController
public class ToDoController {
    
    @org.springframework.web.bind.annotation.RequestMapping(value = "/todos", method = org.springframework.web.bind.annotation.RequestMethod.GET)
    public String getToDo( )
    throws com.vatit.technicalassessment.ToDoapi.exception.InternalServerError {
        try {
            
            
            com.vatit.technicalassessment.ToDoapi.controller.json.ToDos vTags = new com.vatit.technicalassessment.ToDoapi.controller.json.ToDos();
            com.google.gson.Gson                                        vGson = new com.google.gson.Gson();
            
            vTags.setToDos(new java.util.ArrayList<>(com.vatit.technicalassessment.ToDoapi.ToDoList.getToDoHashMap().values()));
            return vGson.toJson(vTags);
        }catch ( Exception aException ) {
            throw new com.vatit.technicalassessment.ToDoapi.exception.InternalServerError();
        }
    }
    
    @org.springframework.web.bind.annotation.PostMapping(path = "/todos", consumes = "application/json")
    public void addToDo( @org.springframework.web.bind.annotation.RequestBody com.vatit.technicalassessment.ToDoapi.controller.json.ToDo aToDo )
    throws com.vatit.technicalassessment.ToDoapi.exception.InternalServerError {
        try {
            if ( aToDo.getName() == null || "I'm Lazy".equals(aToDo.getName()) ) {
                throw new com.vatit.technicalassessment.ToDoapi.exception.InternalServerError();
            }else {
                com.vatit.technicalassessment.ToDoapi.ToDoList.addToDO(aToDo);
            }
        }catch ( Exception aException ) {
            throw new com.vatit.technicalassessment.ToDoapi.exception.InternalServerError();
        }
    }
    
    @org.springframework.web.bind.annotation.PutMapping("/todos/{aUrlParameter}")
    public String restService( @org.springframework.web.bind.annotation.PathVariable("aUrlParameter") String aUrlParameter ,
                               @org.springframework.web.bind.annotation.RequestBody com.vatit.technicalassessment.ToDoapi.controller.json.ToDo aToDo )
    throws com.vatit.technicalassessment.ToDoapi.exception.InternalServerError {
        
        if ( com.vatit.technicalassessment.ToDoapi.ToDoList.getToDoHashMap().containsKey(aUrlParameter) ) {
            com.vatit.technicalassessment.ToDoapi.ToDoList.UpdateToDO(aToDo);
        }else {
            throw new com.vatit.technicalassessment.ToDoapi.exception.InternalServerError();
        }
        
        com.google.gson.Gson vGson = new com.google.gson.Gson();
        return vGson.toJson(aToDo);
    }
    
    @org.springframework.web.bind.annotation.DeleteMapping("/todos/{aUrlParameter}")
    public void restService( @org.springframework.web.bind.annotation.PathVariable("aUrlParameter") String aUrlParameter )
    throws com.vatit.technicalassessment.ToDoapi.exception.InternalServerError {
        
        if ( com.vatit.technicalassessment.ToDoapi.ToDoList.getToDoHashMap().containsKey(aUrlParameter) ) {
            com.vatit.technicalassessment.ToDoapi.ToDoList.getToDoHashMap().remove(aUrlParameter);
        }else {
            throw new com.vatit.technicalassessment.ToDoapi.exception.InternalServerError();
        }
    }
    
    
    @org.springframework.web.bind.annotation.ExceptionHandler(com.vatit.technicalassessment.ToDoapi.exception.InternalServerError.class)
    @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR)
    public @org.springframework.web.bind.annotation.ResponseBody
    java.util.Map<String, Object> handleIndexNotFoundException( com.vatit.technicalassessment.ToDoapi.exception.InternalServerError bre ,
                                                                javax.servlet.http.HttpServletRequest request ,javax.servlet.http.HttpServletResponse resp ) {
        
        java.util.HashMap<String, Object> result = new java.util.HashMap<>();
        result.put("message" ,"Oops something went Wrong");
        return result;
    }
}

