package com.back.p65260807.domain.post.post.controller;

import com.back.p65260807.domain.post.post.entity.Post;
import com.back.p65260807.domain.post.post.service.PostService;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@Validated
public class PostController {

    private final PostService postService;

    @GetMapping("/posts/write")
    @ResponseBody
    public String write() {

        return getWriteFormHtml("", "", "", "title");
    }

    @PostMapping("/posts/doWrite")
    @ResponseBody
    public String doWrite(
            @NotBlank @Size(min=2, max=10) String title,
            @NotBlank @Size(min=2, max=10) String content
    ) {

        Post post = postService.write(title, content);
        return "%d번 글이 작성되었습니다.".formatted(post.getId());
    }

    private String getWriteFormHtml(String errorMessage, String title, String content, String errorField) {
        return """
                <div style="color:red">%s</div>
                
                <form method="POST" action="/posts/doWrite">
                  <input type="text" name="title" value="%s" autoFocus>
                  <br>
                  <textarea name="content">%s</textarea>
                  <input type="submit" value="작성">
                </form>
                
                <script>
                    const errorFieldName = "%s";

                    if(errorFieldName.length > 0) {
                        const form = document.querySelector("form");
                        form[errorFieldName].focus();
                    }
                </script>
        """.formatted(errorMessage, title, content, errorField);
}

}