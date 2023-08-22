package hellojpa;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Member {
    @Id
    private Long id;

    @Column(name = "name", nullable = false, columnDefinition = " varchar(100) default ‘EMPTY'") // 해당 column은 변경 X
    private String username;

    private BigDecimal age;

    @Enumerated(EnumType.STRING) // db에는 enum 타입이 없으므로
    private RoleType roleType;

    /*
    TemporalType에는
    DATE(날짜), TIME(시간), TIMESTAMP(날짜+시간)이 있다.
     */
    @Temporal(TemporalType.TIMESTAMP) // 날짜 타입
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob
    private String description;
    // varchar를 넘어서는 큰 contents를 넣고 싶으면 @Lob을 쓰면 된다.

    public Member(){ // 기본 생성자
    }
}
