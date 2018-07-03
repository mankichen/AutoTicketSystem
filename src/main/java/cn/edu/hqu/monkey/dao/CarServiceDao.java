package cn.edu.hqu.monkey.dao;

import cn.edu.hqu.monkey.entity.CarServiceDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarServiceDao extends JpaRepository<CarServiceDO, Long> {

    List<CarServiceDO> findByEndStation(String stationName);

}
