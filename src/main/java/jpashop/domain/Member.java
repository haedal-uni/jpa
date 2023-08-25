package jpashop.domain;

import javax.persistence.*;

@Entity
public class Member {
    /*
    * getter, setter를 꼭 다 만들 필요는 없지만 getter는 가급적 만드는 것이 좋고 setter는 고민할 필요가 있다.
    * setter를 막 만들면 아무데서나 set할 수 있어서 코드 추적하기에 좋지 않다.(유지 보수성이 떨어질 수 있다.)
    * 가급적이면 생성자에서 값을 다 세팅하고 setter의 사용을 최소화 하는게 유지보수가 좋다.
    * */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MEMBER_ID")
    private Long id;
    private String name;
    private String city;
    private String street;
    private String zipcode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}