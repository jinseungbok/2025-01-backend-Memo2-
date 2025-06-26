package green.memo_server;

import green.model.MemopostReq;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MemoController {
    private final MemoService memoService;

    // C
    @PostMapping("api/memo")
//  public String postMemo(@#ModelAttribute MemoPostReq req) { // FormData 넘어오는 걸로 판단함
    public String postMemo(@RequestBody MemopostReq req) { // JSON으로 넘어옴
//      System.out.println("postMemo: " + req);
        log.info("req={}", req);
        return "저장 성공";
    }
    // R GET 방식 GETTER/SETTER
    @GetMapping("api/memo")
    public String getMemo(@RequestParam String search) {
//  public String getMemo(@RequestParam(name="search_text", required = false) String searchText) {
//  로 값을 반드시 넣고 싶을 때 우회 가능. 가져올 게 없으면 null 처리 가져올 게 있으면 문자열 넘어옴
//  default = required key value 있어야 함
        log.info("search={}", search);
        return "memoList";
    }
    @GetMapping("api/memo/{id}")
    public String getOneMemo(@PathVariable int id ) {
        log.info("id={}", id);
        return "Memo one";
    }


//  주소값을 웬만하면 통일하려 하는게 Restful의 특징. 이 때 PathVariable 고민

    // U

    // D
}