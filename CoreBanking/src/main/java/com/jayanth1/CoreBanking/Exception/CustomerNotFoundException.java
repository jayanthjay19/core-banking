package com.jayanth1.CoreBanking.Exception;

public class CustomerNotFoundException extends RuntimeException {

    public  CustomerNotFoundException(Long id){
        super("Customer doesn't exist with id : " + id);
    }

}
