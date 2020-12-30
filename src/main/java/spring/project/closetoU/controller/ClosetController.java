package spring.project.closetoU.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import spring.project.closetoU.domain.Closet;
import spring.project.closetoU.domain.dto.ClosetDto;
import spring.project.closetoU.response.Response;
import spring.project.closetoU.service.ClosetService;
import spring.project.closetoU.service.ClothesService;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/closet")
public class ClosetController {

    private final ClosetService closetService;
    private final ClothesService clothesService;

    @PostMapping("/save/{id}")
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
        return Response.<ClosetDto>builder()
                .data(closetService.findByIdWithClothes(closetId))
                .className("Closet")
                .isSuccess(true)
                .msg(String.format("ID [%s] 옷장 정보 조회에 성공하였습니다.", closetId))
                .build();
    }

//    @GetMapping("/list")
//    public Response<List<ClosetDto>> findList() {
//        List<ClosetDto> closetDtoList = closetService.findAll()
//                .stream()
//                .map(closet -> (new ClosetDto(closet, closetService.findByIdWithClothes(closet.getId()))))
//                .collect(Collectors.toList());
//
//        return Response.<List<ClosetDto>>builder()
//                .data(closetDtoList)
//                .className("Closet")
//                .isSuccess(true)
//                .msg("모든 옷장 조회에 성공하였습니다.")
//                .build();
//    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Long> update(@PathVariable("id") Long closetId, @RequestBody Closet closet) {
//        closetService.update(closetId, closet);
//
//        return new ResponseEntity<>(closetId, HttpStatus.ACCEPTED);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long closetId) {
        closetService.delete(closetId);

        return new ResponseEntity<>(closetId, HttpStatus.ACCEPTED);
    }
}
