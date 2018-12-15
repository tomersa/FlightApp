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

//    a. Check if ticket is available - 10 points
//    a1. User Provide TicketId(Numeric) and return response (boolean) whether the ticket is
//    available or not (the response will determine upon your predefined static data)
//    (10points).
    @RequestMapping(value="/isTicketAvailable/{ticketId}", method = GET)
    @ResponseBody
    public Boolean isTicketAvailable(@PathVariable("ticketId") int ticketId){
        LOG.info("isTicketAvailable");
        return flightAppService.isTicketAvailable(ticketId);
    }

//    b. Provide baggage check in service - 10 points
//    b1. User provide Destination Id(Numeric) and baggage Id(String)
//    b2. Return answer if the checkin succeeded (boolean)
    @RequestMapping(
            value = "/checkinBaggage", method = GET)
    @ResponseBody
    public String checkinBaggage(@RequestParam(value="destinationId", required=true) Integer destinationId,
                                 @RequestParam(value="baggageId", required=true) Integer baggageId) {
        return String.format( "%b", flightAppService.checkinBaggage( destinationId, baggageId));
    }


//    c. Provide Coupon support. 10 points
//    c1. User provide couponId(Numeric) and Price(Double)
//    c2. Return response if the coupon is valid(boolean) in case it is the user will get the final
//    price after discount (10%,50%,60% - picked up randomly)
//    * create random list of valid couponId's
//     */
//
    @RequestMapping(
            value = "/checkCoupon", method = GET)
    @ResponseBody
    public String checkCoupon(@RequestParam(value="couponId", required=true) Integer couponId,
                              @RequestParam(value="price", required=true) Integer price) {
        String m = String.format( "checkCoupon( %s, %s )", couponId, price );
        LOG.info(m);
        return m;
    }
}
