package spring.project.closetoU.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import spring.project.closetoU.domain.dto.ClothesDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Clothes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clothes_id")
    private Long id;

    private String name;
    private String brand;
    private String clothes_type;
    private String color;

    @OneToMany(mappedBy = "clothes", cascade = CascadeType.ALL)
    private List<ClosetClothes> closetClothesList = new ArrayList<>();

    @Builder
    public Clothes(String name, String brand, String clothes_type, String color) {
        this.name = name;
        this.brand = brand;
        this.clothes_type = clothes_type;
        this.color = color;
    }

    public ClothesDto toDto() {
        return ClothesDto.builder()
                .name(this.name)
                .brand(this.brand)
                .clothes_type(this.clothes_type)
                .color(this.color)
                .build();
    }

}
