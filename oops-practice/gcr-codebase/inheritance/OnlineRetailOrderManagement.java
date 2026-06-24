class Order {
    private String orderId;
    private String orderDate;

    public Order(String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public String getOrderId() { return orderId; }
    public String getOrderDate() { return orderDate; }

    public String getOrderStatus() {
        return "Order [ID=" + orderId + ", Date=" + orderDate + "] - Status: PLACED";
    }
}

class ShippedOrder extends Order {
    private String trackingNumber;

    public ShippedOrder(String orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    public String getTrackingNumber() { return trackingNumber; }

    @Override
    public String getOrderStatus() {
        return super.getOrderStatus().replace("PLACED", "SHIPPED") +
               " | Tracking: " + trackingNumber;
    }
}

class DeliveredOrder extends ShippedOrder {
    private String deliveryDate;

    public DeliveredOrder(String orderId, String orderDate,
                          String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    public String getDeliveryDate() { return deliveryDate; }

    @Override
    public String getOrderStatus() {
        return super.getOrderStatus().replace("SHIPPED", "DELIVERED") +
               " | Delivered On: " + deliveryDate;
    }
}

public class OnlineRetailOrderManagement {
    public static void main(String[] args) {
        Order order = new Order("ORD001", "2024-01-10");
        ShippedOrder shipped = new ShippedOrder("ORD002", "2024-01-11", "TRK98765");
        DeliveredOrder delivered = new DeliveredOrder(
            "ORD003", "2024-01-12", "TRK11223", "2024-01-15"
        );

        System.out.println(order.getOrderStatus());
        System.out.println(shipped.getOrderStatus());
        System.out.println(delivered.getOrderStatus());
    }
}
