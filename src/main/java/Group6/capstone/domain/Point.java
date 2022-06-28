package Group6.capstone.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Point {

    @Id
    @GeneratedValue
    private long id; // id

    // 장소 정보 (이름, 혼잡도, 실시간 인원, 평균 인원, 사진 소스, 위도, 경도)
    private String place;
    private int percentage;
    private int count;
    private int avgCount;
    private String imgSrc;
    private double latitude;
    private double longitude;

    // 위치 정보 (범위 좌표(위도, 경도))
    private double latTopLeft;
    private double lonTopLeft;
    private double latBottRight;
    private double lonBottRight;

    // Last 요청 시간 (info를 해당 시간 이후로 가져옴)
    private LocalDateTime lastCommittedTime;

    // 연관관계 (일대다 with point)
    @OneToMany(mappedBy = "point")
    private List<Info> infos = new ArrayList<>();


    // 생성 메서드
    public static Point createPoint(String place, int percentage, int count, int avgCount, double latitude, double longitude, String imgSrc,
                                    double lonTopLeft, double latTopLeft, double lonBottRight, double latBottRight, LocalDateTime lastCommittedTime) {
        Point point = new Point();
        point.place = place;
        point.percentage = percentage;
        point.count = count;
        point.avgCount = avgCount;
        point.latitude = latitude;
        point.longitude = longitude;
        point.imgSrc = imgSrc;
        point.lonTopLeft = lonTopLeft;
        point.latTopLeft = latTopLeft;
        point.lonBottRight = lonBottRight;
        point.latBottRight = latBottRight;
        point.lastCommittedTime = lastCommittedTime;
        return point;
    }

    public void changeCount(int cnt) {
        this.count = cnt;
    }

    public void changePercentage(int percentage) {
        this.percentage = percentage;
    }

    public void changeLastCommittedTime(LocalDateTime lastCommittedTime) {
        this.lastCommittedTime = lastCommittedTime;
    }
}
