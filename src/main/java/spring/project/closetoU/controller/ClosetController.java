package spring.project.closetoU.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import spring.project.closetoU.domain.Closet;
import spring.project.closetoU.domain.Clothes;
import spring.project.closetoU.domain.dto.CCDto;
import spring.project.closetoU.domain.dto.ClosetDto;
import spring.project.closetoU.domain.dto.ClothesDto;
import spring.project.closetoU.response.Response;
import spring.project.closetoU.service.ClosetService;
import spring.project.closetoU.service.ClothesService;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/closet")
public class ClosetController {

    private final ClosetService closetService;
    private final ClothesService clothesService;

    @PostMapping("/{id}")
    public ResponseEntity<URI> save(@PathVariable("id") Long memberId, @RequestBody Closet closet) {
        Long savedId = closetService.save(memberId, closet);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedId)
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public Response<ClosetDto> findOne(@PathVariable("id") Long closetId) {
        Closet findCloset = closetService.findById(closetId);
        List<ClothesDto> clothesDtoList = clothesService.findClothesDtoByClosetId(closetId)
                .stream()
                .map(ClothesDto::new)
                .collect(Collectors.toList());

        return Response.<ClosetDto>builder()
                .data(new ClosetDto(findCloset.getClosetName(), clothesDtoList))
                .className("Closet")
                .isSuccess(true)
                .msg(String.format("ID [%s] 옷장 정보 조회에 성공하였습니다.", closetId))
                .build();
    }

    @GetMapping("/list/{id}")
    public Response<List<ClosetDto>> findListPerMember(@PathVariable("id") Long memberId) {
        Map<Long, List<ClothesDto>> map = new HashMap<>();
        List<ClosetDto> closetDtoList = new ArrayList<>();

        List<Closet> findClosets = closetService.findClosetListByMemberId(memberId);
        List<Long> closetIds = findClosets.stream()
                .map(Closet::getId)
                .collect(Collectors.toList());

        List<CCDto> ccDtoList = clothesService.findClothesDtoByClosetIds(closetIds);

        for (CCDto ccDto : ccDtoList) {
            map.putIfAbsent(ccDto.getClosetId(), new ArrayList<>());
            map.get(ccDto.getClosetId()).add(ccDto.getClothesDto());
        }

        for (Closet closet : findClosets)
            closetDtoList.add(new ClosetDto(closet.getClosetName(), map.get(closet.getId())));

        return Response.<List<ClosetDto>>builder()
                .data(closetDtoList)
                .className("Closet")
                .isSuccess(true)
                .msg(String.format("멤버 [%s]의 모든 옷장 조회에 성공하였습니다.", memberId))
                .build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Long> update(@PathVariable("id") Long closetId, @RequestBody Closet closet) {
        closetService.update(closetId, closet);

        return new ResponseEntity<>(closetId, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long closetId) {
        closetService.delete(closetId);

        return new ResponseEntity<>(closetId, HttpStatus.OK);
    }
}
