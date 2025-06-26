package green.memoserver;

import green.memoserver.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("list")
    public List<MemoGetRes> getMemo(@ModelAttribute MemoGetReq req) {
        log.info("req={}", req);
        return memoService.findAll(req);
    }

//    public String getMemo(@RequestParam(name = "search_text", required = false) String searchText
//                        , @RequestParam(required = false) Integer page) {
        //log.info("search={}, page={}", searchText, page);
//        MemoGetReq req = MemoGetReq.builder()
//                                   .page(page)
//                                   .searchText(searchText)
//                                   .build();
        //memoService.getMomoList(searchText, page);
        //memoService.getMomoList(req);

    @GetMapping("{memoId}")
    public MemoGetOneRes getMemo(@PathVariable int memoId) {
        log.info("memoId={}", memoId);
        return memoService.findById(memoId);
    }

    // Update, put, patch
    @PutMapping("")
    public String putMemo(@RequestBody MemoPutReq req) {
        log.info("req={}", req);
        return "수정 성공";
    }

    // Delete
    @DeleteMapping
    public int deleteMemo(@RequestParam(name = "memo_id") int memoId) {
        log.info("memoId={}", memoId);
        return memoService.deleteById(memoId);
    }
}