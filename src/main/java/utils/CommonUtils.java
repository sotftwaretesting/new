package utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by V on 07.11.2015.
 */
public class CommonUtils {

    public static String getStackTrace(Throwable e){
        StringWriter errors = new StringWriter();
        e.printStackTrace(new PrintWriter(errors));
        return errors.toString();
    }
}
