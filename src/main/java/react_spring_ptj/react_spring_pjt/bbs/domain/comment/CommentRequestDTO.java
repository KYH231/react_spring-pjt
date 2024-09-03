package react_spring_ptj.react_spring_pjt.bbs.domain.comment;

import lombok.Data;

@Data
public class CommentRequestDTO {
    
    private String content;
    private Integer bbsid;
}
