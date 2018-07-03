package cn.edu.hqu.monkey.controller;

import cn.edu.hqu.monkey.entity.TicketDO;
import cn.edu.hqu.monkey.service.TicketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/ticket")
@Slf4j
public class TicketController {
    @Autowired
    private TicketService ticketService;

    // @GetMapping("/{id}")
    /*public void get(@PathVariable("id") Long id) {
        if (log.isDebugEnabled()) {
            log.debug("Get User by id:" + id);
        }
        ticketService.get(id);
    }*/

    // @GetMapping("/ticketInfo{id}")
    public String ticketInfo(@PathVariable Long id, Model model){
        TicketDO ticketDO = ticketService.get(id);
        List<TicketDO> list = new ArrayList<>();
        list.add(ticketDO);
        log.info("get id="+id);
        log.info(ticketDO.toString());
        model.addAttribute(ticketDO);
        return "ticket/ticket_info";
    }


    @GetMapping("/listAll")
    public void listAll() {
        ticketService.listAll();
    }

    @PostMapping("/add")
    public void add(TicketDO record) {
        ticketService.save(record);
    }

    /*
    @PostMapping("/{id}")
    public void update(TicketDO record, @PathVariable("id") Long id) {
        ticketService.update(record, id);
    }*/

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        ticketService.delete(id);
    }
}
