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

    /*
    @PostConstruct
    public void createData() {
        staticsData.put("광개토관", Arrays.asList(13, 9, 11, 10, 12, 7, 13, 8));
        staticsData.put("영실관 입구", Arrays.asList(10, 8, 8, 6, 8, 7, 8, 8));
        staticsData.put("애지헌", Arrays.asList(10, 11, 15, 16, 13, 16, 11, 13));
        staticsData.put("AI센터", Arrays.asList(7, 11, 10, 8, 9, 6, 9, 4));
        staticsData.put("세종대 정문", Arrays.asList(17, 12, 20, 19, 17, 23, 20, 16));
    }

    public List<Integer> getStaticsData(String name) {
        return staticsData.get(name);
    }*/

    public List<Point> findAll() {
        return em.createQuery("select p from Point p", Point.class).getResultList();
    }

    public Point findOne(Long id) {
        return em.find(Point.class, id);
    }

    public Point findByName(String name) {
        return em.createQuery("select p from Point p where p.place = :name", Point.class)
                .setParameter("name", name).getSingleResult();
    }
}
