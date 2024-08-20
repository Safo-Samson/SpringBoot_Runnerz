package com.safosamson.runnerz.run;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)  // the @ResponseStatus annotation tells Spring to return a 404 status code when this exception is thrown
public class RunNotFoundException extends RuntimeException {
    public RunNotFoundException() {
        super("Run not found");
    }
}
