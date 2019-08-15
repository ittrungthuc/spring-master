package com.trungthuc.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseAPI {
    private  String message;
    private boolean status;
    private String code;
    private Object object;

    private List<Error> errors = new ArrayList<Error>();
    public void addError(String code,String message,String field){
        this.errors.add(new Error(code,message,field));
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Error {

    private String code;
    private String message;
    private String field;

}
