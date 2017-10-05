package sharpStore.enums;

public enum OrderStatus {

    PENDING("Pending"), SHIPPED("Shipped"), DELIVERED("Delivered");

    private String statusName;

    OrderStatus(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusName() {
        return statusName;
    }
}
