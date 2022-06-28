package Group6.capstone.service;

import Group6.capstone.domain.Point;
import Group6.capstone.domain.Temp;
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
public class TempService {

    private final TempRepository tempRepository;
    private final PointService pointService;

    public List<Temp> getLiveCountAll() {
        return tempRepository.getLiveData();
    }

    public int getLiveCountHome(Long id) {
        Point point = pointService.findOne(id);
        double lonTopLeft = point.getLonTopLeft();
        double latTopLeft = point.getLatTopLeft();
        double lonBottRight = point.getLonBottRight();
        double latBottRight = point.getLatBottRight();

        List<Temp> tempList = tempRepository.getLiveData();

        int cnt = 0;
        if (tempList.size() == 0) {
            return point.getCount();
        }
        if (point.getPlace().equals("애지헌")) {
            double tempAzi = tempList.get(0).getAzimuth();
            if (tempAzi < 225 || tempAzi > 315) {
                return point.getCount();
            }
        }

        if (point.getPlace().equals("AI센터")) {
            double tempAzi = tempList.get(0).getAzimuth();
            if (45 < tempAzi && tempAzi < 315) {
                return point.getCount();
            }
        }

        for (Temp temp : tempList) {
            double tempLat = temp.getLat();
            double tempLon = temp.getLon();
            if ((tempLat >= latTopLeft & tempLat <= latBottRight)
                    & (tempLon >= lonBottRight & tempLon <= lonTopLeft)) {
                cnt++;
            }

        }
        if (cnt != 0) {
            point.changeCount(cnt);
            double perTemp = (double) cnt / point.getAvgCount();
            point.changePercentage((int) Math.round((perTemp) * 100));
        }

        return point.getCount(); //Math.round(tempList.size()/100);
    }

    public int getLiveCount(Long id) {
        Point point = pointService.findOne(id);
        double lonTopLeft = point.getLonTopLeft();
        double latTopLeft = point.getLatTopLeft();
        double lonBottRight = point.getLonBottRight();
        double latBottRight = point.getLatBottRight();

        List<Temp> tempList = tempRepository.getLiveData();

        int cnt = 0;
        if (tempList.size() == 0) {
            return point.getCount();
        }

        for (Temp temp : tempList) {
            double tempLat = temp.getLat();
            double tempLon = temp.getLon();
            if ((tempLat >= latTopLeft & tempLat <= latBottRight)
                    & (tempLon >= lonBottRight & tempLon <= lonTopLeft)) {
                cnt++;
            }
        }
        point.changeCount(cnt);
        double perTemp = (double) cnt / point.getAvgCount();
        point.changePercentage((int) Math.round((perTemp) * 100));

        return point.getCount(); //Math.round(tempList.size()/100);
    }
}
