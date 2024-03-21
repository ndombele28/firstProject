package miniProject.board.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import miniProject.board.entity.Admin;
import miniProject.board.entity.Article;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AdminDto {
    private long id;

    @Size(min = 4, max = 20)
    @NotEmpty(message = "입력해주세요")
    private String name;

    @Size(min = 4, max = 20)
    @NotEmpty(message = "입력해주세요")
    private String password;

}
