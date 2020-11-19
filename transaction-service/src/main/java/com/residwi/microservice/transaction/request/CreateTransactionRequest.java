package com.residwi.microservice.transaction.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CreateTransactionRequest {

    @NotBlank
    private String code;

    @NotNull
    private Long customerId;

    @NotNull
    private Long productId;

    @NotNull
    private Long quantity;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
