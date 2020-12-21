package spring.project.closetoU.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import spring.project.closetoU.domain.Member;
import spring.project.closetoU.dto.MemberDto;
import spring.project.closetoU.exception.NoSearchEntityException;
import spring.project.closetoU.exception.NotUniqueEmailException;
import spring.project.closetoU.response.Response;
import spring.project.closetoU.service.MemberService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping(value = "/join")
    public Response<Long> join(@RequestBody Member member) {
        Response<Long> response = new Response<>();

        try {
            Optional<Member> findMember = memberService.findUser(member.getEmail());

            if(findMember.isPresent())
                throw new NotUniqueEmailException();

            response.setData(memberService.join(member));
            response.setCode(200);
            response.setMsg("회원가입에 성공하였습니다.");
        } catch (NotUniqueEmailException e) {
            response.setCode(400);
            response.setMsg("중복된 이메일입니다.");
        }

        return response;
    }

    @GetMapping(value = "/list")
    public Response<List<MemberDto>> list() {
        Response<List<MemberDto>> response = new Response<>();

        try {
            List<Member> findMembers = memberService.findAll();

            if (findMembers.isEmpty())
                throw new NoSearchEntityException();

            response.setCode(200);
            response.setData(
                    findMembers.stream()
                            .map(MemberDto::new)
                            .collect(Collectors.toList())
            );
            response.setMsg("모든 회원 조회에 성공하였습니다.");
        } catch (NoSearchEntityException e) {
            response.setCode(400);
            response.setMsg("조건에 맞는 회원이 없습니다.");
        }

        return response;
    }

    @GetMapping(value = "/{id}")
    public Response<MemberDto> findById(@PathVariable("id") Long memberId) {
        Response<MemberDto> response = new Response<>();

        try {
            Member findMember = memberService.findById(memberId).orElseThrow(NoSearchEntityException::new);

            response.setCode(200);
            response.setData(findMember.toDto());
            response.setMsg("회원 조회에 성공하였습니다.");
        } catch (NoSearchEntityException e) {
            response.setCode(400);
            response.setMsg("조건에 맞는 회원이 없습니다.");
        }

        return response;
    }

    @PostMapping(value = "/{id}/update")
    public Response<MemberDto> update(@PathVariable("id") Long memberId, @RequestBody Member member) {
        Response<MemberDto> response = new Response<>();

        try {
            response.setCode(200);
            response.setMsg("회원 정보 갱신에 성공하였습니다.");
            response.setData(memberService.update(memberId, member).toDto());
        } catch (NoSearchEntityException e) {
            response.setCode(400);
            response.setMsg("조건에 맞는 회원이 없습니다.");
        }

        return response;
    }

    @PostMapping(value = "/{id}/delete")
    public Response<Long> delete(@PathVariable("id") Long memberId) {
        Response<Long> response = new Response<>();

        try {
            response.setCode(200);
            response.setMsg("회원 정보 삭제에 성공하였습니다.");
            response.setData(memberService.delete(memberId));
        } catch (NoSearchEntityException e) {
            response.setCode(400);
            response.setMsg("조건에 맞는 회원이 없습니다.");
        }

        return response;
    }
}
