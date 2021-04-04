package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:remote.properties"
})
public interface RemoteConfig extends Config {
    @Key("web.remote.driver.user")
    String selenoidDriverUser();

    @Key("web.remote.driver.password")
    String selenoidDriverPassword();
}
