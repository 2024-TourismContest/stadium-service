package yaguhang.stadium.application;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yaguhang.stadium.domain.Stadium;
import yaguhang.stadium.dto.StadiumMapXY;
import yaguhang.stadium.repository.StadiumRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StadiumService {
    private final StadiumRepository stadiumRepository;
    @Transactional
    public void saveStadiums(List<Stadium> stadiums) {
        if (stadiumRepository.count() == 0) {
            stadiumRepository.saveAll(stadiums);
        }
    }

    public StadiumMapXY getStadiumMapXY(Long stadiumId) {
        Stadium stadium = stadiumRepository.findById(stadiumId)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 구장 이름입니다."));

        return StadiumMapXY.builder()
                .stadiumId(stadium.getId())
                .name(stadium.getName())
                .mapX(stadium.getX())
                .mapY(stadium.getY())
                .build();
    }
}
