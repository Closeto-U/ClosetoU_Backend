package spring.project.closetoU.domain;

import lombok.*;
import spring.project.closetoU.domain.dto.ClosetDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Closet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "closet_id")
    private Long id;

    @Column(unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "closet", cascade = CascadeType.ALL)
    private List<ClosetClothes> closetClothesList = new ArrayList<>();

    @Builder
    public Closet(String name) {
        this.name = name;
    }

    // 연관관계 매핑
    public void setMember(Member member) {
        this.member = member;
    }

    public void update(Closet closet) {
        this.name = closet.getName();
    }

//    public ClosetDto toDto() {
//        return new ClosetDto(this);
//    }
}
