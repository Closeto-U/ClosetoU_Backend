package spring.project.closetoU.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.project.closetoU.advice.exception.EntityNotFoundException;
import spring.project.closetoU.domain.Closet;
import spring.project.closetoU.domain.Clothes;
import spring.project.closetoU.domain.Member;
import spring.project.closetoU.domain.dto.ClosetDto;
import spring.project.closetoU.domain.dto.ClothesDto;
import spring.project.closetoU.repository.ClosetClothesRepository;
import spring.project.closetoU.repository.ClosetRepository;
import spring.project.closetoU.repository.ClothesRepository;
import spring.project.closetoU.repository.MemberRepository;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ClosetService {

    private final ClosetRepository closetRepository;
    private final ClosetClothesRepository closetClothesRepository;
    private final ClothesRepository clothesRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public Long save(Long memberId, Closet closet) {
        Member findMember = memberRepository.findById(memberId)
                .orElseThrow(() -> new EntityNotFoundException(String.format("ID [%s] 엔티티가 존재하지 않습니다.", memberId)));

        Closet savedCloset = closetRepository.save(closet);

        findMember.addCloset(savedCloset);

        return savedCloset.getId();
    }

    public Closet findById(Long closetId) {
        return closetRepository.findById(closetId)
                .orElseThrow(() -> new EntityNotFoundException(String.format("ID [%s] 엔티티가 존재하지 않습니다.", closetId)));
    }

    public Closet findByName(String name) {
        return closetRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Name [%s] 엔티티가 존재하지 않습니다.", name)));
    }

    public List<Closet> findAll() {
        return closetRepository.findAll();
    }

    @Transactional
    public void update(Long closetId, Closet closet) {
        Closet findCloset = findById(closetId);

        findCloset.update(closet);
    }

    @Transactional
    public void delete(Long closetId) {
        closetRepository.deleteById(closetId);
    }

    public List<Closet> findClosetByMemberId(Long memberId){
        return closetRepository.findClosetByMemberId(memberId);
    }

}
