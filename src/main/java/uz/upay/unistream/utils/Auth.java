package uz.upay.unistream.utils;

/**
 * Created by Sarvar Nishonboyev on Apr 23, 2018
 */

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.util.UriComponents;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Auth {

    public static HttpHeaders createAuthHeader(String app_key, String app_secret, UriComponents path){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "UNIHMAC " + app_key + ":"
                + org.glassfish.jersey.internal.util.Base64.encodeAsString(Auth.encodeHmacSHA256(app_secret,
                HttpMethod.GET + "\n" +
                        "\n" +
                        DateTimeFormatter.RFC_1123_DATE_TIME.format(ZonedDateTime.now(ZoneOffset.UTC)) + "\n" +
                        path.toUriString().toLowerCase() + "\n" +
                        "")));
        return headers;
    }

    public static String encodeHmacSHA256(String key, String data) {
        String hash = "";
        try {

            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(key.getBytes(), "HmacSHA256");
            sha256_HMAC.init(secret_key);

            hash = Base64.encodeBase64String(sha256_HMAC.doFinal(data.getBytes()));
            System.out.println(hash);
        }
        catch (Exception e){
            System.out.println("Error: " + e.getStackTrace());
        }
        return hash;
    }
}
