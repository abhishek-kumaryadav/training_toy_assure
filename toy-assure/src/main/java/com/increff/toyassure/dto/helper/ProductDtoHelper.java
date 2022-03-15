package com.increff.toyassure.dto.helper;

import java.util.ArrayList;
import java.util.List;
import com.increff.toyassure.model.ProductData;
import com.increff.toyassure.model.ProductForm;
import com.increff.toyassure.pojo.ProductPojo;

public class ProductDtoHelper {

    public static ProductData convert(ProductPojo productPojo) {
        ProductData productData = new ProductData();
        productData.setGlobalSkuId(productPojo.getGlobalSkuId());
        productData.setClientSkuId(productPojo.getClientSkuId());
        productData.setClientId(productPojo.getClientId());
        productData.setName(productPojo.getName());
        productData.setBrandId(productPojo.getBrandId());
        productData.setMrp(productPojo.getMrp());
        productData.setDescription(productPojo.getDescription());
        return productData;
    }

    public static ProductPojo convert(ProductForm productForm) {
        ProductPojo productPojo = new ProductPojo();
        productPojo.setClientSkuId(CommonsHelper.normalize(productForm.getClientSkuId()));
        productPojo.setClientId(productForm.getClientId());
        productPojo.setName(CommonsHelper.normalize(productForm.getName()));
        productPojo.setBrandId(CommonsHelper.normalize(productForm.getBrandId()));
        productPojo.setMrp(CommonsHelper.normalize(productForm.getMrp()));
        productPojo.setDescription(CommonsHelper.normalize(productForm.getDescription()));
        return productPojo;
    }

    public static List<ProductData> convert(List<ProductPojo> productPojos) {
        List<ProductData> productDatas = new ArrayList<ProductData>();
        for (ProductPojo productPojo : productPojos) {
            productDatas.add(convert(productPojo));
        }
        return productDatas;
    }
}
