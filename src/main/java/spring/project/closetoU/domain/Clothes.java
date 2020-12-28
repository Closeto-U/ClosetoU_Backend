package spring.project.closetoU.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Clothes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clothes_id")
    private Long id;

    private String name;
    private String brand;
    private String clothes_type;
    private String color;

    @OneToMany(mappedBy = "clothes")
    private List<ClosetClothes> closetClothesList = new ArrayList<>();
}
