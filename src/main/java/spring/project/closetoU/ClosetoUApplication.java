package spring.project.closetoU;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import spring.project.closetoU.domain.Closet;
import spring.project.closetoU.domain.Clothes;
import spring.project.closetoU.domain.Gender;
import spring.project.closetoU.domain.Member;
import spring.project.closetoU.service.ClosetService;
import spring.project.closetoU.service.ClothesService;
import spring.project.closetoU.service.MemberService;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.time.LocalDate;

@SpringBootApplication
public class ClosetoUApplication {

    @Autowired
    private MemberService memberService;

    @Autowired
    private ClosetService closetService;

    @Autowired
    private ClothesService clothesService;

    @Autowired
    private PasswordEncoder passwordEncoder;

//    @PostConstruct
//    public void addTestData() {
//        memberService.join(Member.builder().email("wonju@naver.com")
//                .password(passwordEncoder.encode("1234"))
//                .name("손원주").age(27).gender(Gender.MALE)
//                .birthday(LocalDate.of(1994, 1, 21))
//                .nickname("기내식은수박바").build());
//
//        memberService.join(Member.builder().email("sonwonjoo@naver.com")
//                .password(passwordEncoder.encode("4321"))
//                .name("손원주123242").age(44).gender(Gender.FEMALE)
//                .birthday(LocalDate.of(2020, 3, 21))
//                .nickname("바바바바바바").build());
//
//        closetService.save(1L, Closet.builder()
//                .closetName("멤버1의 1번 옷장")
//                .build());
//
//        closetService.save(1L, Closet.builder()
//                .closetName("멤버1의 2번 옷장")
//                .build());
//
//        closetService.save(2L, Closet.builder()
//                .closetName("멤버2의 1번 옷장")
//                .build());
//
//        clothesService.save(1L, Clothes.builder()
//                .name("겨울옷")
//                .brand("나이키")
//                .color("검은색")
//                .clothes_type("상의")
//                .build());
//
//        clothesService.save(1L, Clothes.builder()
//                .name("겨울옷")
//                .brand("나이키")
//                .color("빨간색")
//                .clothes_type("하의")
//                .build());
//
//        clothesService.save(2L, Clothes.builder()
//                .name("가을")
//                .brand("아디다스")
//                .color("회색")
//                .clothes_type("츄리닝")
//                .build());
//    }

    @Bean
    public JPAQueryFactory jpaQueryFactory(EntityManager em) {
        return new JPAQueryFactory(em);
    }

    public static void main(String[] args) {
        SpringApplication.run(ClosetoUApplication.class, args);
    }

}
