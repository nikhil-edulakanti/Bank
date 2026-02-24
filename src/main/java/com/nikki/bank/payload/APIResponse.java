package com.nikki.bank.payload;



public class APIResponse {
    public String message;
    public boolean status;

    public APIResponse(String message, boolean status) {
        this.message = message;
        this.status = status;
    }
}
