package green.memo_server;

import green.model.MemoPostReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemoService {
    private final MemoMapper memoMapper;

    public int save(MemoPostReq p) {
        return memoMapper.save(p);
    }

}