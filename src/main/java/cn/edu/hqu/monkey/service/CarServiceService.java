package cn.edu.hqu.monkey.service;


import cn.edu.hqu.monkey.entity.CarServiceDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 *
 */
public interface CarServiceService extends BaseService<CarServiceDO> {
    Page<CarServiceDO> findAll(Pageable pageable);
    List<CarServiceDO> findByEndStation(String endStation);
}
