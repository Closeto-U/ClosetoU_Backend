package spring.project.closetoU.domain.dto;

import lombok.Builder;
import lombok.Getter;
import spring.project.closetoU.domain.Closet;
import spring.project.closetoU.domain.Clothes;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ClosetDto {

    private String closetName;
    private List<Clothes> clothesList;

    @Builder
    public ClosetDto(Closet closet) {
        this.closetName = closet.getName();
    }
}
