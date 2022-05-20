package Group6.capstone.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Point {

    @Id @GeneratedValue
    private long id; // id

    private String place; // 장소 이름
    private int percentage; // 혼잡도
    private int count; // 측정 인원
    private int avgCount; // 평균 인원

    // 위치정보 (위도, 경도)
    private double latitude;
    private double longitude;

    private double latTopLeft;
    private double lonTopLeft;
    private double latBottRight;
    private double lonBottRight;

    private String imgSrc;

    // 생성 메서드
    public static Point createPoint(String place, int percentage, int count, int avgCount , double latitude, double longitude, String imgSrc) {
        Point point = new Point();
        point.place = place;
        point.percentage = percentage;
        point.count = count;
        point.avgCount = avgCount;
        point.latitude = latitude;
        point.longitude = longitude;
        point.imgSrc = imgSrc;
        return point;
    }

    public void setRange(double lonTopLeft, double latTopLeft, double lonBottRight, double latBottRight) {
        this.lonTopLeft = lonTopLeft;
        this.latTopLeft = latTopLeft;
        this.lonBottRight = lonBottRight;
        this.latBottRight = latBottRight;
    }

    public void changeCount(int cnt) {
        this.count = cnt;
    }

    public void changePercentage(int percentage) {
        this.percentage = percentage;
    }
}
