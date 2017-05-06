package com.lilei.iplay.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {

    private static Properties p = null;
    static {
        p = new Properties();
        InputStream in = PropertyUtil.class.getClassLoader().getResourceAsStream("app.properties");
        try {
            p.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return p.getProperty(key);
    }

    public static String getProjectUrl() {
        return p.getProperty("project_url_prefix");
    }
}
