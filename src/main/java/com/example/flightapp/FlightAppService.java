package com.example.flightapp;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.logging.Logger;

@Service
public class FlightAppService {
    public HashMap<Integer, Integer> checkedInBaggage;
    public HashSet<Integer> validTickets;
    public HashSet<Integer> coupons;
    private static final Logger LOG = Logger.getLogger(FlightAppService.class.getName());

    public FlightAppService() {
        this.checkedInBaggage= new HashMap<Integer, Integer>() {};
        this.validTickets = new HashSet<>( Arrays.asList(18484, 33251, 57798, 79409, 58219, 94675, 41980, 39694, 81567, 59258));
        this.coupons = new HashSet<>( Arrays.asList(27223, 86560, 83239, 57628, 12773, 49281, 20900, 31803, 11447, 81507));
    }

    public Boolean isTicketAvailable(int ticketId) {
        return validTickets.contains(ticketId);
    }

    public Boolean checkinBaggage(int destinationId, int baggageId) {
            if (checkedInBaggage.containsKey(baggageId)) {
                return false;
            }
            checkedInBaggage.put( baggageId, destinationId);
            return true;
    }

    public Float checkCoupon(int couponId, int price) {
        if (coupons.contains(couponId)) {
            switch( new Random().nextInt(2)) {
                case 0:
                    return (float) price * (float) 0.10;
                case 1:
                    return (float) price * (float) 0.50;
                case 2:
                    return (float) price * (float) 0.60;
            }
        }
        return (float)-1.0;
    }
}
