package com.zatec.coding.challenge.service;

import com.zatec.coding.challenge.AbstractInit;
import com.zatec.coding.challenge.model.People;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class SwapiServiceTest extends AbstractInit {

    @Mock
    private SwapiService swapiService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.swapiService = new SwapiService();
    }

    @Test
    public void shouldReturnPeople() {
        when(swapiService.getPeople()).thenReturn(createMockPeople());
        People people = swapiService.getPeople();
        assertNotNull(people);
    }

    private People createMockPeople() {
        People people = new People();
        people.setCount(1);
        return people;
    }
}
