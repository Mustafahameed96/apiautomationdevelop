package core.general;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Screenshots {
    public static final String takeScreenshot(String test) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd_hh-mm-ss"); //colon removed, windows not support colon
        Calendar now = Calendar.getInstance();
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        BufferedImage screenShot = robot.createScreenCapture(new java.awt.Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        String filePath = System.getProperty("user.dir") + "/screenshots/" + test + "_" + formatter.format(now.getTime())+".jpg";

        try {
            ImageIO.write(screenShot, "JPG", new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        filePath = filePath.replace(System.getProperty("user.dir"), "..");
        return filePath;
    }

}
