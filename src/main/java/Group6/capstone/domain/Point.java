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

    // 위치정보 (위도, 경도)
    private double latitude;
    private double longitude;

    // 생성 메서드
    public static Point createPoint(String place, int percentage, int count, double latitude, double longitude) {
        Point point = new Point();
        point.place = place;
        point.percentage = percentage;
        point.count = count;
        point.latitude = latitude;
        point.longitude = longitude;
        return point;
    }

}
