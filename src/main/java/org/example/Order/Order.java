package org.example.Order;

public class Order {
    private int id;
    private int petId;
    private int quantity;
    private String shipDate;
    private OrderStatus status;
    private boolean complete;


    public Order() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
