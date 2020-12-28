package spring.project.closetoU.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class Response<T> {
    private T data;
    private boolean isSuccess;
    private String entityClassName;
    private String msg;

    @Builder
    public Response(T data, boolean isSuccess, String className, String msg) {
        this.data = data;
        this.isSuccess = isSuccess;
        this.entityClassName = className;
        this.msg = msg;
    }
}
