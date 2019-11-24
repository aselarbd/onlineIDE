package com.aselad.ide.postgresapp.Result;

import com.aselad.ide.postgresapp.Exception.ResourceNotFoundException;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ResultSet<T> {

    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private T data;

    private ResultSet(){
        this.timestamp = LocalDateTime.now();
    }

    ResultSet(T o, HttpStatus status)
    {
        this();
        if ( o == null || ( o instanceof List && ( ( List ) o ).isEmpty() ) ){
            try {
                throw new ResourceNotFoundException( "No Content Found" );
            } catch (ResourceNotFoundException e) {
                e.printStackTrace();
            }
        }
        this.status = status;
        this.data = o;
    }
}
