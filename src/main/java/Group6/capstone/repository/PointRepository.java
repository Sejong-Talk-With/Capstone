package Group6.capstone.repository;

import Group6.capstone.domain.Point;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PointRepository {

    private final EntityManager em;

    public List<Point> findAll() {
        return em.createQuery("select p from Point p", Point.class).getResultList();
    }

    public Point findOne(Long id) {
        return em.find(Point.class, id);
    }
}
