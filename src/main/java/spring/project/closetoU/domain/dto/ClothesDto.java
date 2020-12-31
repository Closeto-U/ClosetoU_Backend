package spring.project.closetoU.domain.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import spring.project.closetoU.domain.Clothes;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ClothesDto {
    private String name;
    private String brand;
    private String clothes_type;
    private String color;

    public ClothesDto(Clothes clothes) {
        this.name = clothes.getName();
        this.brand = clothes.getBrand();
        this.clothes_type = clothes.getClothes_type();
        this.color = clothes.getColor();
    }

    @Builder
    public ClothesDto(String name, String brand, String clothes_type, String color) {
        this.name = name;
        this.brand = brand;
        this.clothes_type = clothes_type;
        this.color = color;
    }
}
