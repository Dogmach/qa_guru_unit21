package config;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.Sources;

@Sources({"classpath:config/auth.properties"})
public interface AuthConfig extends Config {

    @Key("browserstack.user")
    String browserstackUser();

    @Key("browserstack.key")
    String browserstackKey();
}