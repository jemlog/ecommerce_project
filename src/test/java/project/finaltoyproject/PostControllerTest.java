package project.finaltoyproject;

import com.google.gson.Gson;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.PostMapping;
import project.finaltoyproject.domain.posts.Posts;
import project.finaltoyproject.domain.posts.dto.PostsRequestDto;
import project.finaltoyproject.service.PostsService;
import project.finaltoyproject.web.controller.PostsController;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class) // junit5 부터는 이 프레임워크를 조합해서 mock 객체 넣을 수 있음
public class PostControllerTest {

    // 나는 이제 여기에 mock을 주입해줄 것이다.
    @InjectMocks
    private PostsController postsController;

    // 나는 postsService를 목 객체로 사용할 예정
    @Mock
    private PostsService postsService;

    private MockMvc mockMvc;

    @BeforeEach
    public void init()
    {  // mock 초기화 메서드
        mockMvc = MockMvcBuilders.standaloneSetup(postsController).build();
    }

    @Test
    @DisplayName("게시글 추가 테스트")
    public void addPost() throws Exception
    {
        PostsRequestDto postsRequestDto = postsRequestDto();
        doReturn(new Posts("안녕","하세요")).when(postsService).save(any());

        // when
        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders.post("/posts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new Gson().toJson(postsRequestDto)));

        // then
        MvcResult mvcResult = resultActions.andExpect(status().isOk()).andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();
        Assertions.assertThat(contentAsString).isEqualTo("안녕");

    }

    private PostsRequestDto postsRequestDto()
    {
        return new PostsRequestDto("test","test description");


    }

}
