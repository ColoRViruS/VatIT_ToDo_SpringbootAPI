package com.vatit.technicalassessment.ToDoapi.controller;

@org.springframework.web.bind.annotation.RestController
@io.swagger.annotations.SwaggerDefinition(schemes = io.swagger.annotations.SwaggerDefinition.Scheme.HTTP)
public class ToDoController {
    
    
    //GET Method for the API. This method retrieves a JSON object that contains an array of ToDo Items.
    //Represents the Retrieve portion of the CRUD model
    
    @org.springframework.web.bind.annotation.RequestMapping(value = "/todos", method = org.springframework.web.bind.annotation.RequestMethod.GET)
    @io.swagger.annotations.ApiOperation(value = "Get a List of ToDos")
    @io.swagger.annotations.ApiResponses({
      @io.swagger.annotations.ApiResponse(code = 200, message = "Success", response = com.vatit.technicalassessment.ToDoapi.controller.json.ToDos.class) ,
      @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Service Error", response = com.vatit.technicalassessment.ToDoapi.controller.json.InternalServiceError.class)
    })
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
    
    //POST Method for the API. This method retrieves only a Response Code to represent success or failure.
    //Represents the Create portion of the CRUD model
    
    @org.springframework.web.bind.annotation.PostMapping(path = "/todos", consumes = "application/json")
    @io.swagger.annotations.ApiOperation(value = "Add a ToDos to the List")
    
    @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Service Error", response = com.vatit.technicalassessment.ToDoapi.controller.json.InternalServiceError.class)
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
    
    //PUT Method for the API. This method consumes a ToDo JSON object with which
    // to update the In-Memory storage with new Name of Completed value
    //Represents the Update portion of the CRUD model
    
    @org.springframework.web.bind.annotation.PutMapping("/todos/{aUrlParameter}")
    @io.swagger.annotations.ApiOperation(value = "Update a ToDo")
    @io.swagger.annotations.ApiResponses({
      @io.swagger.annotations.ApiResponse(code = 200, message = "Success", response = com.vatit.technicalassessment.ToDoapi.controller.json.ToDo.class) ,
      @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Service Error",
        response = com.vatit.technicalassessment.ToDoapi.controller.json.InternalServiceError.class)
    })
    public String updateToDO( @org.springframework.web.bind.annotation.PathVariable("aUrlParameter") String aUrlParameter ,
                              @org.springframework.web.bind.annotation.RequestBody com.vatit.technicalassessment.ToDoapi.controller.json.ToDo aToDo )
    throws com.vatit.technicalassessment.ToDoapi.exception.InternalServerError {
        
        if ( com.vatit.technicalassessment.ToDoapi.ToDoList.getToDoHashMap().containsKey(aUrlParameter) ) {
            com.vatit.technicalassessment.ToDoapi.ToDoList.UpdateToDo(aToDo);
        }else {
            throw new com.vatit.technicalassessment.ToDoapi.exception.InternalServerError();
        }
        
        com.google.gson.Gson vGson = new com.google.gson.Gson();
        return vGson.toJson(aToDo);
    }
    
    //DELETE Method for the API. This method retrieves a ID string from
    // the URL which represents the ID of the ToDo that should be removed
    //Represents the Delete or Destory portion of the CRUD model
    
    @org.springframework.web.bind.annotation.DeleteMapping("/todos/{aUrlParameter}")
    @io.swagger.annotations.ApiOperation(value = "Remove a ToDo", httpMethod = "")
    @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Service Error",
      response = com.vatit.technicalassessment.ToDoapi.controller.json.InternalServiceError.class)
    
    public void deleteToDO( @org.springframework.web.bind.annotation.PathVariable("aUrlParameter") String aUrlParameter )
    throws com.vatit.technicalassessment.ToDoapi.exception.InternalServerError {
        
        if ( com.vatit.technicalassessment.ToDoapi.ToDoList.getToDoHashMap().containsKey(aUrlParameter) ) {
            com.vatit.technicalassessment.ToDoapi.ToDoList.getToDoHashMap().remove(aUrlParameter);
        }else {
            throw new com.vatit.technicalassessment.ToDoapi.exception.InternalServerError();
        }
    }
    
    //GET method to get Name of ToDo based on ID of ToDo
    
    @org.springframework.web.bind.annotation.RequestMapping(value = "/todos/{aUrlParameter}/name", method = org.springframework.web.bind.annotation.RequestMethod.GET)
    @io.swagger.annotations.ApiOperation(value = "Get Name of Task by ID")
    @io.swagger.annotations.ApiResponses({
      @io.swagger.annotations.ApiResponse(code = 200, message = "Success", response = String.class) ,
      @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Service Error", response = com.vatit.technicalassessment.ToDoapi.controller.json.InternalServiceError.class)
    })
    public String getNameByID( @org.springframework.web.bind.annotation.PathVariable("aUrlParameter") String aUrlParameter )
    throws com.vatit.technicalassessment.ToDoapi.exception.InternalServerError {
        try {
            com.vatit.technicalassessment.ToDoapi.controller.json.ToDo vToDo;
            if ( com.vatit.technicalassessment.ToDoapi.ToDoList.getToDoHashMap().containsKey(aUrlParameter) ) {
                vToDo = com.vatit.technicalassessment.ToDoapi.ToDoList.getToDoHashMap().get(aUrlParameter);
            }else {
                throw new com.vatit.technicalassessment.ToDoapi.exception.InternalServerError();
            }
            
            return vToDo.getName();
        }catch ( Exception aException ) {
            throw new com.vatit.technicalassessment.ToDoapi.exception.InternalServerError();
        }
    }
    
    //GET method to get Completion of ToDo based on ID of ToDo
    
    @org.springframework.web.bind.annotation.RequestMapping(value = "/todos/{aUrlParameter}/completed", method = org.springframework.web.bind.annotation.RequestMethod.GET)
    @io.swagger.annotations.ApiOperation(value = "Get Completion of Task by ID")
    @io.swagger.annotations.ApiResponses({
      @io.swagger.annotations.ApiResponse(code = 200, message = "Success", response = boolean.class) ,
      @io.swagger.annotations.ApiResponse(code = 500, message = "Internal Service Error", response = com.vatit.technicalassessment.ToDoapi.controller.json.InternalServiceError.class)
    })
    public boolean getCompletionByID( @org.springframework.web.bind.annotation.PathVariable("aUrlParameter") String aUrlParameter )
    throws com.vatit.technicalassessment.ToDoapi.exception.InternalServerError {
        try {
            com.vatit.technicalassessment.ToDoapi.controller.json.ToDo vToDo;
            if ( com.vatit.technicalassessment.ToDoapi.ToDoList.getToDoHashMap().containsKey(aUrlParameter) ) {
                vToDo = com.vatit.technicalassessment.ToDoapi.ToDoList.getToDoHashMap().get(aUrlParameter);
            }else {
                throw new com.vatit.technicalassessment.ToDoapi.exception.InternalServerError();
            }
            
            return vToDo.isCompleted();
        }catch ( Exception aException ) {
            throw new com.vatit.technicalassessment.ToDoapi.exception.InternalServerError();
        }
    }
    
    
    //This method is the Exception handler that will present the user with a Error message if there is something wrong in the System.
    
    @org.springframework.web.bind.annotation.ExceptionHandler(com.vatit.technicalassessment.ToDoapi.exception.InternalServerError.class)
    @org.springframework.web.bind.annotation.ResponseStatus(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR)
    public @org.springframework.web.bind.annotation.ResponseBody
    com.vatit.technicalassessment.ToDoapi.controller.json.InternalServiceError HandlesInternalServerError( com.vatit.technicalassessment.ToDoapi.exception.InternalServerError bre ,
                                                                                                           javax.servlet.http.HttpServletRequest request ,javax.servlet.http.HttpServletResponse resp ) {
        
        com.vatit.technicalassessment.ToDoapi.controller.json.InternalServiceError vInternalServiceError = new com.vatit.technicalassessment.ToDoapi.controller.json.InternalServiceError();
        vInternalServiceError.setMessage("Oops something went Wrong");
        return vInternalServiceError;
    }
}

