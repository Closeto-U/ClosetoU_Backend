package spring.project.closetoU.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import spring.project.closetoU.domain.dto.MemberDto;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false, unique = true, updatable = false)
    private String email;

    @Column(nullable = false)
    private String password;
    private String name;
    private int age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private LocalDate birthday;
    private String nickname;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Closet> closetList = new ArrayList<>();

    @Builder
    public Member(String email, String password, String name, int age, Gender gender, LocalDate birthday, String nickname) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.birthday = birthday;
        this.nickname = nickname;
        this.role = Role.USER;
    }

    public MemberDto toDto(){
        return MemberDto.builder()
                .member(this)
                .build();
    }

    public void setEncodePassword(String password) {
        this.password = password;
    }

    public void addCloset(Closet closet) {
        this.closetList.add(closet);
        closet.setMember(this);
    }

    public void update(Member member) {
        this.password = member.getPassword();
        this.name = member.getName();
        this.age = member.getAge();
        this.gender = member.getGender();
        this.birthday = member.getBirthday();
        this.nickname = member.getNickname();
    }
}
