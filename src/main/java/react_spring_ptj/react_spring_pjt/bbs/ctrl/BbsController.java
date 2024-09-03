package react_spring_ptj.react_spring_pjt.bbs.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import react_spring_ptj.react_spring_pjt.bbs.domain.BbsRequstDTO;
import react_spring_ptj.react_spring_pjt.bbs.domain.BbsResponseDTO;
import react_spring_ptj.react_spring_pjt.bbs.domain.comment.CommentRequestDTO;
import react_spring_ptj.react_spring_pjt.bbs.domain.comment.CommentResponseDTO;
import react_spring_ptj.react_spring_pjt.bbs.service.BbsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/bbs")
public class BbsController {

    @Autowired
    private BbsService bbsService;

    @GetMapping("/index")
    public ResponseEntity<List<BbsResponseDTO>> landing() {
        System.out.println("client endpoint : /bbs/index" + bbsService);
        List<BbsResponseDTO> list = bbsService.findAll();
        System.out.println("list size" + list.size());
        if(list.size() == 0){
            Map<String, String> map = new HashMap<>();
            map.put("info", "저장딘 데이터가 존재하지 않습니다");
            return new ResponseEntity<>(list, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        
    }

    @PostMapping("/save")
    public ResponseEntity<Void> save(@RequestBody BbsRequstDTO params) {
        
        System.out.println("client endpoint bbs/save " );
        System.out.println(params);
        bbsService.save(params);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<Object> view(@PathVariable(name="id") Integer id) {
        System.out.println("debug >>> bbs controller client path / view");
        System.out.println("debug >>> id " + id);
        Map<String, Integer> map = new HashMap<>();
        map.put("id",id);
        BbsResponseDTO result = bbsService.find(map);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
    @PostMapping("/comments/save")
    public ResponseEntity<Void> commentSave(@RequestBody CommentRequestDTO params) {
        System.out.println("debug >>> bbs controller client path bbs/comment/save");
        System.out.println("debug >>>>>>>> requset dto" + params);
        bbsService.commentSave(params);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/comments/getComment/{id}")
    public ResponseEntity<List<CommentResponseDTO>> commentGet(@PathVariable(name="id") Integer bbsid) {
        System.out.println("debug >>> bbs controller client path bbs/comments/getComment/ ");
        System.out.println("debug >>>>>>>> params " + bbsid);
        Map<String, Integer> map = new HashMap<>();
        map.put("id", bbsid);
        List<CommentResponseDTO> list = bbsService.getComment(map);
        System.out.println("list size" + list.size());
        return new ResponseEntity<List<CommentResponseDTO>>(list, HttpStatus.OK);
    }
    
}
