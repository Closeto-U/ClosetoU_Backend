package spring.project.closetoU.domain.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import spring.project.closetoU.domain.Clothes;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ClothesDto {
    private Long id;
    private String name;
    private String brand;
    private String clothes_type;
    private String color;

    public ClothesDto(Long id, String name, String brand, String clothes_type, String color) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.clothes_type = clothes_type;
        this.color = color;
    }

    @Builder
    public ClothesDto(Clothes clothes) {
        this.id = clothes.getId();
        this.name = clothes.getName();
        this.brand = clothes.getBrand();
        this.clothes_type = clothes.getClothes_type();
        this.color = clothes.getColor();
    }
}
