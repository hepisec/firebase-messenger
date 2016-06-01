package de.hepisec.firebase.messaging;

/**
 * Notification format according to https://firebase.google.com/docs/cloud-messaging/http-server-ref#send-downstream
 * 
 * @author Hendrik Pilz
 */
public class FirebaseNotification {
    /**
     * Required for Android, Optional for iOS
     * 
     * Indicates notification title. This field is not visible on iOS phones and tablets.
     */
    private String title;
    
    /**
     * (Optional)
     * Indicates notification body text.
     */
    private String body;
    
    /**
     * Required for Android
     * Indicates notification icon. Sets value to myicon for drawable resource myicon.
     */
    private String icon;
    
    /**
     * (Optional)
     * Indicates a sound to play when the device receives a notification. 
     * 
     * Supports default or the filename of a sound resource bundled in the app.
     * 
     * Android sound files must reside in /res/raw/, while iOS sound files can be 
     * in the main bundle of the client app or in the Library/Sounds folder of the 
     * app's data container. See the iOS Developer Library for more information.
     */
    private String sound;
    
    /**
     * (Optional) iOS only
     * Indicates the badge on the client app home icon.
     */
    private String badge;
    
    /**
     * (Optional) Android only
     * Indicates whether each notification results in a new entry in the notification drawer on Android. 
     * If not set, each request creates a new notification. 
     * If set, and a notification with the same tag is already being shown, 
     * the new notification replaces the existing one in the notification drawer.
     */
    private String tag;
    
    /**
     * (Optional) Android only
     * Indicates color of the icon, expressed in #rrggbb format
     */
    private String color;
    
    /**
     * (Optional)
     * Indicates the action associated with a user click on the notification.
     * 
     * If set on iOS, corresponds to category in the APNs payload.
     * 
     * On Android, if this is set, an activity with a matching intent filter is 
     * launched when user clicks the notification.
     */
    private String click_action;
    
    /**
     * (Optional)
     * Indicates the key to the body string for localization.
     * 
     * On iOS, this corresponds to "loc-key" in the APNs payload.
     * 
     * On Android, use the key in the app's string resources when populating this value.
     */
    private String body_loc_key;
    
    /**
     * (Optional)
     * Indicates the string value to replace format specifiers in the body string for localization.
     * 
     * On iOS, this corresponds to "loc-args" in the APNs payload.
     * 
     * On Android, these are the format arguments for the string resources. For more information, see Formatting and Styling.
     */
    private String[] body_loc_args;
    
    /**
     * (Optional)
     * Indicates the key to the title string for localization.
     * 
     * On iOS, this corresponds to "title-loc-key" in the APNs payload.
     * 
     * On Android, use the key in the app's string resources when populating this value.
     */
    private String title_loc_key;
    
    /**
     * (Optional)
     * Indicates the string value to replace format specifiers in the title string for localization.
     * 
     * On iOS, this corresponds to "title-loc-args" in the APNs payload.
     * 
     * On Android, these are the format arguments for the string resources. For more information, see Formatting strings.
     */
    private String[] title_loc_args;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String getBadge() {
        return badge;
    }

    public void setBadge(String badge) {
        this.badge = badge;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getClick_action() {
        return click_action;
    }

    public void setClick_action(String click_action) {
        this.click_action = click_action;
    }

    public String getBody_loc_key() {
        return body_loc_key;
    }

    public void setBody_loc_key(String body_loc_key) {
        this.body_loc_key = body_loc_key;
    }

    public String[] getBody_loc_args() {
        return body_loc_args;
    }

    public void setBody_loc_args(String[] body_loc_args) {
        this.body_loc_args = body_loc_args;
    }

    public String getTitle_loc_key() {
        return title_loc_key;
    }

    public void setTitle_loc_key(String title_loc_key) {
        this.title_loc_key = title_loc_key;
    }

    public String[] getTitle_loc_args() {
        return title_loc_args;
    }

    public void setTitle_loc_args(String[] title_loc_args) {
        this.title_loc_args = title_loc_args;
    }
}
