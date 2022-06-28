package Group6.capstone.repository;

import Group6.capstone.domain.Temp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface TempRepository extends JpaRepository<Temp, Long> {

    @Query(value = "select * from temp", nativeQuery = true)
    public List<Temp> selectAllSql();

    @Query(value = "SELECT * " +
            "FROM temp t " +
            "where t.date >= DATE_SUB(CONVERT_TZ(NOW(),'SYSTEM','Asia/Seoul'), INTERVAL 10 SECOND);", nativeQuery = true)
    public List<Temp> getLiveData();


    @Query(value = "SELECT * " +
            "FROM temp t " +
            "where t.date >= last_commit;", nativeQuery = true)
    public List<Temp> getLastData(@Param(value = "last_commit") LocalDateTime lastCommittedTime);


}
