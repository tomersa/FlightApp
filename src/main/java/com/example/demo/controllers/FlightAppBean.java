package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.logging.Logger;

@Component
public class FlightAppBean {
    public int[] validTickets = {18484, 33251, 57798, 79409, 58219, 94675, 41980, 39694, 81567, 59258};
    public int[] checkedInBaggage = {55769, 60032, 69709, 48073, 70903, 31817, 62083, 46517, 35763, 87280};

    private static final Logger LOG = Logger.getLogger(FlightAppBean.class.getName());

        @Autowired
        private Environment environment;

        @PostConstruct
        public void init() {
            LOG.info(Arrays.toString(environment.getDefaultProfiles()));
        }
    }


