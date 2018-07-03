package cn.edu.hqu.monkey.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class TicketDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min=1,max=10,message="{carNum.size}")
    private String carNum;	// 车辆编号

    private String ticketNum;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    @Size(min=1,max=50,message="{startStation.size}")
    private String startStation;

    @Size(min=1,max=50,message="{endStation.size}")
    private String endStation;

    @Size(min=1,max=20,message="{ticketStatus.size}")
    private String ticketStatus;
}
