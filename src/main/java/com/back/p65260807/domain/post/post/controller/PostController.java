package com.back.p65260807.domain.post.post.controller;

import com.back.p65260807.domain.post.post.entity.Post;
import com.back.p65260807.domain.post.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/posts/write")
    @ResponseBody
    public String write() {

        return """
                <form action="/posts/doWrite" method="post">
                  <input type="text" name="title">
                  <br>
                  <textarea name="content"></textarea>
                  <br>
                  <input type="submit" value="작성">
                </form>
                """;
    }

    @PostMapping("/posts/doWrite")
    @ResponseBody
    public String doWrite(String title, String content) {

        // 동일한 작업이 들어왔을 때 경고를 하거나 처리를 안해주거나
        // 멱등이나 비멱등이냐 따져서 비멱등일 때 중복 처리를 서버에서 해줘야 함

        Post post = postService.write(title, content);
        return "%d번 글이 작성되었습니다.".formatted(post.getId());
    }

}