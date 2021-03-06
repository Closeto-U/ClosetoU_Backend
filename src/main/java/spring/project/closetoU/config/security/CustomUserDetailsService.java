package spring.project.closetoU.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import spring.project.closetoU.advice.exception.EntityNotFoundException;
import spring.project.closetoU.domain.Member;
import spring.project.closetoU.domain.SecurityMember;
import spring.project.closetoU.repository.MemberRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member findmember = memberRepository.findByEmail(username)
                .orElseThrow(() -> new EntityNotFoundException(username + " Invalid"));

        return new SecurityMember(findmember);
    }
}
