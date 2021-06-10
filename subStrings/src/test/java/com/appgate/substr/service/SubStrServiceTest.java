package com.appgate.substr.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SubStrServiceTest {

    private SubStrService subStrService;

    @Before
    public void setUp() {
        subStrService = new SubStrService();
    }

    @Test
    public void shouldReturn0WhenStringEmpty() {
        Assert.assertEquals(subStrService.execute("",""),0);
    }

    @Test
    public void shouldReturn1WhenStringsEquals() {
        Assert.assertEquals(subStrService.execute("salchipapas","salchipapas"),1);
    }

    @Test
    public void shouldReturn5mainScenario() {
       Assert.assertEquals(subStrService.execute("babgbag","bag"),5);
    }

    @Test
    public void shouldReturn3mainScenario() {
        Assert.assertEquals(subStrService.execute("rabbbit","rabbit"),3);
    }
}
