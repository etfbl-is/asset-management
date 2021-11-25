package org.unibl.etf.is.am.exceptions;

import org.springframework.http.HttpStatus;

public class BadRequestException extends HttpException{

    public BadRequestException(){
        super(HttpStatus.BAD_REQUEST,null);
    }


    public BadRequestException(Object data){
        super(HttpStatus.BAD_REQUEST,data);
    }
}
