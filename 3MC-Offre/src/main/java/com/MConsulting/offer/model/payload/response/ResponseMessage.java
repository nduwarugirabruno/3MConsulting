package com.MConsulting.offer.model.payload.response;

public class ResponseMessage {

    private String message;

    public ResponseMessage (String message) {
        this.message = message;
    }

    public String getMessage () {
        return this.message;
    }
    
}