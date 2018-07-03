package cn.edu.hqu.monkey.service.impl;

import cn.edu.hqu.monkey.dao.SaleRecordDao;
import cn.edu.hqu.monkey.entity.SaleRecordDO;
import cn.edu.hqu.monkey.service.SaleRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("saleRecordService")
@Slf4j
public class SaleRecordServiceImpl implements SaleRecordService {

    @Autowired
    SaleRecordDao saleRecordDao;

    @Override
    public List<SaleRecordDO> listAll() {
        return saleRecordDao.findAll();
    }

    @Override
    public SaleRecordDO get(Long id) {
        if (null != id) {
            return saleRecordDao.getOne(id);
        }
        return null;
    }

    @Override
    @Transactional
    public void save(SaleRecordDO record) {
        saleRecordDao.save(record);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (null != id && saleRecordDao.findOne(id) != null) {
            saleRecordDao.delete(id);
        } else {
            log.info("Delete id:" + id + " was not exit.");
        }
    }

    @Override
    public void update(SaleRecordDO record, Long id) {
        SaleRecordDO old = saleRecordDao.findOne(id);
        if (old != null) {
            record.setId(id);
            saleRecordDao.save(record);
        }
    }
}
