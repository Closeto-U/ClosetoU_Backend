package spring.project.closetoU.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.project.closetoU.repository.ClosetClothesRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ClosetClothesService {

    private final ClosetClothesRepository closetClothesRepository;

    public List<Long> findListbyClosetId(Long closetId){
        return closetClothesRepository.findclothesIdsbyClosetId(closetId);
    }
}
