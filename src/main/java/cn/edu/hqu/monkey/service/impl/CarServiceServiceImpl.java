package cn.edu.hqu.monkey.service.impl;

import cn.edu.hqu.monkey.dao.CarServiceDao;
import cn.edu.hqu.monkey.entity.CarServiceDO;
import cn.edu.hqu.monkey.service.CarServiceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("CarServiceService")
@Slf4j
public class CarServiceServiceImpl implements CarServiceService {
    @Autowired
    private CarServiceDao carServiceDao;

    @Override
    public List<CarServiceDO> listAll() {
        return carServiceDao.findAll();
    }

    @Override
    public CarServiceDO get(Long id) {
        if (null != id) {
            return carServiceDao.findOne(id);
        }
        return null;
    }

    @Override
    @Transactional
    public void save(CarServiceDO record) {
        carServiceDao.save(record);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (null != id && carServiceDao.findOne(id) != null) {
            carServiceDao.delete(id);
        } else {
            log.info("Delete id:" + id + " was not exit.");
        }
    }

    @Override
    @Transactional
    public void update(CarServiceDO record, Long id) {
        CarServiceDO old = carServiceDao.findOne(id);
        if (old != null) {
            record.setId(id);
            carServiceDao.save(record);
        }
    }

    @Override
    public Page<CarServiceDO> findAll(Pageable pageable){
        return carServiceDao.findAll(pageable);
    }

    @Override
    public List<CarServiceDO> findByEndStation(String endStation) {
        return carServiceDao.findByEndStation(endStation);
    }
}
