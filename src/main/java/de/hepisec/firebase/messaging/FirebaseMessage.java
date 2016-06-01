package de.hepisec.firebase.messaging;

import java.util.Map;
import java.util.TreeMap;

/**
 * Message format according to https://firebase.google.com/docs/cloud-messaging/http-server-ref#send-downstream
 * 
 * @author Hendrik Pilz
 */
public class FirebaseMessage {
    public static final String PRIORITY_NORMAL = "normal";
    public static final String PRIORITY_HIGH = "high";
    public static final int MAX_TTL = 2419200;
    private Map<String, Object> fields = new TreeMap<>();

    public FirebaseMessage() {
        
    }
    
    protected Map<String, Object> getFields() {
        return fields;
    }
    
    public Object getTo() {
        return fields.get("to");
    }

    /**
     * (Optional)
     * This parameter specifies the recipient of a message.
     * 
     * The value must be a registration token, notification key, or topic.
     * Do not set this field when sending to multiple topics. See condition.
     * @param to
     */    
    public final void setTo(String to) {
        fields.put("to", to);
    }

    public Object getRegistration_ids() {
        return fields.get("registration_ids");
    }

    /**
     * This parameter specifies a list of devices (registration tokens, or IDs) 
     * receiving a multicast message. It must contain at least 1 and at most 1000 registration tokens.
     * 
     * Use this parameter only for multicast messaging, not for single recipients. 
     * Multicast messages (sending to more than 1 registration tokens) are allowed using HTTP JSON format only.
     * @param registration_ids
     */
    public final void setRegistration_ids(String[] registration_ids) {
        fields.put("registration_ids", registration_ids);
    }

    public Object getCondition() {
        return fields.get("condition");
    }

    /**
     * (Optional)
     * This parameter specifies a logical expression of conditions that determine the message target.
     * 
     * Supported condition: Topic, formatted as "'yourTopic' in topics". This value is case-insensitive.
     * 
     * Supported operators: &&, ||. Maximum two operators per topic message supported.
     * @param condition
     */    
    public final void setCondition(String condition) {
        fields.put("condition", condition);
    }

    public Object getCollapse_key() {
        return fields.get("collapse_key");
    }

    /**
     * (Optional)
     * This parameter identifies a group of messages (e.g., with collapse_key: "Updates Available") that can be collapsed,
     * so that only the last message gets sent when delivery can be resumed.
     * 
     * This is intended to avoid sending too many of the same messages when the 
     * device comes back online or becomes active (see delay_while_idle).
     * 
     * Note that there is no guarantee of the order in which messages get sent.
     * 
     * Note: A maximum of 4 different collapse keys is allowed at any given time. 
     * This means a FCM connection server can simultaneously store 4 different 
     * send-to-sync messages per client app. If you exceed this number, there is no 
     * guarantee which 4 collapse keys the FCM connection server will keep.
     * @param collapse_key
     */    
    public final void setCollapse_key(String collapse_key) {
        fields.put("collapse_key", collapse_key);
    }

    public Object getPriority() {
        return fields.get("priority");
    }

    /**
     * (Optional)
     * Sets the priority of the message. Valid values are "normal" and "high".
     * On iOS, these correspond to APNs priorities 5 and 10.
     * 
     * By default, messages are sent with normal priority. Normal priority optimizes 
     * the client app's battery consumption and should be used unless immediate delivery is required. 
     * For messages with normal priority, the app may receive the message with unspecified delay.
     * 
     * When a message is sent with high priority, it is sent immediately, and the app 
     * can wake a sleeping device and open a network connection to your server.
     * 
     * For more information, see Setting the priority of a message.
     * @param priority
     */    
    public final void setPriority(String priority) {
        fields.put("priority", priority);
    }

    public Object getContent_available() {
        return fields.get("content_available");
    }

    /**
     * (Optional)
     * On iOS, use this field to represent content-available in the APNS payload. 
     * When a notification or message is sent and this is set to true, an inactive 
     * client app is awoken. On Android, data messages wake the app by default. 
     * On Chrome, currently not supported.
     * @param content_available
     */    
    public final void setContent_available(boolean content_available) {
        fields.put("content_available", content_available);
    }

    public Object getDelay_while_idle() {
        return fields.get("delay_while_idle");
    }

    /**
     * (Optional)
     * When this parameter is set to true, it indicates that the message should not be sent 
     * until the device becomes active.
     * 
     * The default value is false.
     * @param delay_while_idle
     */    
    public final void setDelay_while_idle(boolean delay_while_idle) {
        fields.put("delay_while_idle", delay_while_idle);
    }

    public Object getTime_to_live() {
        return fields.get("time_to_live");
    }

    /**
     * (Optional)
     * This parameter specifies how long (in seconds) the message should be kept in FCM 
     * storage if the device is offline. The maximum time to live supported is 4 weeks, 
     * and the default value is 4 weeks. For more information, see Setting the lifespan of a message.
     * @param time_to_live
     */    
    public final void setTime_to_live(int time_to_live) {
        if (time_to_live < 0) {
            time_to_live = 0;
        } else if (time_to_live > MAX_TTL) {
            time_to_live = MAX_TTL;
        }
        
        fields.put("time_to_live", time_to_live);
    }

    public Object getRestricted_package_name() {
        return fields.get("restricted_package_name");
    }

    /**
     * (Optional)
     * This parameter specifies the package name of the application where the registration 
     * tokens must match in order to receive the message.
     * @param restricted_package_name
     */    
    public final void setRestricted_package_name(String restricted_package_name) {
        fields.put("restricted_package_name", restricted_package_name);
    }

    public Object isDry_run() {
        return fields.get("dry_run");
    }

    /**
     * (Optional)
     * This parameter, when set to true, allows developers to test a request without actually sending a message.
     * 
     * The default value is false.
     * @param dry_run
     */    
    public final void setDry_run(boolean dry_run) {
        fields.put("dry_run", dry_run);
    }

    public Object getData() {
        return fields.get("data");
    }

    /**
     * (Optional)
     * This parameter specifies the custom key-value pairs of the message's payload.
     * 
     * For example, with data:{"score":"3x1"}:
     * 
     * On iOS, if the message is sent via APNS, it represents the custom data fields. 
     * If it is sent via FCM connection server, it would be represented as key value 
     * dictionary in AppDelegate application:didReceiveRemoteNotification:.
     * 
     * On Android, this would result in an intent extra named score with the string value 3x1.
     * 
     * The key should not be a reserved word ("from" or any word starting with "google" or "gcm"). 
     * Do not use any of the words defined in this table (such as collapse_key).
     * 
     * Values in string types are recommended. You have to convert values in objects or other 
     * non-string data types (e.g., integers or booleans) to string.
     * @param data
     */    
    public final void setData(Object data) {
        fields.put("data", data);
    }

    public Object getNotification() {
        return fields.get("notification");
    }

    /**
     * (Optional)
     * This parameter specifies the predefined, user-visible key-value pairs of the notification payload.
     * 
     * See Notification payload support for detail. For more information about notification message 
     * and data message options, see Payload.
     * @param notification
     */    
    public final void setNotification(FirebaseNotification notification) {
        fields.put("notification", notification);
    }
}
