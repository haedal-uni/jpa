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

    private int age;

    @Enumerated(EnumType.STRING)
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
