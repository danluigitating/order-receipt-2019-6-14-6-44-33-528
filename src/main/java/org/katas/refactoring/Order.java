package org.katas.refactoring;

import java.util.List;

public class Order {
    private String name;
    private String address;
    private List<LineItem> lineItems;

    public Order(String name, String address, List<LineItem> lineItems) {
        this.name = name;
        this.address = address;
        this.lineItems = lineItems;
    }

    String getCustomerName() {
        return name;
    }

    String getCustomerAddress() {
        return address;
    }

    List<LineItem> getLineItems() {
        return lineItems;
    }
}
