package spring.project.closetoU.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.project.closetoU.advice.exception.EntityNotFoundException;
import spring.project.closetoU.domain.Closet;
import spring.project.closetoU.domain.ClosetClothes;
import spring.project.closetoU.domain.Clothes;
import spring.project.closetoU.domain.dto.CCDto;
import spring.project.closetoU.repository.ClosetRepository;
import spring.project.closetoU.repository.ClothesRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ClothesService {

    private final ClosetRepository closetRepository;
    private final ClothesRepository clothesRepository;

    @Transactional
    public Long save(Long closetId, Clothes clothes) {
        Closet closet = closetRepository.findById(closetId)
                .orElseThrow(() -> new EntityNotFoundException(String.format("ID [%s] 엔티티가 존재하지 않습니다.", closetId)));

        ClosetClothes cc = new ClosetClothes(closet, clothes);

        Clothes savedClothes = clothesRepository.save(clothes);

        return savedClothes.getId();
    }

    public Clothes findById(Long clothesId) {
        return clothesRepository.findById(clothesId)
                .orElseThrow(() -> new EntityNotFoundException(String.format("ID [%s] 엔티티가 존재하지 않습니다.", clothesId)));
    }

    public List<Clothes> findAll() {
        return clothesRepository.findAll();
    }

    @Transactional
    public void delete(Long clothesId) {
        clothesRepository.deleteById(clothesId);
    }

    public List<Clothes> findClothesDtoByClosetId(Long closetId) {
        return clothesRepository.findClothesDtoByClosetId(closetId);
    }

    public List<CCDto> findClothesDtoByClosetIds(List<Long> closetIds) {
        return clothesRepository.findClothesDtoByClosetIds(closetIds);
    }
}
