package spring.project.closetoU.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "closet_clothes")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ClosetClothes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "closet_clothes_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "closet_id")
    private Closet closet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clothes_id")
    private Clothes clothes;

    public ClosetClothes(Closet closet, Clothes clothes) {
        addCloset(closet);
        addClothes(clothes);
    }

    public void addCloset(Closet closet) {
        this.closet = closet;
        closet.getClosetClothesList().add(this);
    }

    public void addClothes(Clothes clothes) {
        this.clothes = clothes;
        clothes.getClosetClothesList().add(this);
    }
}
