package green.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter

public class MemoGetReq {
    private String seatchText;
    private Integer page;
}
