package cn.edu.hqu.monkey.controller;

import cn.edu.hqu.monkey.entity.CarServiceDO;
import cn.edu.hqu.monkey.service.CarServiceService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/carService")
@Slf4j
public class CarServiceController {

    @Autowired
    private CarServiceService carServiceService;

    @RequestMapping(value="/list")
    public String list(Model model) throws Exception{
        List<CarServiceDO> carServiceDOList =  carServiceService.listAll();
        model.addAttribute("carServiceList", carServiceDOList);

        return "carService/index";
    }

    @GetMapping("/place={place}")
    public String findByPlace(@PathVariable("place") String place, Model model){
        log.info(place);

        if (null != place && 0 != place.length()) {
            List<CarServiceDO> carServiceDOList = carServiceService.findByEndStation(place);
            model.addAttribute("carServiceList", carServiceDOList);
        }else{
            List<CarServiceDO> carServiceDOList =  carServiceService.listAll();
            model.addAttribute("carServiceList", carServiceDOList);
        }

        return "carService/index";
    }

    @GetMapping("/{id}")
    public void get(@PathVariable("id") Long id) {
        if (log.isDebugEnabled()) {
            log.debug("Get Instance by id:" + id);
        }
        // carServiceService.get(id);

        log.info(carServiceService.get(id).toString());
    }

    @GetMapping("/listAll")
    public void listAll() {
        carServiceService.listAll();
    }

    @PostMapping("/add")
    public void add(CarServiceDO record) {
        carServiceService.save(record);
    }

    @PostMapping("/{id}")
    public void update(CarServiceDO record,@PathVariable("id") Long id) {
        carServiceService.update(record, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        carServiceService.delete(id);
    }
}
