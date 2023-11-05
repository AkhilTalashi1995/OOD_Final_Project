package edu.neu.csye6200.view.images;
import javax.swing.ImageIcon;

/**
 *
 * @author srika
 */
public class IconFetch {
    
    private static IconFetch instance;

    private IconFetch(){
    }

    public static IconFetch getInstance() {
        if (instance == null)
            instance = new IconFetch();
        return instance;
    }

    public ImageIcon getIcon(String iconName) {
        java.net.URL imgUrl = getClass().getResource(iconName);
        if (imgUrl != null) {
            return new ImageIcon(imgUrl);
        } else {
            throw new IllegalArgumentException("This icon file does not exist");
        }
    }
    
    public static final String LOGIN_PATH = "./2191544_key_lock_login_secret_secure_icon.png";

}