package Group6.capstone.repository;

import Group6.capstone.domain.Info;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class InfoRepository {

    private final EntityManager em;

    public void save(Info info) {
        em.persist(info);
    }
}
