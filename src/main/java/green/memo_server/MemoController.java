package green.memo_server;

import green.model.MemoGetReq;
import green.model.MemoPostReq;
import green.model.MemoPutReq;
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
    public String postMemo(@RequestBody MemoPostReq req) { // JSON으로 넘어옴
//      System.out.println("postMemo: " + req);
        log.info("req={}", req);
        int result = memoService.save(req);
        return result == 1 ? "저장 성공" : "저장 실패";
    }
    //Read
    @GetMapping
    public String getMemo(@ModelAttribute MemoGetReq req) {
//    public String getMemo(@RequestParam(name = "search_text", required = false) String searchText
//                        , @RequestParam(required = false) Integer page) {
        //log.info("search={}, page={}", searchText, page);
//        MemoGetReq req = MemoGetReq.builder()
//                                   .page(page)
//                                   .searchText(searchText)
//                                   .build();
        //memoService.getMomoList(searchText, page);
        //memoService.getMomoList(req);
        log.info("req={}", req);
        return "메모 리스트";
    }

    @GetMapping("{memoId}")
    public String getOneMemo(@PathVariable int memoId) {
        log.info("memoId={}", memoId);
        return "Memo one";
    }

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