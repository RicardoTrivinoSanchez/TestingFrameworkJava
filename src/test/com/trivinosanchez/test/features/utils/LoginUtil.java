package com.trivinosanchez.test.features.utils;

import com.trivinosanchez.framework.base.DriverContext;
import org.openqa.selenium.Cookie;

import java.net.*;

public class LoginUtil {

    private static HttpURLConnection conn;

    public static void logUser() {
        try {
            initConnection();
            HttpCookie token = sendGet();
            HttpCookie applicationCookie = sendPost(token);
            Cookie cookie = new Cookie(applicationCookie.getName(), applicationCookie.getValue());
            DriverContext.getDriver().manage().addCookie(cookie);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void initConnection() throws Exception {
        String loginUrl = PageUtils.getPageUrl("Login");
        URL connUrl = new URL(loginUrl);
        conn = (HttpURLConnection) connUrl.openConnection();
    }

    private static HttpCookie sendGet() throws ProtocolException {
        conn.setRequestMethod("GET");
        return getCookieByName("RequestVerificationToken");
    }

    private static HttpCookie sendPost(HttpCookie token) throws ProtocolException {
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Cookie", String.valueOf(token));
        return getCookieByName("AspNet.ApplicationCookie");
    }

    private static HttpCookie getCookieByName(String cookieName) {
        String cookiesHeader = conn.getHeaderField("Set-Cookie");
        for (HttpCookie cookie : HttpCookie.parse(cookiesHeader)) {
            if (cookie.getName().contains(cookieName)) {
                return cookie;
            }
        }
        return null;
    }
}
