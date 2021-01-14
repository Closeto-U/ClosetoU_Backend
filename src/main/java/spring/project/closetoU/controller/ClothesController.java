package spring.project.closetoU.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.project.closetoU.domain.Clothes;
import spring.project.closetoU.domain.dto.ClothesDto;
import spring.project.closetoU.response.Response;
import spring.project.closetoU.service.ClothesService;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/clothes")
public class ClothesController {

    private final ClothesService clothesService;

    @GetMapping("/{id}")
    public Response<ClothesDto> find(@PathVariable("id") Long clothesId) {
        ClothesDto clothesDto = clothesService.findById(clothesId).toDto();

        return Response.<ClothesDto>builder()
                .data(clothesDto)
                .isSuccess(true)
                .className("Clothes")
                .msg(String.format("ID [%s] 옷 조회에 성공하였습니다.", clothesId))
                .build();
    }

    @GetMapping("/list")
    public Response<List<ClothesDto>> findList() {
        List<ClothesDto> clothesDtoList = clothesService.findAll()
                .stream()
                .map(ClothesDto::new)
                .collect(Collectors.toList());

        return Response.<List<ClothesDto>>builder()
                .data(clothesDtoList)
                .isSuccess(true)
                .className("Clothes")
                .msg("모든 옷 조회에 성공하였습니다.")
                .build();
    }

//    @PatchMapping("/{id}")
//    public ResponseEntity<Long> update(@PathVariable("id") Long clothesId, @RequestBody) {
//        Clothes findClothes = clothesService.findById(clothesId);
//
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long clothesId) {
        clothesService.delete(clothesId);

        return new ResponseEntity<>(clothesId, HttpStatus.NO_CONTENT);
    }
}
