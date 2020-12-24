package spring.project.closetoU.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import spring.project.closetoU.domain.Member;
import spring.project.closetoU.dto.MemberDto;
import spring.project.closetoU.response.Response;
import spring.project.closetoU.service.MemberService;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping(value = "/join")
    public ResponseEntity<URI> join(@RequestBody Member member) {
        memberService.checkExistsEmail(member.getEmail());

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(memberService.join(member))
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping(value = "/list")
    public Response<List<MemberDto>> list() {
        List<MemberDto> memberDtoList = memberService.findAll()
                .stream()
                .map(MemberDto::new)
                .collect(Collectors.toList());

        return new Response<>(memberDtoList, HttpStatus.OK.value(), "모든 회원 조회에 성공하였습니다.");
    }

    @GetMapping(value = "/{id}")
    public Response<MemberDto> findById(@PathVariable("id") Long memberId) {
        return new Response<>(
                memberService.findById(memberId).toDto(),
                HttpStatus.OK.value(),
                String.format("ID [%s] 회원 정보 조회에 성공하였습니다.", memberId));
    }

    @PutMapping(value = "/{id}/update")
    public ResponseEntity<String> update(@PathVariable("id") Long memberId, @RequestBody Member member) {
        memberService.update(memberId, member);

        return ResponseEntity.accepted().build();
    }

    @DeleteMapping(value = "/{id}/delete")
    public ResponseEntity<String> delete(@PathVariable("id") Long memberId) {
        memberService.delete(memberId);

        return ResponseEntity.accepted().build();
    }
}
