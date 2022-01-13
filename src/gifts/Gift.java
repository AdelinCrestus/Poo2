package gifts;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import enums.Category;

public final class Gift {
    private String productName;
    private Double price;
    private Category category;
    @JsonIgnore
    private Integer quantity;

    public Gift() {
    }
    public Gift(final Gift gift) {
        this.productName = gift.getProductName();
        this.price = gift.getPrice();
        this.category = gift.getCategory();
    }
    @JsonIgnore
    public Integer getQuantity() {
        return quantity;
    }
    @JsonProperty
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(final String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(final Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(final Category category) {
        this.category = category;
    }
}
