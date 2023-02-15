package hellojpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity//JPA가 roding 될때 관리해야할 객체로 인식되게하는 애너테이션
public class Member {

    @Id//primary key 라고 인식되게하는 애너테이션
    private Long id;
    private String name;

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
