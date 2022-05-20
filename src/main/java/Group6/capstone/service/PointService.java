package Group6.capstone.service;

import Group6.capstone.domain.Point;
import Group6.capstone.repository.PointRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
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
        return pointRepository.getStaticsData(name);
    }
}
