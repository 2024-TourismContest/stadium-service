package yaguhang.stadium.dto;

import yaguhang.stadium.domain.Stadium;

public record StadiumDetailInfo(
        Long id,
        float x,
        float y,
        String name,
        String team,
        String image,
        int nx,
        int ny
) {

    public static StadiumDetailInfo from(Stadium s) {
        return new StadiumDetailInfo(
                s.getId(),
                s.getX(),
                s.getY(),
                s.getName(),
                s.getTeam(),
                s.getImage(),
                s.getNx(),
                s.getNy()
        );
    }
}
