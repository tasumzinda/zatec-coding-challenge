package com.zatec.coding.challenge.service;

import com.zatec.coding.challenge.AbstractInit;
import com.zatec.coding.challenge.service.ChuckService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

public class ChuckServiceTest extends AbstractInit {

    @Mock
    private ChuckService chuckService;
    @Mock
    private RestTemplate restTemplate;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.chuckService = new ChuckService();
    }

    @Test
    public void shouldReturnCategories() {
        List<String> result = Arrays.asList(
                "animal", "career", "celebrity"
        );
        when(chuckService.getCategories()).thenReturn(result);
        List<String> categories = chuckService.getCategories();
        assertNotNull(categories);
    }
}
