package sharpStore.models.bindingModels;

import sharpStore.models.viewModels.ShowKnife;
import sharpStore.models.viewModels.ShowUser;

public class AddOrder {

    private String personName;

    private String phoneNumber;

    private String address;

    private String deliveryType;

    private ShowKnife knife;

    private ShowUser customer;

    public AddOrder() {
    }

    public AddOrder(String personName, String phoneNumber,
                    String address, String deliveryType,
                    ShowKnife knife, ShowUser customer) {
        this.personName = personName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.deliveryType = deliveryType;
        this.knife = knife;
        this.customer = customer;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public ShowKnife getKnife() {
        return knife;
    }

    public void setKnife(ShowKnife knife) {
        this.knife = knife;
    }

    public ShowUser getCustomer() {
        return customer;
    }

    public void setCustomer(ShowUser customer) {
        this.customer = customer;
    }
}
