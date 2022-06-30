package Group6.capstone.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "info")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Info {

    @Id
    @GeneratedValue
    @Column(name = "info_id")
    private long id;

    // 검출 객체 정보
    private LocalDateTime date;
    private float leftValue;
    private float topValue;
    private float widthValue;
    private float heightValue;

    // 드론 정보
    private float lon;
    private float lat;
    private float droneHeight;
    private float azimuth;

    // 연관관계
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "point_id")
    private Point point;

    //==연관관계 메서드==//
    private void setPoint(Point point) {
        this.point = point;
        point.getInfos().add(this);
    }

    //== 생성 메서드 ==//
    public static Info createInfo(Point point, Temp temp) {
        Info info = new Info();
        info.date = temp.getDate();
        info.leftValue = temp.getLeftValue();
        info.topValue = temp.getTopValue();
        info.widthValue = temp.getWidthValue();
        info.heightValue = temp.getHeightValue();
        info.lon = temp.getLon();
        info.lat = temp.getLat();
        info.droneHeight = temp.getDroneHeight();
        info.azimuth = temp.getAzimuth();
        info.setPoint(point);
        return info;
    }
}
