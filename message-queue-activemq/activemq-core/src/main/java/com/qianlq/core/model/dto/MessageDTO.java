package com.qianlq.core.model.dto;

import java.io.Serializable;

/**
 * @author qianliqing
 * @version v1.0
 * @date 2020-04-21
 */

public class MessageDTO implements Serializable {

    private static final long serialVersionUID = 6200772203927337847L;

    private String title;

    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MessageDTO{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
