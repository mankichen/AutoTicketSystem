package cn.edu.hqu.monkey.entity;

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
public class SaleRecordDO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date saleDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime; // 发车时间

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;   // 到站时间

    @Size(min=1,max=10,message="{carNum.size}")
    private String carNum;	// 车辆编号

    @Size(min=1,max=50,message="{startStation.size}")
    private String startStation; // 起始地址

    @Size(min=1,max=50,message="{endStation.size}")
    private String endStation;    // 目的地

    private double getMoney;    // 收钱

    private double change;      // 找零

    @Size(min=1,max=50,message="{ticketNum.size}")
    private String ticketNum;      // 车票编号
}
