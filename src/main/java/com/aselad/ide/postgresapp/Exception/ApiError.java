package com.aselad.ide.postgresapp.Exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;
import static com.aselad.ide.postgresapp.Constants.DATE_FORMAT;


@Data
class ApiError
{



    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
    private LocalDateTime timestamp;
    private String message;
    private String debugMessage;
    private String path;

    private ApiError()
    {
        timestamp = LocalDateTime.now();
    }

    ApiError( HttpStatus status )
    {
        this();
        this.status = status;
    }

    ApiError( HttpStatus status, Throwable ex )
    {
        this(status);
        this.message = "Unexpected error";
        this.debugMessage = ex.getLocalizedMessage();
    }

    ApiError( HttpStatus status, String message, Throwable ex )
    {
        this(status,ex);
        this.message = message;
    }

    ApiError( HttpStatus status, String message,String path, Throwable ex )
    {
        this(status,message,ex);
        this.path = path;

    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDebugMessage(String debugMessage) {
        this.debugMessage = debugMessage;
    }
}