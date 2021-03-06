package ru.apolonov.tests.properties;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.apolonov.config.CredentialsConfig;

import static java.lang.String.format;

@Tag("owner")
public class OwnerTests {

    public CredentialsConfig credentials = ConfigFactory.create(CredentialsConfig.class);  // из документации Owner

    @Test
    void readCredentialsTest() {
        String login = credentials.login();
        String password = credentials.password();

        System.out.println(login);
        System.out.println(password);

        String message = format("I login as %s with password %s", login, password);
        System.out.println(message);

    }
}
