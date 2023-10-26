//package jpashop.domain;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
///*
//Item만 단독으로 테이블을 저장할 일이 있냐 없냐를 판단해야한다.
//여기서는 "없다" 라고 가정함
//→ abstract
// */
//@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // 전략 : 싱글 테이블
//@DiscriminatorColumn
//public abstract class Item extends BaseEntity{
//    @Id @GeneratedValue
//    @Column(name = "ITEM_ID")
//    private Long id;
//    private String name;
//    private int price;
//    private int stockQuantity;
//
//    @ManyToMany(mappedBy = "items") // 양방향
//    private List<Category> categories = new ArrayList<>();
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getPrice() {
//        return price;
//    }
//
//    public void setPrice(int price) {
//        this.price = price;
//    }
//
//    public int getStockQuantity() {
//        return stockQuantity;
//    }
//
//    public void setStockQuantity(int stockQuantity) {
//        this.stockQuantity = stockQuantity;
//    }
//}
