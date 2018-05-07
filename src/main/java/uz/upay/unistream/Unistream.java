package uz.upay.unistream;

import org.springframework.beans.factory.annotation.Value;
import uz.upay.constant.ApiType;

public abstract class Unistream {

    @Value("${unistream.api.test}")
    protected String testDomain;
    @Value("${unistream.api.live}")
    protected String prodDomain;
    @Value("${unistream.api.version}")
    protected String version;
    @Value("${unistream.app_key")
    protected String app_key;
    @Value("${unistream.app_secret")
    protected String app_secret;
    @Value("${spring.profiles.active:Unknown}")
    private String activeProfile;

    public Unistream() {
        System.out.println("default constructor");
    }

    protected String createRoute(String route) {

        if (activeProfile == String.valueOf(ApiType.test))
            return String.format("%s%s", testDomain, route);
        else
            return String.format("%s%s", prodDomain, route);
    }
}
