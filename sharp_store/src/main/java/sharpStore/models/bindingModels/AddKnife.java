package sharpStore.models.bindingModels;

import java.math.BigDecimal;

public class AddKnife {

    private String name;

    private BigDecimal price;

    private String imageURL;

    public AddKnife() {
    }

    public AddKnife(String name, BigDecimal price, String imageURL) {
        this.name = name;
        this.price = price;
        this.imageURL = imageURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
