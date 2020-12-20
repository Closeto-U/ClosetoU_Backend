package spring.project.closetoU.domain;

import lombok.Getter;

import javax.persistence.*;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "closet_id")
    private Closet closet;
}
