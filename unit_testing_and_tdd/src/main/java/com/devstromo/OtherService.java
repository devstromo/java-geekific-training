package com.devstromo;

public class OtherService {
    public String myObjectToJson(MyObject object) throws InvalidMyObjectException {
        if(object == null){
            throw  new InvalidMyObjectException();
        }
        return null;
    }
}
