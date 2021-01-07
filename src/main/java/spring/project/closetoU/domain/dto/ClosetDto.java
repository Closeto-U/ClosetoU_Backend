package spring.project.closetoU.domain.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import spring.project.closetoU.domain.Closet;
import spring.project.closetoU.domain.Clothes;

import java.util.List;

@Getter
@NoArgsConstructor(access =  AccessLevel.PROTECTED)
public class ClosetDto {

    private String closetName;
    private List<ClothesDto> clothesList;

    public ClosetDto(String closetName, List<ClothesDto> clothesList) {
        this.closetName = closetName;
        this.clothesList = clothesList;
    }
}
