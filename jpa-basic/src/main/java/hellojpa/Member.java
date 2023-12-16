package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Member {
    @Id
    private Long id;
    @Column(name = "name", nullable = false) // DB 컬럼명은 name 이야 update가 될 때 변경되는 것을 금지시킨다.
    private String username;
    private Integer age;
    @Enumerated(EnumType.ORDINAL)
    private RoleType roleType;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    @Lob // 문자타입은 기본적으로 clob으로 된다.
    private String description;

    @Transient // DB가 아닌 메모리상에서만 사용한다.
    private int temp;

    public Member(){

    }
}