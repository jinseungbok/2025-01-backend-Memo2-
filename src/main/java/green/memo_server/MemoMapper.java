package green.memo_server;

import green.model.MemoGetOneRes;
import green.model.MemoGetRes;
import green.model.MemoPostReq;
import green.model.MemoPutReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemoMapper {
    int save(MemoPostReq p);
}