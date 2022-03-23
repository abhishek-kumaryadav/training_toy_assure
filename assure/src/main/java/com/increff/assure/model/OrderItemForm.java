package com.increff.assure.model;

import lombok.Getter;
import lombok.Setter;

/**
 * OrderItemForm
 */
@Setter
@Getter
public class OrderItemForm {

    private String clientSkuId;
    private Long orderedQuantity;
    private Double sellingPricePerUnit;

    @Override
    public String toString() {
        return "OrderItemForm [clientSkuId=" + clientSkuId + ", orderedQuantity=" + orderedQuantity
                + ", sellingPricePerUnit=" + sellingPricePerUnit + "]";
    }
}
