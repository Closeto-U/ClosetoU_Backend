package spring.project.closetoU.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import spring.project.closetoU.domain.Closet;
import spring.project.closetoU.domain.Clothes;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class ClosetDto {

    private String closetName;
    private List<ClothesDto> clothesList;


    public ClosetDto(Closet closet, List<ClothesDto> clothesList) {
        this.closetName = closet.getName();
        this.clothesList = clothesList;
    }
}
