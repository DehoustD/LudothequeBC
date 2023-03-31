package com.example.testons;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PhoneTest {
    @Test
    void checkPhoneLength(){
        assertThrows(IllegalArgumentException.class, ()->{
            Phone phone = new Phone("047959");
        }, "Doit contenir 10 chiffres");

        assertDoesNotThrow(()->{
            Phone phone = new Phone("0479591596");
        });
        
        Phone myphone = new Phone("0479591595");
        assertTrue(myphone.checkDigits());

        myphone = new Phone("047959159a");
        assertFalse(myphone.checkDigits());

        myphone = new Phone("0479591595");
        assertEquals("0479/59.15.95", myphone.toString());
    }
}
