package com.mail;

import java.io.IOException;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;
import javax.mail.Authenticator;
import javax.mail.FetchProfile;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Provider;
import javax.mail.Flags;

public class MailRetriever {

    private String emailuser;
    private String emailpassword;
    private String emailserver;
    private String emailprovider;

    // 构造函数
    public MailRetriever(String emailuser,String emailpassword,String emailserver,String emailprovider) {
        this.emailuser=emailuser;
        this.emailpassword=emailpassword;
        this.emailserver=emailserver;
        this.emailprovider=emailprovider;
    }

    // 得到所有的邮件
    public Message[] retrieveAllMailMessage() throws Exception {
        Session session;
        Store store=null;
        Folder folder=null;
        Folder inboxfolder=null;

        Properties props=System.getProperties();
        props.setProperty("mail.store.protocol", "pop3");
        props.setProperty("mail.pop3.host", "pop.qiye.163.com");
        props.setProperty("mail.pop3.port", "110");
        session=Session.getInstance(props,null);
        // 打印出错误信息
        session.setDebug(true);

        store=session.getStore(emailprovider);
        store.connect(emailserver, emailuser, emailpassword);
        folder=store.getFolder("INBOX");
        if(folder==null) throw new Exception("No default folder");
        //inboxfolder=folder.getFolder("INBOX");
        inboxfolder = folder;
        if(inboxfolder==null) throw new Exception("No INBOX");
        inboxfolder.open(Folder.READ_WRITE);

        Message[] msgs = inboxfolder.getMessages();

        for(int i = 0; i < msgs.length; ++i) {
            System.out.println("################################");
            if (msgs[i] != null) {
                System.out.println("邮件标题:" + msgs[i].getSubject());
                System.out.println("邮件发送者：" + msgs[i].getFrom());
                System.out.println("邮件发送时间：" + msgs[i].getSentDate());
                System.out.println("邮件正文:"
                        + ((msgs[i].getContent() == null) ? "没有正文"
                        : msgs[i].getContent()));
                RenderableMessage render = new RenderableMessage(msgs[i]);
                int count = new RenderableMessage(msgs[i])
                        .getAttachmentCount();
                System.out.println("附件数量：" + count);
                // 得到附件内容，如果存在附件的话，可以使用Attachement来读取
                // 附件的内容
                if (count > 0) {
                    // 读取附件
                    for (int j = 0; j < count; ++j) {
                        Attachment attachment = render.getAttachment(j);
                        System.out.println("附件类型："
                                + attachment.getContenttype());
                        System.out.println("附件名称："
                                + attachment.getFilename());
                    }
                }
            }
        }

        return msgs;
    }

    // 得到未读邮件
    public List retrieveAllUnreadMessage() throws Exception {
        List unreadMessages = new ArrayList();

        Session session;
        Store store=null;
        Folder folder=null;
        Folder inboxfolder=null;

        Properties props=System.getProperties();
        props.setProperty("mail.pop3s.rsetbeforequit","true");
        props.setProperty("mail.pop3.rsetbeforequit","true");
        session=Session.getInstance(props,null);
        // 打印出错误信息
        //session.setDebug(true);

        store=session.getStore(emailprovider);
        store.connect(emailserver, emailuser, emailpassword);
        folder=store.getFolder("INBOX");
        if(folder==null) throw new Exception("No default folder");
        //inboxfolder=folder.getFolder("INBOX");
        inboxfolder = folder;
        if(inboxfolder==null) throw new Exception("No INBOX");
        inboxfolder.open(Folder.READ_WRITE);

        Message[] msgs = inboxfolder.getMessages();
        if (msgs.length == 0) {
            System.out.println("No Message to Read");
        } else {
            System.out.println("Total Messages Found:" + msgs.length + "");
        }

        // Loop over all of the messages
        for (int messageNumber = 0; messageNumber < msgs.length; messageNumber++) {
            Message message = msgs[messageNumber];

            Flags flags = message.getFlags();
            if (!message.isSet(Flags.Flag.SEEN) && !message.isSet(Flags.Flag.ANSWERED)) {
                unreadMessages.add(message);
            }
        }

        return unreadMessages;
    }


    //方法中存在不足
    public void getMail() {
        Session session;
        Store store=null;
        Folder folder=null;
        Folder inboxfolder=null;

        Properties props=System.getProperties();
        props.setProperty("mail.pop3s.rsetbeforequit","true");
        props.setProperty("mail.pop3.rsetbeforequit","true");
        session=Session.getInstance(props,null);
        //session.setDebug(true);

        try {
            store=session.getStore(emailprovider);
            store.connect(emailserver, emailuser, emailpassword);
            folder=store.getFolder("INBOX");
            if(folder==null) throw new Exception("No default folder");
            //inboxfolder=folder.getFolder("INBOX");
            inboxfolder = folder;
            if(inboxfolder==null) throw new Exception("No INBOX");
            inboxfolder.open(Folder.READ_ONLY);

            Message[] msgs=inboxfolder.getMessages();

            FetchProfile fp=new FetchProfile();
            fp.add("Subject");
            inboxfolder.fetch(msgs,fp);

            for(int j=msgs.length-1;j>=0;j--) {
                // System.out.println("/////////////////" + msgs[j].getSubject());

                if(msgs[j].getSubject().startsWith("test")) {
                    setLatestMessage(msgs[j]);
                    break;
                }
            }

            inboxfolder.close(false);
            store.close();

        } catch (NoSuchProviderException ex) {
            ex.printStackTrace();
        } catch (MessagingException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if(store!=null) store.close();
            } catch (MessagingException ex) {
                ex.printStackTrace();
            }
        }
    }

    // 方法中存在不足之处
    public Renderable getLatestMessage() {
        return latestMessage;
    }

    private Renderable latestMessage;

    void setLatestMessage(Message message) {
        if(message==null) {
            latestMessage=null;
            return;
        }

        try {
            if(message.getContentType().startsWith("text/plain")) {
                latestMessage=new RenderablePlainText(message);
            } else {
                latestMessage=new RenderableMessage(message);
            }
        } catch (MessagingException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {

        //MailRetriever mr=new MailRetriever(args[0],args[1],args[2],args[3]);
        // 设置参数
        //######################################################
        //                设置参数
        //####################################################
        // 这里需要注意的是这个方法是没办法收取yahoo的邮箱的
        String emailuser = "wuhao@lsh123.com";            // 用户名
        String emailpassword = "lianshang123";        // 密码
        String emailserver = "pop.qiye.163.com";    // 邮件服务器名称
        String emailprovider = "pop3";        // 使用协议imap, pop3等

        MailRetriever mr = new MailRetriever(emailuser, emailpassword, emailserver, emailprovider);
        try {
            // 顺序
            //System.out.println("未读邮件有：" + mr.retrieveAllUnreadMessage().toArray().length);
            if(null != mr)
                mr.retrieveAllMailMessage();


        } catch (Exception e) {
            e.printStackTrace();
        }

        /*
        mr.getMail();
        Renderable msg=mr.getLatestMessage();
        if(msg==null) {
            System.out.println("No valid messages in the mail account");
        } else {
            System.out.println("Subject:"+msg.getSubject());
            System.out.println("Body Text:"+msg.getBodytext());
            System.out.println(msg.getAttachmentCount()+" attachments");
            for(int i=0;i<msg.getAttachmentCount();i++) {
                Attachment at=msg.getAttachment(i);
                System.out.println(at.getFilename()+" "+at.getContent().length+" bytes of ("+at.getContenttype()+")");

            }
        }

        */
    }
}
