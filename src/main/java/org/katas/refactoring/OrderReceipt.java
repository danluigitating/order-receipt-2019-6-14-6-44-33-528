package org.katas.refactoring;

public class OrderReceipt {
    private static final double TAX_RATE = .10;
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    private double totalSalesTax = 0d;
    private double total = 0d;

    public String printReceipt() {
        StringBuilder output = new StringBuilder();
        getHeadersAndInfo(output);
        getLineItems(output);
        getFooter(output);

        return output.toString();
    }

    private void getFooter(StringBuilder output) {
        output.append("Sales Tax").append('\t').append(totalSalesTax);
        output.append("Total Amount").append('\t').append(total);
    }

    private void getLineItems(StringBuilder output) {
        for (LineItem lineItem : order.getLineItems()) {
            output.append(lineItem.getDescription() + "\t")
                    .append(lineItem.getPrice()  + "\t")
                    .append(lineItem.getQuantity()  + "\t")
                    .append(lineItem.totalAmount()  + "\n");

            double salesTax = lineItem.totalAmount() * TAX_RATE;
            totalSalesTax += salesTax;
            total += lineItem.totalAmount() + salesTax;
        }
    }

    private void getHeadersAndInfo(StringBuilder output) {
        output.append("======Printing Orders======\n");
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());
    }
}