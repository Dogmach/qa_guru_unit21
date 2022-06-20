package config;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.*;

@Sources({"classpath:config/browserstack.properties"})
public interface BrowserstackConfig extends Config {

    @Key("app")
    String app();

    @Key("device")
    String device();

    @Key("os_version")
    String osVersion();

    @Key("project")
    String project();

    @Key("build")
    String build();

    @Key("name")
    String name();
    @Key("browser_stack_url")
    String browserstackUrl();
}