package cn.taike.mongo.basement.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by huayandong on 17/8/17.
 */
@Slf4j
@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(Exception.class)
    public Object allException(Exception e) {
        log.error("THIS IS ABOVE CONTROLLER EXCEPTION.", e);
        return ResponseEntity.badRequest().build();
    }
}
