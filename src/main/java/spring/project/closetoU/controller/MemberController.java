package spring.project.closetoU.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import spring.project.closetoU.advice.exception.PasswordFailedException;
import spring.project.closetoU.config.security.JwtTokenProvider;
import spring.project.closetoU.domain.Member;
import spring.project.closetoU.domain.dto.MemberDto;
import spring.project.closetoU.response.Response;
import spring.project.closetoU.service.MemberService;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/signin")
    public ResponseEntity<String> signin(@RequestBody Map<String, String> member) {
        Member findMember = memberService.findByEmail(member.get("email"));

        if (!passwordEncoder.matches(member.get("password"), findMember.getPassword()))
            throw new PasswordFailedException("패스워드가 틀렸습니다.");

        return new ResponseEntity<>(jwtTokenProvider.createToken(findMember.getEmail()), HttpStatus.OK);
    }

    @PostMapping("/join")
    public ResponseEntity<URI> join(@RequestBody Member member) {
        memberService.checkExistsEmail(member.getEmail());

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(memberService.join(member))
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/list")
    public Response<List<MemberDto>> findList() {
        List<MemberDto> memberDtoList = memberService.findAll()
                .stream()
                .map(MemberDto::new)
                .collect(Collectors.toList());

        return Response.<List<MemberDto>>builder()
                .data(memberDtoList)
                .isSuccess(true)
                .className("Member")
                .msg("모든 회원 조회에 성공하였습니다.")
                .build();
    }

    @GetMapping("/{id}")
    public Response<MemberDto> findOne(@PathVariable("id") Long memberId) {
        MemberDto memberDto = memberService.findById(memberId).toDto();

        return Response.<MemberDto>builder()
                .data(memberDto)
                .isSuccess(true)
                .className("Member")
                .msg(String.format("ID [%s] 회원 정보 조회에 성공하였습니다.", memberId))
                .build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Long> update(@PathVariable("id") Long memberId, @RequestBody Member member) {
        memberService.update(memberId, member);

        return new ResponseEntity<>(memberId, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long memberId) {
        memberService.delete(memberId);

        return new ResponseEntity<>(memberId, HttpStatus.NO_CONTENT);
    }
}
