package project.finaltoyproject.domain.posts.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class PostsRequestDto {

    @NotEmpty
    private String title;

    @NotEmpty
    private String description;
}
