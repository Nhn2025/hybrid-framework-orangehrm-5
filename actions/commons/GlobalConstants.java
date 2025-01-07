package commons;

import java.io.File;

public class GlobalConstants {
    //  App Infor
    public static final String DEV_ADMIN_URL = "http://localhost:3000/web/index.php/auth/login";
    public static final String DEV_ADMIN_USERNAME = "nhuduong";
    public static final String DEV_ADMIN_PASSWORD = "6HCRLp46@";

    // Wait Infor
    public static final long SHORT_TIMEOUT = 5;
    public static final long LONG_TIMEOUT = 50;

    // System Infor
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String SEPARATOR = File.separator;

    // Download/ Upload file
    public static final String UPLOAD_PATH = PROJECT_PATH + SEPARATOR + "uploadFiles" + SEPARATOR;
}