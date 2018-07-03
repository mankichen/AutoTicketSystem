package cn.edu.hqu.monkey.service.impl;

import cn.edu.hqu.monkey.dao.TicketDao;
import cn.edu.hqu.monkey.entity.TicketDO;
import cn.edu.hqu.monkey.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("ticketService")
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketDao ticketDao;

    @Override
    public List<TicketDO> listAll() {
        return ticketDao.findAll();
    }

    @Override
    public TicketDO get(Long id) {
        return ticketDao.findOne(id);
    }

    @Override
    @Transactional
    public void save(TicketDO record) {
        ticketDao.save(record);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        ticketDao.delete(id);
    }

    @Override
    @Transactional
    public void update(TicketDO record, Long id) {
        ticketDao.save(record);
    }
}
