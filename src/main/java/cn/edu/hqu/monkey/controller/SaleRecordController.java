package cn.edu.hqu.monkey.controller;

import cn.edu.hqu.monkey.entity.CarServiceDO;
import cn.edu.hqu.monkey.entity.TicketDO;
import cn.edu.hqu.monkey.service.TicketService;
import cn.edu.hqu.monkey.entity.SaleRecordDO;
import cn.edu.hqu.monkey.service.CarServiceService;
import cn.edu.hqu.monkey.service.SaleRecordService;
import cn.edu.hqu.monkey.vo.BuyInfo;
import cn.edu.hqu.monkey.vo.TicketInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
@RequestMapping("/saleRecord")
@Slf4j
public class SaleRecordController {

    @Autowired
    private SaleRecordService saleRecordService;

    @Autowired
    private CarServiceService carServiceService;

    @Autowired
    private TicketService ticketService;

    @GetMapping("/{id}")
    public void get(@PathVariable("id") Long id) {
        if (log.isDebugEnabled()) {
            log.debug("Get Instance by id:" + id);
        }
        // saleRecordService.get(id);
        log.info("hahha" + saleRecordService.get(id).toString());
    }

    @PostMapping("/buy")
    public String buy(@Valid BuyInfo buyInfo,Errors erros,Model model){
        log.info(""+buyInfo.getId());
        CarServiceDO carServiceDO = carServiceService.get(buyInfo.getId());
        if (null == carServiceDO){
            log.info("无法找到");
            // model.addAttribute("status", "not found ticket");
            return "error/error";
        }

        log.info(carServiceDO.toString() );
        if (carServiceDO.getPrice() > buyInfo.getMoney() || carServiceDO.getAvailableTickets() == 0){
            log.info("money err");
            // model.addAttribute("status", "too low");
            return "error/error";
        }

        Calendar calendar = Calendar.getInstance();
        Date time = calendar.getTime();
        SimpleDateFormat saveFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateFormat = saveFormat.format(time);

        /* 更新剩余票数 */
        carServiceDO.setAvailableTickets(carServiceDO.getAvailableTickets()-1);
        carServiceService.update(carServiceDO, buyInfo.getId());

        TicketDO ticketDO = new TicketDO();
        ticketDO.setCarNum(carServiceDO.getCarNum());
        ticketDO.setStartStation(carServiceDO.getStartStation());
        ticketDO.setEndStation(carServiceDO.getEndStation());
        ticketDO.setStartTime(carServiceDO.getStartTime());
        ticketDO.setEndTime(carServiceDO.getEndTime());
        ticketDO.setTicketNum("T"+dateFormat);
        ticketDO.setTicketStatus("A"); // 可使用
        ticketService.save(ticketDO);

        /* 销售记录 */
        SaleRecordDO saleRecordDO = new SaleRecordDO();
        saleRecordDO.setTicketNum(ticketDO.getTicketNum());
        saleRecordDO.setCarNum(carServiceDO.getCarNum());
        saleRecordDO.setStartStation(carServiceDO.getStartStation());
        saleRecordDO.setEndStation(carServiceDO.getEndStation());
        saleRecordDO.setStartTime(carServiceDO.getStartTime());
        saleRecordDO.setEndTime(carServiceDO.getEndTime());
        saleRecordDO.setGetMoney(carServiceDO.getPrice());
        saleRecordDO.setChange(buyInfo.getMoney() - carServiceDO.getPrice());
        saleRecordDO.setSaleDate(time);
        // saleRecordDO.setSaleStation(carServiceDO.getStartStation());
        saleRecordService.save(saleRecordDO);



        TicketInfo ticketInfo  = new TicketInfo(ticketDO, saleRecordDO.getChange());
        model.addAttribute(ticketInfo);

        /* 记录 */
        log.info(buyInfo.toString());
        return "/ticket/ticket_info";
    }

    @GetMapping("/pay={id}")
    public String purchase(@PathVariable("id") Long id, Model model){
        CarServiceDO carServiceDO;
        BuyInfo buyInfo = new BuyInfo();
        /* 判断是否存在该ID */
        if (null != id && null != (carServiceDO = carServiceService.get(id))){
            /* normal */
            buyInfo.setId(id);
            model.addAttribute(carServiceDO);
            return "saleRecord/pay";
        }

        /* abnormal */
        return "error/error";
    }

    @GetMapping("/listAll")
    public void listAll() {
        saleRecordService.listAll();
    }

    @PostMapping("/add")
    public void add(SaleRecordDO record) {
        saleRecordService.save(record);
    }

    // @PostMapping("/{id}")
    public void update(SaleRecordDO record,@PathVariable("id") Long id) {
        saleRecordService.update(record, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        saleRecordService.delete(id);
    }

}
