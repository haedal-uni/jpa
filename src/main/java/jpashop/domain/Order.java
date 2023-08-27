//package jpashop.domain;
//
//import javax.persistence.*;
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "ORDERS") // DB마다 다르긴 한데 ORDER가 예약어로 걸려있다.(order by) 그래서 orders로 많이 쓴다.
//public class Order {
//    @Id @GeneratedValue
//    @Column(name = "ORDER_ID")
//    private Long id;
//
//    @Column(name = "MEMBER_ID")
//    private Long memberId;
//
//    //private Member member;
//
//    private LocalDateTime orderDate;
//
//    @Enumerated(EnumType.STRING)
//    private OrderStatus status;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Long getMemberId() {
//        return memberId;
//    }
//
//    public void setMemberId(Long memberId) {
//        this.memberId = memberId;
//    }
//
//    public LocalDateTime getOrderDate() {
//        return orderDate;
//    }
//
//    public void setOrderDate(LocalDateTime orderDate) {
//        this.orderDate = orderDate;
//    }
//
//    public OrderStatus getStatus() {
//        return status;
//    }
//
//    public void setStatus(OrderStatus status) {
//        this.status = status;
//    }
//}
