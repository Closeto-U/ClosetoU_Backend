package spring.project.closetoU.domain;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class SecurityMember extends User {

    public SecurityMember(Member member) {
        super(member.getEmail(),
                member.getPassword(),
                AuthorityUtils.createAuthorityList(member.getRole().toString()));
    }
}
