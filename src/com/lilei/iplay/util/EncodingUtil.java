package com.lilei.iplay.util;

import java.io.UnsupportedEncodingException;

import com.lilei.iplay.common.Constants;

public class EncodingUtil {

    public static String getEncodingString(String str) {

        try {
            return new String(str.getBytes(Constants.APP_ENCODING), Constants.WEB_EXPECTED_ENCODING);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        };
        return null;
    }
}
