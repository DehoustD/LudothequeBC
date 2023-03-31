package com.example.testons;

public class Phone {
    private String myPhone;

    public Phone(String phone) {
        myPhone = phone;        
        checkLength();
    }

    public boolean checkDigits() {
        for (int index = 0; index < myPhone.length(); index++) {
            if (!Character.isDigit(myPhone.charAt(index))) {
                return false;
            }
        }
        return true;
    }

    private void checkLength() {
        if(this.myPhone.length()!=10){
            throw new IllegalArgumentException("Le numéro doit contenir 10 chiffres. ");
        }
    }

    @Override
    public String toString() {
        //0479591495
        String result = myPhone.substring(0, 4)+"/"; //.   /
        result += myPhone.substring(4, 6)+".";
        result += myPhone.substring(6, 8)+".";
        result += myPhone.substring(8, 10);
        return result;
    }



}
