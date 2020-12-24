package spring.project.closetoU.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse {
    private LocalDateTime timestamp;
    private String message;
    private String details;
}
