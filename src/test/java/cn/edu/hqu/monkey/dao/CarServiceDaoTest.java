package cn.edu.hqu.monkey.dao;

import cn.edu.hqu.monkey.entity.CarServiceDO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarServiceDaoTest {
    @Autowired
    private CarServiceDao carServiceDao;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testFindByEndStation() {
        final String stationName = "fujian";
        List<CarServiceDO> records = carServiceDao.findByEndStation(stationName);
    }
}