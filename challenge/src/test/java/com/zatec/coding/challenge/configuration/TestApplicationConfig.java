package com.zatec.coding.challenge.configuration;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile(value = "testcase")
public class TestApplicationConfig {

    public static int WIREMOCK_PORT = 8087;

    @Bean
    public WireMockServer wireMockServer() {
        WireMockServer wireMockServer = new WireMockServer(WIREMOCK_PORT);
        if(!wireMockServer.isRunning()) {
            System.out.println("Starting WireMock server.....");
            wireMockServer.start();
            System.out.println("WireMock server started on port: " + wireMockServer.port());
        }
        return wireMockServer;
    }
}
