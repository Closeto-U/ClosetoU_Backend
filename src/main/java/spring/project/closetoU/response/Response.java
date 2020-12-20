package spring.project.closetoU.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response<T> {
    private T data;
    private int code;
    private String msg;
}
