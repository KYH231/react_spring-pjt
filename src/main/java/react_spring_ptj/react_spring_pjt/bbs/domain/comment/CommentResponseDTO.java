package react_spring_ptj.react_spring_pjt.bbs.domain.comment;

import lombok.Data;

@Data
public class CommentResponseDTO {
    private Integer id;
    private String content;
    private Integer bbsid;
}