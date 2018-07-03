package cn.edu.hqu.monkey.service;

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
public class CarServiceServiceTest {
    @Autowired
    private CarServiceService carServiceService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void listAll() {
        List<CarServiceDO> records = carServiceService.listAll();
        System.out.println("Get Size:" + records.size());
    }

    @Test
    public void get() {
    }

    @Test
    public void save() {
        CarServiceDO record = new CarServiceDO();
        record.setCarNum("B542");
        record.setAvailableTickets(50);
        record.setStartStation("beijing");
        record.setEndStation("fujian");
        // record.setStartTime(new Date());
        record.setPrice(5.5);

        carServiceService.save(record);


    }

    @Test
    public void delete() {
    }

    @Test
    public void update() {
    }
}