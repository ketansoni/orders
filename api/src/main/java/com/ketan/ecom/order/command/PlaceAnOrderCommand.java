package com.ketan.ecom.order.command;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

public class PlaceAnOrderCommand {
    @TargetAggregateIdentifier
    private final String id;
    private final String orderName;
    private final int price;

    private final String customerId;

    public PlaceAnOrderCommand(String id, String orderName, int price, String customerId) {
        this.id = id;
        this.orderName = orderName;
        this.price = price;
        this.customerId = customerId;
    }

    public String getId() {
        return id;
    }

    public String getOrderName() {
        return orderName;
    }

    public int getPrice() {
        return price;
    }

    public String getCustomerId() {
        return customerId;
    }
}
