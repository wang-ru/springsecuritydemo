package wr.security.support;

import org.springframework.util.ObjectUtils;

/**
 * Created by wsh10801 on 2018/9/24.
 */
public class SimpleResponse {
    private Object content;

    public SimpleResponse(Object content) {
        this.content = content;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
