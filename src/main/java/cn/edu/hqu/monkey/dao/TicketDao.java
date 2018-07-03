package cn.edu.hqu.monkey.dao;

import cn.edu.hqu.monkey.entity.TicketDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketDao extends JpaRepository<TicketDO, Long> {
}
