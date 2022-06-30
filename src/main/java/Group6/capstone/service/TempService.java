package Group6.capstone.service;

import Group6.capstone.domain.Point;
import Group6.capstone.domain.Temp;
import Group6.capstone.repository.PointRepository;
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
    private final PointRepository pointRepository;

    @Transactional(readOnly = true)
    public List<Temp> getLiveData() {
        return tempRepository.getLiveData();
    }

    public int getLiveCount(Long id) {
        Point point = pointRepository.findOne(id);
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
