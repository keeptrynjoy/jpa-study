package javabook.javashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member extends BaseEntity {

    @Id@GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    private String name;
    @Embedded
    private Address address;

    public Address getAddress() {
        return address;
    }

    // 비즈니스에서는 나쁜 코드 - order 가 필요할 경우 order 에서 접근하는게 좋음
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

}
