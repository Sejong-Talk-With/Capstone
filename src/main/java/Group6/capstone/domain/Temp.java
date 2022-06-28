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
public class Temp {

    @Id
    @GeneratedValue
    @Column(name = "data_id")
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

}
