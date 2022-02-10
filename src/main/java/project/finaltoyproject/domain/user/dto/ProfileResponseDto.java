package project.finaltoyproject.domain.user.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.finaltoyproject.domain.order.dto.OrderResponseDto;
import project.finaltoyproject.domain.posts.dto.PostsResponseDto;
import project.finaltoyproject.domain.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProfileResponseDto {

    private String username;

    private String nickname;

    private String email;

    private List<OrderResponseDto> myOrders = new ArrayList<>();

    private List<PostsResponseDto> myPosts = new ArrayList<>();

    public ProfileResponseDto(User user)
    {
        this.username = user.getUsername();
        this.nickname = user.getNickname();
        this.email = user.getEmail();
        this.myPosts = user.getPostsList()
                .stream().map(p -> new PostsResponseDto(
                        p.getTitle(),
                        p.getDescription(),
                        p.getUser().getId()))
                .collect(Collectors.toList());
        this.myOrders = user.getOrderList()
                .stream().map(o->new OrderResponseDto(
                        o.getOrderState(),
                        o.getTotalOrderPrice(),
                        o.getUser().getUsername(),
                        o.getOrderItems().stream().findFirst().orElse(null).getItem().getItemName()
                )).collect(Collectors.toList());
    }
}
