package cn.edu.hqu.monkey.dao;

import cn.edu.hqu.monkey.entity.SaleRecordDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRecordDao extends JpaRepository<SaleRecordDO, Long> {
}
