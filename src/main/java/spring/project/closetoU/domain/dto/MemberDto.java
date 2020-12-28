package spring.project.closetoU.domain.dto;

import lombok.Builder;
import lombok.Getter;
import spring.project.closetoU.domain.Gender;
import spring.project.closetoU.domain.Member;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Getter
public class MemberDto {
    private String email;
    private String name;
    private int age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private LocalDate birthday;
    private String nickname;

    @Builder
    public MemberDto(Member member) {
        this.email = member.getEmail();
        this.name = member.getName();
        this.age = member.getAge();
        this.gender = member.getGender();
        this.birthday = member.getBirthday();
        this.nickname = member.getNickname();
    }

    public Member toEntity(){
        return Member.builder()
                .email(this.email)
                .name(this.name)
                .age(this.age)
                .gender(this.gender)
                .birthday(this.birthday)
                .nickname(this.nickname)
                .build();
    }
}
