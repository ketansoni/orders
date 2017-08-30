package com.ketan.ecom.order.command.domain;

import com.ketan.ecom.order.ORDERSTATUS;
import com.ketan.ecom.order.command.PlaceAnOrderCommand;
import com.ketan.ecom.order.command.event.OrderCreatedEvent;
import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;
import org.axonframework.eventsourcing.annotation.EventSourcingHandler;

public class Order extends AbstractAnnotatedAggregateRoot<String> {
    @AggregateIdentifier
    private String id;
    private String name;
    private int price;
    private ORDERSTATUS orderStatus;

    public Order() {
    }


    @EventSourcingHandler
    public void on(OrderCreatedEvent orderCreatedEvent) {
        this.id = orderCreatedEvent.getId();
        this.name = orderCreatedEvent.getOrderName();
        this.price = orderCreatedEvent.getPrice();
        this.orderStatus = ORDERSTATUS.PENDING;
    }


    @CommandHandler
    public Order(PlaceAnOrderCommand command) {
        apply(new OrderCreatedEvent(command.getId(), command.getOrderName(), command.getPrice(), command.getCustomerId()));
    }

}
