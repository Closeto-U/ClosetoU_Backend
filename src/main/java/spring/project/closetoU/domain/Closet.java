package spring.project.closetoU.domain;

import lombok.*;

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

    @Column(unique = true, nullable = false)
    private String closetName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "closet", cascade = CascadeType.ALL)
    private List<ClosetClothes> closetClothesList = new ArrayList<>();

    @Builder
    public Closet(String closetName) {
        this.closetName = closetName;
    }

    // 연관관계 매핑
    public void setMember(Member member) {
        this.member = member;
    }

    public void update(Closet closet) {
        this.closetName = closet.getClosetName();
    }

//    public ClosetDto toDto() {
//        return new ClosetDto(this);
//    }
}
