import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**
 * Created by wuhao on 16/4/21.
 */
public class Test {
    public static void main(String args[])throws Exception{
        Properties props = System.getProperties();
        props.setProperty("mail.transport.protocol", "smtp");
        Session session = Session.getDefaultInstance(props);
        Message msg = new MimeMessage(session);
        msg.setSubject("Test Title");
        msg.setText("How are you!");
        msg.setSentDate(new Date());
        Address address = new InternetAddress("president@whitehouse.gov", "George Bush");
    }
}
