package project.finaltoyproject.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import project.finaltoyproject.domain.authority.Authority;
import project.finaltoyproject.domain.order.Order;
import project.finaltoyproject.domain.posts.Posts;
import project.finaltoyproject.domain.user.dto.UserRequestDto;
import project.finaltoyproject.util.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// TODO: 엔티티의 필드에 default 값 넣는 방법 알아보기
// TODO: @Builder 사용시 enum 있으면 생성안됨
// TODO: Builder pattern 자세히 알아보기
// TODO: Delivery와 연관관계 설정
// TODO: PointPolicy 만들기
// TODO: Point와 연관관계 설정
// TODO: 등급에 따른 DiscountPolicy 연동
// TODO: Post와 연관관계 만들기

@Entity
@Table(name = "user")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long Id;
    // 실제 이름
    private String username;

    private String nickname;

    // 로그인용 email
    private String email;

    // 로그인용 password
    private String password;

    @Enumerated(EnumType.STRING)
    private Grade grade;

    @JsonIgnore
    @Column(name = "activated")
    private boolean activated;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_authority",
            joinColumns = {@JoinColumn(name = "users_id", referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "authoritys_name", referencedColumnName = "authority_name")})
    private Set<Authority> authorities = new HashSet<>();





    @OneToMany(mappedBy = "user")
    private List<Posts> postsList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Order> orderList = new ArrayList<>();

    private int totalOrderPriceForCheckingGrade;

    public User(UserRequestDto userRequestDto)
    {
        this.username = userRequestDto.getUsername();
        this.nickname = userRequestDto.getNickname();
        this.email = userRequestDto.getEmail();
        this.password = userRequestDto.getPassword();
        this.grade = Grade.BRONZE; // 처음 가입한 회원은 무조건 BRONZE 등급부터 시작
        this.totalOrderPriceForCheckingGrade = 0;
    }

    public void addTotalOrderPriceForGrade(int price)
    {
        this.totalOrderPriceForCheckingGrade += price;
        checkGrade();
    }

    public void minusTotalOrderPriceForGrade(int price)
    {
        this.totalOrderPriceForCheckingGrade -= price;
        checkGrade();
    }

    public void checkGrade()
    {
        if (totalOrderPriceForCheckingGrade < 300000)
        {
            grade = Grade.BRONZE;
        }
        else if(totalOrderPriceForCheckingGrade >= 300000 && totalOrderPriceForCheckingGrade < 600000)
        {
            grade = Grade.SILVER;
        }
        else if(totalOrderPriceForCheckingGrade >= 600000 && totalOrderPriceForCheckingGrade < 1000000)
        {
            grade = Grade.GOLD;
        }
        else
        {
            grade = Grade.VIP;
        }


    }

    // 테스트용
    public User(Grade grade)
    {
        this.grade = grade;
    }





}
