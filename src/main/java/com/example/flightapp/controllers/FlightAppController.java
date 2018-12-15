package com.example.flightapp.controllers;

import com.example.flightapp.FlightAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class FlightAppController {
    private static final Logger LOG = Logger.getLogger(FlightAppController.class.getName());

    @Autowired
    FlightAppService flightAppService;

    @RequestMapping(value="/isTicketAvailable/{ticketId}", method = GET)
    @ResponseBody
    public Boolean isTicketAvailable(@PathVariable("ticketId") int ticketId){
        boolean result = flightAppService.isTicketAvailable(ticketId);
        LOG.info(String.format("isTicketAvailable: %d - %b", ticketId, result));
        return result;
    }

    @RequestMapping(
            value = "/checkinBaggage", method = GET)
    @ResponseBody
    public Boolean checkinBaggage(@RequestParam(value="destinationId", required=true) Integer destinationId,
                                 @RequestParam(value="baggageId", required=true) Integer baggageId) {
        boolean result = flightAppService.checkinBaggage( destinationId, baggageId);
        LOG.info(String.format("checkinBaggage: %d %d - %b", destinationId, baggageId, result));

        return result;
    }

    @RequestMapping(
            value = "/checkCoupon", method = GET)
    @ResponseBody
    public Float checkCoupon(@RequestParam(value="couponId", required=true) Integer couponId,
                              @RequestParam(value="price", required=true) Integer price) {
        Float finalPrice = flightAppService.checkCoupon(couponId, price);
        LOG.info(String.format( "checkCoupon %d, %d - %f", couponId, price, finalPrice ));
        return finalPrice;
    }
}