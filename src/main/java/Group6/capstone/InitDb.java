/*
package Group6.capstone;

import Group6.capstone.domain.Point;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct // 스프링 빈에 등록되면 그 후 바로 실행되는 구문 (인스턴스 할당 없이 실행되는 생성자)
    public void init() {
        initService.dbInit1();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {
        private final EntityManager em;
        public void dbInit1() {
            Point point1 = Point.createPoint("광개토관", 210, 52, 37.550269, 127.073362,"/img/광개토관.jpg");
            point1.setRange(37.550776, 127.072801, 37.549831, 127.074230);
            Point point2 = Point.createPoint("영실관 입구", 150, 42, 37.552101, 127.073609,"/img/영실관.jpg");
            point2.setRange(37.552498, 127.072948, 37.551548, 127.073985);
            Point point3 = Point.createPoint("애지헌", 130, 84, 37.551001, 127.074609,"/img/애지헌.jpg");
            point3.setRange(37.551082, 127.074665,37.550196, 127.075771);
            Point point4 = Point.createPoint("AI센터", 10, 15, 37.550257, 127.075006,"/img/AI센터.jpg");
            point4.setRange(37.551082, 127.074665,37.550196, 127.075771);
            Point point5 = Point.createPoint("정문", 140, 84, 37.548805, 127.074895,"/img/정문.jpg");
            point5.setRange(37.549902, 127.074376, 37.548869, 127.075486);

            List<Point> pointList = new ArrayList<>(Arrays.asList(point1,point2,point3,point4, point5));
            for (Point point : pointList) {
                em.persist(point);
            }
        }
    }
}*/
