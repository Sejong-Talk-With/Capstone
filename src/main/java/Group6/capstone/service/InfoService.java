package Group6.capstone.service;

import Group6.capstone.domain.Info;
import Group6.capstone.domain.Point;
import Group6.capstone.domain.Temp;
import Group6.capstone.repository.InfoRepository;
import Group6.capstone.repository.TempRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class InfoService {

    private final InfoRepository infoRepository;
    private final TempRepository tempRepository;

    public void createInfo(Point point) {
        List<Temp> lastData = tempRepository.getLastData(point.getLastCommittedTime());
        double lonTopLeft = point.getLonTopLeft();
        double latTopLeft = point.getLatTopLeft();
        double lonBottRight = point.getLonBottRight();
        double latBottRight = point.getLatBottRight();

        int cnt = 0;
        if (lastData.size() != 0) {

            for (Temp temp : lastData) {
                double tempLat = temp.getLat();
                double tempLon = temp.getLon();
                if ((tempLat >= latTopLeft & tempLat <= latBottRight)
                        & (tempLon >= lonBottRight & tempLon <= lonTopLeft)) {
                    Info info = Info.createInfo(point, temp);
                    infoRepository.save(info);
                }
            }
            point.changeCount(cnt);
            double perTemp = (double) cnt / point.getAvgCount();
            point.changePercentage((int) Math.round((perTemp) * 100));
        }
    }
}
