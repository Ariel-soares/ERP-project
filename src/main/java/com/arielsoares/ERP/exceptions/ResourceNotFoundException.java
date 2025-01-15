package com.arielsoares.ERP.exceptions;

import java.io.Serial;

public class ResourceNotFoundException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = -3897793457728854181L;

    public ResourceNotFoundException(Object id){
        super("Resource not found. ID: " + id);
    }

}
