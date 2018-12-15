package com.example.flightapp.controllers;

import com.example.flightapp.FlightAppService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@WebMvcTest(FlightAppController.class)
public class FlightAppControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private FlightAppService service;

    @Test
    public void couponTest() {
        assertThat(service.checkCoupon(27223, 27223)).isBetween((float)0.1, (float)1.0);
    }
}