package spring.project.closetoU.domain;


import lombok.Getter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

@Getter
public class SecurityMember extends User {

    private Member member;

    public SecurityMember(Member member) {
        super(member.getEmail(),
                member.getPassword(),
                AuthorityUtils.createAuthorityList(member.getRole().toString()));

        this.member = member;
    }
}
