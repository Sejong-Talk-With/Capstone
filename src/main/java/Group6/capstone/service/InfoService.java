package Group6.capstone.service;

import Group6.capstone.domain.Info;
import Group6.capstone.domain.Point;
import Group6.capstone.repository.InfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class InfoService {

    private final InfoRepository infoRepository;
    private final PointService pointService;

    public int getLiveCount() { //Long id
//        Point point = pointService.findOne(id);
//        double lonTopLeft = point.getLonTopLeft();
//        double latTopLeft = point.getLatTopLeft();
//        double lonBottRight = point.getLonBottRight();
//        double latBottRight = point.getLatBottRight();

        List<Info> infoList = infoRepository.getLiveInfo();
        return infoList.size(); //Math.round(infoList.size()/100);
    }
}
