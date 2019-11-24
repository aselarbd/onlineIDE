package com.aselad.ide.postgresapp.Result;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SuppressWarnings( "unchecked" )
public class ResponseWrapper<T> extends ResponseEntity {

    public ResponseWrapper(T t , HttpStatus status ){
        super( ( T ) new ResultSet<>( t,status ),status);
    }

}
