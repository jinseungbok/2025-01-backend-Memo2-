package green.memoserver.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.web.bind.annotation.BindParam;

import java.beans.ConstructorProperties;

//@AllArgsConstructor
@Builder
@Getter
@ToString

public class MemoGetReq {
    private String searchText;
    private Integer page;

//public MemoGetReq(@BindParam("search_text") String searchText, interger page) {
//    this.searchText = searchText;
//    this.page = page;
//  }
    @ConstructorProperties({"search_text", "page"})
    public MemoGetReq(String searchText, Integer page) {
        this.searchText = searchText;
        this.page = page;
    }

}
