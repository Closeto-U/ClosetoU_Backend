package spring.project.closetoU.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.project.closetoU.advice.exception.AccessDeniedException;
import spring.project.closetoU.advice.exception.AuthenticationEntryPointException;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/exception")
public class ExceptionController {

    @GetMapping(path = "/entrypoint")
    public ResponseEntity<Object> entryPointException() {
        throw new AuthenticationEntryPointException("해당 리소스에 접근하기 위한 권한이 없습니다.");
    }

    @GetMapping(path = "/accessdenied")
    public ResponseEntity<Object> accessdeniedException() {
        throw new AccessDeniedException("보유한 권한으로 접근할 수 없는 리소스 입니다.");
    }
}
