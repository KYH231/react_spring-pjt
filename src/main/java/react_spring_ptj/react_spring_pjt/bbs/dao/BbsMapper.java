package react_spring_ptj.react_spring_pjt.bbs.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import react_spring_ptj.react_spring_pjt.bbs.domain.BbsRequstDTO;
import react_spring_ptj.react_spring_pjt.bbs.domain.BbsResponseDTO;
import react_spring_ptj.react_spring_pjt.bbs.domain.comment.CommentRequestDTO;
import react_spring_ptj.react_spring_pjt.bbs.domain.comment.CommentResponseDTO;

@Mapper
public interface BbsMapper {

    public List<BbsResponseDTO> findAllRow();

    public void saveRow(BbsRequstDTO params);

    public BbsResponseDTO findRow(Map<String, Integer> map);

    public List<CommentResponseDTO> commentSelectRow(Map<String, Integer> map);

    public void saveCommentRow(CommentRequestDTO params);

}
