package cn.edu.hqu.monkey.vo;

import cn.edu.hqu.monkey.entity.TicketDO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Size;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TicketInfo {

    @Size(min=1,max=10,message="{carNum.size}")
    private String carNum;	// 车辆编号

    private String ticketNum;

    @DateTimeFormat(pattern = "MM-dd HH:mm:ss")
    private Date startTime;

    @DateTimeFormat(pattern = "MM-dd HH:mm:ss")
    private Date endTime;

    @Size(min=1,max=50,message="{startStation.size}")
    private String startStation;

    @Size(min=1,max=50,message="{endStation.size}")
    private String endStation;

    @Size(min=1,max=20,message="{ticketStatus.size}")
    private String charge;

    public TicketInfo(TicketDO ticketDO, double charge){
        this.carNum = ticketDO.getCarNum();
        this.charge = ""+charge;
        this.endStation = ticketDO.getEndStation();
        this.startStation = ticketDO.getStartStation();
        this.startTime = ticketDO.getStartTime();
        this.endTime = ticketDO.getEndTime();
        this.ticketNum = ticketDO.getTicketNum();
    }
}
