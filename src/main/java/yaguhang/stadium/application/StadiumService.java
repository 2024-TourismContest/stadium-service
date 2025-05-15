package yaguhang.stadium.application;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yaguhang.stadium.domain.Stadium;
import yaguhang.stadium.dto.StadiumDetailInfo;
import yaguhang.stadium.dto.StadiumMapXY;
import yaguhang.stadium.repository.StadiumRepository;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<StadiumDetailInfo> getStadiumList() {
        return stadiumRepository.findAll().stream()
                .map(StadiumDetailInfo::from)
                .collect(Collectors.toList());
    }
}
