package green.memo_server;

import green.model.MemoPutReq;
import green.model.MemopostReq;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
// 공동 URL
@RequestMapping("api/memo")

public class MemoController {
    private final MemoService memoService;

    // Create
    @PostMapping("")
//  public String postMemo(@#ModelAttribute MemoPostReq req) { // FormData 넘어오는 걸로 판단함
    public String postMemo(@RequestBody MemopostReq req) { // JSON으로 넘어옴
//      System.out.println("postMemo: " + req);
        log.info("req={}", req);
        return "저장 성공";
    }
    // Read GET 방식 GETTER/SETTER
    @GetMapping("")
    public String getMemo(@RequestParam String search) {
//  public String getMemo(@RequestParam(name="search_text", required = false) String searchText) {
//  로 값을 반드시 넣고 싶을 때 우회 가능. 가져올 게 없으면 null 처리 가져올 게 있으면 문자열 넘어옴
//  default = required key value 있어야 함
        log.info("search={}", search);
        return "memoList";
    }
    @GetMapping("{memoId}")
    public String getOneMemo(@PathVariable int memoid, @PathVariable String memoId) {
        log.info("memoId={}", memoId);
        return "Memo one";
    }
//  주소값을 웬만하면 통일하려 하는게 Restful의 특징. 이 때 PathVariable 고민

    // Update, put, patch
    @PutMapping("")
    public String putMemo(@RequestBody MemoPutReq req) {
        log.info("req={}", req);
        return "수정 성공";
    }

    // Delete
    @DeleteMapping("")
    public String delMemo(@RequestParam(name="memo_id", required = true) int memoId) {
        log.info("memoId={}", memoId);
        return "삭제 완료";
    }
}