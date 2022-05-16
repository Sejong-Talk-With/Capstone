package Group6.capstone.repository;

import Group6.capstone.domain.Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface InfoRepository extends JpaRepository<Info, Long> {

    @Query(value = "select * from info limit 20", nativeQuery = true)
    public List<Info> selectAllSql();

}
