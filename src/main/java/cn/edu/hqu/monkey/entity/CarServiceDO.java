package cn.edu.hqu.monkey.entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CarServiceDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min=1,max=10,message="{carNum.size}")
    private String carNum;	// 车辆编号

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime; // 发车时间

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;   // 到站时间

    @Size(min=1,max=50,message="{startStation.size}")
    private String startStation; // 起始地址

    @Size(min=1,max=50,message="{endStation.size}")
    private String endStation;    // 目的地

    private double price; // 价钱

    private int availableTickets; //剩余票数

}
