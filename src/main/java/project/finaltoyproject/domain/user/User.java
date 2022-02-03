package project.finaltoyproject.domain.user;

import lombok.*;
import project.finaltoyproject.domain.user.dto.UserRequestDto;
import project.finaltoyproject.util.BaseEntity;

import javax.persistence.*;

// TODO: 엔티티의 필드에 default 값 넣는 방법 알아보기
// TODO: @Builder 사용시 enum 있으면 생성안됨
// TODO: Builder pattern 자세히 알아보기
// TODO: Delivery와 연관관계 설정
// TODO: PointPolicy 만들기
// TODO: Point와 연관관계 설정
// TODO: 등급에 따른 DiscountPolicy 연동
// TODO: Post와 연관관계 만들기

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 실제 이름
    @Column(nullable = false)
    private String username;

    @Column(length = 10)
    private String nickname;

    // 로그인용 email
    @Column(nullable = false)
    private String email;

    // 로그인용 password
    @Column(length = 255, nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Grade grade;

    public User(UserRequestDto userRequestDto)
    {
        this.username = userRequestDto.getUsername();
        this.nickname = userRequestDto.getNickname();
        this.email = userRequestDto.getEmail();
        this.password = userRequestDto.getPassword();
        this.grade = Grade.BRONZE; // 처음 가입한 회원은 무조건 BRONZE 등급부터 시작
    }

}
