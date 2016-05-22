package com.mail;

/**
 * Created by wuhao on 16/5/15.
 */
public interface Renderable {
    Attachment getAttachment(int i);

    int getAttachmentCount();

    String getBodytext();

    String getSubject();

}
