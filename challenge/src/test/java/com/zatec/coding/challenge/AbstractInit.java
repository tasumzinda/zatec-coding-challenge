package com.zatec.coding.challenge;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.zatec.coding.challenge.configuration.TestApplicationConfig;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ActiveProfiles(value = {"standalone", "testcase"})
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {
                ChallengeApplication.class,
                TestApplicationConfig.class
        }
)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AbstractInit {

    @Autowired
    @Qualifier(value = "wireMockServer")
    protected WireMockServer wireMockServer;

    @Before
    public void setUp() {
        wireMockServer.resetAll();
    }
}
