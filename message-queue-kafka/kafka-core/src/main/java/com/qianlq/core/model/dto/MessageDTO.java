package com.qianlq.core.model.dto;

import java.io.Serializable;

/**
 * @author coderqian
 * @version v1.0
 * @date 2020-03-28
 */

public class MessageDTO implements Serializable {

    private static final long serialVersionUID = -6744014582653293703L;

    private String id;
    private String message;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MessageDTO{" +
                "id=" + id +
                ", message='" + message + '\'' +
                '}';
    }
}
