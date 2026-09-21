package io.hawt.tests.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootService {

    public static void main(String[] args) {
        System.setProperty("hawtio.proxyWhitelist", "localhost, 127.0.0.1");
        System.setProperty("hawtio.realm", "hawtio");
        System.setProperty("hawtio.roles", "admin");
        System.setProperty("hawtio.rolePrincipalClasses", "org.eclipse.jetty.security.jaas.JAASRole");

        String loginConf = SpringBootService.class.getClassLoader().getResource("login.conf").toExternalForm();
        System.setProperty("java.security.auth.login.config", loginConf);

        String realmProps = SpringBootService.class.getClassLoader().getResource("realm.properties").toExternalForm();
        System.setProperty("login.file", realmProps);

        SpringApplication.run(SpringBootService.class, args);
    }
}
