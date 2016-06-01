package de.hepisec.firebase.messaging;

import java.io.IOException;
import java.util.logging.Logger;
import org.junit.Test;

/**
 *
 * @author Hendrik Pilz
 */
public class FirebaseMessengerTest {
    
    public FirebaseMessengerTest() {
    }
    
    @Test
    public void jsonSerializationTest() throws IOException {
        FirebaseNotification notification = new FirebaseNotification();
        notification.setBadge("badge");
        notification.setBody("body");
        notification.setBody_loc_args(new String[] {"arg1", "arg2"});
        notification.setBody_loc_key("body_loc_key");
        notification.setClick_action("click_action");
        notification.setColor("color");
        notification.setIcon("icon");
        notification.setSound("sound");
        notification.setTag("tag");
        notification.setTitle("title");
        notification.setTitle_loc_args(new String[] {"arg1", "arg2"});
        notification.setTitle_loc_key("title_loc_key");
        
        FirebaseMessage msg = new FirebaseMessage();
        msg.setCollapseKey("collapse_key");
        msg.setCondition("condition");
        msg.setContentAvailable(true);
        msg.setData("moep");
        msg.setDelayWhileIdle(true);
        msg.setDryRun(true);
        msg.setNotification(notification);
        msg.setPriority(FirebaseMessage.PRIORITY_HIGH);
        msg.setRegistrationIds(new String[] {"reg1", "reg2"});
        msg.setRestrictedPackageName("restricted_package_name");
        msg.setTimeToLive(86400);
        msg.setTo("to");
        
        FirebaseMessenger fbm = new FirebaseMessenger();
        Logger.getLogger(FirebaseMessengerTest.class.getName()).info(fbm.toJSON(msg));
    }
}
