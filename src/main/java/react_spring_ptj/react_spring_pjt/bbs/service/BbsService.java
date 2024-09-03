package react_spring_ptj.react_spring_pjt.bbs.service;



import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import react_spring_ptj.react_spring_pjt.bbs.dao.BbsMapper;
import react_spring_ptj.react_spring_pjt.bbs.domain.BbsRequstDTO;
import react_spring_ptj.react_spring_pjt.bbs.domain.BbsResponseDTO;
import react_spring_ptj.react_spring_pjt.bbs.domain.comment.CommentRequestDTO;
import react_spring_ptj.react_spring_pjt.bbs.domain.comment.CommentResponseDTO;

@Service

public class BbsService {
    
    @Autowired
    private BbsMapper bbsMapper;

    public List<BbsResponseDTO> findAll() {
        System.out.println("debug >>> service findAll" + bbsMapper);
        return bbsMapper.findAllRow();
    }

    public void save(BbsRequstDTO params) {
        System.out.println("debug >>> service save()" + bbsMapper);
        bbsMapper.saveRow(params);
    }

    public BbsResponseDTO find(Map<String, Integer> map) {

        System.out.println("debug >>> bbs find " + bbsMapper);

        BbsResponseDTO result = bbsMapper.findRow(map);
        List<CommentResponseDTO> list = bbsMapper.commentSelectRow(map);
        result.setComments(list);
        return result;
    }

    public void commentSave(CommentRequestDTO params) {
        System.out.println("debug >>> commentSave()");
        bbsMapper.saveCommentRow(params);
    }

    public List<CommentResponseDTO> getComment(Map<String, Integer> map) {
        System.out.println("debug >>> service getComment" + bbsMapper);
        return bbsMapper.commentSelectRow(map);
    }

}
