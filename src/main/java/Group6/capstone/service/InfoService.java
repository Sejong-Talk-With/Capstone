package Group6.capstone.service;

import Group6.capstone.domain.Info;
import Group6.capstone.domain.Point;
import Group6.capstone.repository.InfoRepository;
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
    private final PointService pointService;

    public List<Info> getLiveCountAll() {
        return infoRepository.getLiveInfoTemp();

    }
    public int getLiveCountHome(Long id) {
        Point point = pointService.findOne(id);
        double lonTopLeft = point.getLonTopLeft();
        double latTopLeft = point.getLatTopLeft();
        double lonBottRight = point.getLonBottRight();
        double latBottRight = point.getLatBottRight();

        List<Info> infoList = infoRepository.getLiveInfoTemp();

        int cnt = 0;
        for (Info info : infoList) {
            double infoLat = info.getLat();
            double infoLon = info.getLon();
            if ((infoLat >= latTopLeft & infoLat <= latBottRight)
                    & (infoLon >= lonBottRight & infoLon <= lonTopLeft)) {
                cnt++;
            }
        }
        if (cnt != 0) {
            point.changeCount(cnt);
            double perTemp = (double) cnt / point.getAvgCount();
            point.changePercentage((int) Math.round((perTemp) * 100));
        }

        return point.getCount(); //Math.round(infoList.size()/100);
    }

    public int getLiveCount(Long id) {
        Point point = pointService.findOne(id);
        double lonTopLeft = point.getLonTopLeft();
        double latTopLeft = point.getLatTopLeft();
        double lonBottRight = point.getLonBottRight();
        double latBottRight = point.getLatBottRight();

        List<Info> infoList = infoRepository.getLiveInfo();

        int cnt = 0;
        for (Info info : infoList) {
            double infoLat = info.getLat();
            double infoLon = info.getLon();
            if ((infoLat >= latTopLeft & infoLat <= latBottRight)
            & (infoLon >= lonBottRight & infoLon <= lonTopLeft)) {
                cnt++;
            }
        }
        point.changeCount(cnt);
        double perTemp = (double) cnt / point.getAvgCount();
        point.changePercentage((int) Math.round((perTemp) * 100));

        return point.getCount(); //Math.round(infoList.size()/100);
    }
}
