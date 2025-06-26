package green.memoserver.model;

import lombok.Getter;
import lombok.Setter;

@Getter
public class MemoGetRes {
    private int id;
    private String title;
    private String content;
    private String createdAt;
}