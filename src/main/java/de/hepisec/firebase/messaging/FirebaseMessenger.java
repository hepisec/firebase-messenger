package de.hepisec.firebase.messaging;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;

/**
 *
 * @author Hendrik Pilz
 */
public class FirebaseMessenger {
    private String authorizationKey;
    
    public FirebaseMessenger() {
        
    }
    
    public FirebaseMessenger(String authorizationKey) {
        this.authorizationKey = authorizationKey;
    }

    public void sendMessage(FirebaseMessage msg) throws IOException {
        Request.Post("https://fcm.googleapis.com/fcm/send")
        .addHeader("Authorization", "key=" + authorizationKey)
        .bodyString(toJSON(msg), ContentType.create("application/json"))
        .execute();
    }
    
    /**
     * See: https://developers.google.com/instance-id/reference/server#create_a_relation_mapping_for_an_app_instance
     * 
     * @param idToken
     * @param topic
     * @throws IOException 
     */
    public void subscribeToTopic(String idToken, String topic) throws IOException {
        Request.Post("https://iid.googleapis.com/iid/v1/" + idToken + "/rel/topics/" + topic)
        .addHeader("Authorization", "key=" + authorizationKey)
        .bodyString("", ContentType.create("application/json"))
        .execute();        
    }
    
    public String toJSON(FirebaseMessage msg) throws IOException {
        ObjectMapper om = new ObjectMapper();
        om.configure(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS, false);
        om.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);       
        return om.writeValueAsString(msg.getFields());
    }
    
    public String getAuthorizationKey() {
        return authorizationKey;
    }

    public void setAuthorizationKey(String authorizationKey) {
        this.authorizationKey = authorizationKey;
    }
}
