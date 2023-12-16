package jpabook.jpashop.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ORDERS") // Order 이란 예약어 때문에 ORDERS 라 많이 쓴다
public class Order {

    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long Id;
    @Column(name = "member_ID")
    private Long memberId;
    private LocalDateTime orderDate;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
