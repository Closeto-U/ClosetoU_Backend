package spring.project.closetoU.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import spring.project.closetoU.domain.Closet;

import java.util.List;

@Getter
@NoArgsConstructor
public class ClosetDto {

    private String closetName;
    private List<ClothesDto> clothesList;


    public ClosetDto(Closet closet, List<ClothesDto> clothesList) {
        this.closetName = closet.getClosetName();
        this.clothesList = clothesList;
    }
}
