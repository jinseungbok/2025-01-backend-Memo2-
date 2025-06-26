package green.memoserver;

import green.memoserver.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemoMapper {
    // insert, update, delete = int
    int save(MemoPostReq p);
    List<MemoGetRes> findAll(MemoGetReq req);
    MemoGetOneRes findById(int id);
    int deleteById(int id);
}