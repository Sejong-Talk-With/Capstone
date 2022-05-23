package Group6.capstone.repository;

import Group6.capstone.domain.Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.event.WindowFocusListener;
import java.time.LocalDateTime;
import java.util.List;

public interface InfoRepository extends JpaRepository<Info, Long> {

    @Query(value = "select * from info limit 20", nativeQuery = true)
    public List<Info> selectAllSql();

    @Query(value = "SELECT * " +
            "FROM info i " +
            "where i.date >= DATE_SUB(CONVERT_TZ(NOW(),'SYSTEM','Asia/Seoul'), INTERVAL 10 SECOND);", nativeQuery = true)
    public List<Info> getLiveInfo();

    @Query(value = "select * from info " +
            "where info.date > '2022-05-23 15:33:00' and info.date <= '2022-05-23 15:34:00'", nativeQuery = true)
    public List<Info> getLiveInfoTemp();

}
