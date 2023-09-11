//package jpashop.domain;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//public class Category {
//    @Id @GeneratedValue
//    private Long id;
//
//    private String name;
//
//    // parent : 상위 카테고리
//    @ManyToOne
//    @JoinColumn(name = "PARENT_ID")
//    private Category parent;
//
//    // 양방향 자식 카테고리
//    @OneToMany(mappedBy = "parent")
//    private List<Category> child = new ArrayList<>();
//
//    @ManyToMany // 배송, 카테고리 추가 - ERD 그림 보면 됨
//    @JoinTable(name = "CATEGORY_ITEM", // 중간테이블을 만드는 코드
//    joinColumns = @JoinColumn(name = "CATEGORY_ID"),
//    inverseJoinColumns = @JoinColumn(name = "ITEM_ID"))
//    private List<Item> items = new ArrayList<>();
//    // 내가 JOIN 하는 것은(joinColumns) category_id 이고,
//    // 반대 쪽이 join 해야하는 것은(inverseJoinColumns) item_id 이다.
//}
