package spring.project.closetoU;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import spring.project.closetoU.domain.Gender;
import spring.project.closetoU.domain.Member;
import spring.project.closetoU.service.MemberService;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@SpringBootApplication
public class ClosetoUApplication {

    @Autowired
    private MemberService memberService;

    @PostConstruct
    public void addTestData() {
        memberService.join(Member.builder().email("wonju@naver.com").password("1234")
                .name("손원주").age(27).gender(Gender.MALE)
                .birthday(LocalDate.of(1994, 1, 21))
                .nickname("기내식은수박바").build());
        memberService.join(Member.builder().email("sonwonjoo@naver.com").password("1234")
                .name("손원주123242").age(44).gender(Gender.FEMALE)
                .birthday(LocalDate.of(2020, 3, 21))
                .nickname("바바바바바바").build());
    }

    public static void main(String[] args) {
        SpringApplication.run(ClosetoUApplication.class, args);
    }

}
