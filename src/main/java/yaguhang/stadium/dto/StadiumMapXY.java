package yaguhang.stadium.dto;

import lombok.Builder;

@Builder
public record StadiumMapXY(
        String name,
        Long stadiumId,
        double mapX,
        double mapY
) {
}
