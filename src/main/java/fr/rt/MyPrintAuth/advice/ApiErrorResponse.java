package fr.rt.MyPrintAuth.advice;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiErrorResponse {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date timestamp;
    private HttpStatus status;
    private String message;
    private List<String> errors;

    public ApiErrorResponse(HttpStatus status, String message, String error) {
        this.timestamp = new Date();
        this.status = status;
        this.message = message;
        this.errors = List.of(error);
    }
    public ApiErrorResponse(HttpStatus status, String message, List<String> error) {
        this.timestamp = new Date();
        this.status = status;
        this.message = message;
        this.errors = error;
    }

}
