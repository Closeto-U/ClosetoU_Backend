package spring.project.closetoU.domain.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import spring.project.closetoU.domain.Clothes;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CCDto {

    private Long closetId;
    private ClothesDto clothesDto;

    public CCDto(Long closetId, ClothesDto clothesDto) {
        this.closetId = closetId;
        this.clothesDto = clothesDto;
    }
}
