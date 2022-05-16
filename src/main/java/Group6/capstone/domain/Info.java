package Group6.capstone.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="info")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Info {

    @Id
    @GeneratedValue
    @Column(name = "info_id")
    private long id;

    private LocalDateTime date;
    private float leftValue;
    private float topValue;
    private float widthValue;
    private float heightValue;
    private float lon;
    private float lat;
    private float droneHeight;
    private float azimuth;

    public Info createInfo(LocalDateTime date, float leftValue, float topValue, float widthValue, float heightValue, float lon, float lat, float droneHeight, float azimuth) {
        Info info = new Info();
        this.date = date;
        this.leftValue = leftValue;
        this.topValue = topValue;
        this.widthValue = widthValue;
        this.heightValue = heightValue;
        this.lon = lon;
        this.lat = lat;
        this.droneHeight = droneHeight;
        this.azimuth = azimuth;
        return info;
    }

}
