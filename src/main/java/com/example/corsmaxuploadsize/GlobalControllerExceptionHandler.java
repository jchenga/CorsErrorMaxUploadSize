package com.example.corsmaxuploadsize;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Slf4j
public class GlobalControllerExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler({MaxUploadSizeExceededException.class})
  @ResponseStatus()
  public String handleMaxUploadSizeExceededException(
      MaxUploadSizeExceededException ex) {
    log.error("Max file size exception", ex);
    return "You have exceeded the maximum size of the file";
  }
}
