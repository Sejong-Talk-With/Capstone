package Group6.capstone.service;

import Group6.capstone.domain.Info;
import Group6.capstone.domain.Point;
import Group6.capstone.domain.Temp;
import Group6.capstone.repository.InfoRepository;
import Group6.capstone.repository.PointRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PointService {

    private final PointRepository pointRepository;

    public List<Point> findAll() {
        return pointRepository.findAll();
    }

    public Point findOne(Long id) {
        return pointRepository.findOne(id);
    }

    public Point findByName(String name) {
        return pointRepository.findByName(name);
    }

    public List<Integer> getStaticsData(String name) {

        // 1번째 static (1일전, 2일전, ... , 5일전)
        Point point = pointRepository.findByName(name);
        List<Integer> statics = new ArrayList<>();
        List<Info> infos = point.getInfos();
        for (int i = 5; i >= 1; --i) {
            Integer cnt = 0;
            for (Info info : infos) {
                Period period = Period.between(info.getDate().toLocalDate(), LocalDate.now());
                if (period.getDays() == i) {
                    cnt++;
                }
            }
            statics.add(cnt);
        } // 5일 전까지의 데이터

        // 2번째 static (1시간전, 2시간전, 3시간전)
        for (int i = 1; i <= 3; ++i) {
            Integer cnt = 0;
            for (Info info : infos) {
                Duration duration = Duration.between(info.getDate(), LocalDate.now());
                if (Math.round(duration.getSeconds() / (60 * 60)) == i) {
                    cnt++;
                }
            }
            statics.add(cnt);
        }

        return statics;// [1일전, 2일전, ... , 5일전, 1시간전, 2시간전, 3시간전]
    }

    @Transactional
    public void updatePoint(Long id) {
        Point point = pointRepository.findOne(id);
        point.changeLastCommittedTime(LocalDateTime.now());
    }
}
