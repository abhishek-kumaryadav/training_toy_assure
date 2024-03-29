package com.increff.assure.dto;

import java.util.ArrayList;
import java.util.List;
import com.increff.assure.dto.helper.ChannelListingDtoHelper;
import com.increff.assure.model.ChannelListingData;
import com.increff.assure.model.ChannelListingForm;
import com.increff.assure.pojo.ChannelListingPojo;
import com.increff.assure.pojo.ProductPojo;
import com.increff.assure.service.ChannelListingService;
import com.increff.assure.service.ProductService;
import com.increff.commons.model.ApiException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ChannelListingDto
 */
@Service
public class ChannelListingDto {

    @Autowired
    private ChannelListingService channelListingService;

    @Autowired
    private ProductService productService;
    private static final Logger LOGGER = Logger.getLogger(ChannelListingDto.class);

    public void add(List<ChannelListingForm> channelListingForms) throws ApiException {
        LOGGER.info("In ChannelListingService:add()");
        LOGGER.info("Form data received: " + channelListingForms.toString());
        List<ChannelListingPojo> channelListingPojos = new ArrayList<ChannelListingPojo>();
        for (ChannelListingForm chLiForm : channelListingForms) {
            validate(chLiForm);
            ProductPojo productPojo = productService.getClientIdClientSkuId(chLiForm.getClientId(),
                    chLiForm.getClientSkuId().trim());
            Long globalSkuId = null;
            if (productPojo != null)
                globalSkuId = productPojo.getGlobalSkuId();
            ChannelListingPojo channelListingPojo = ChannelListingDtoHelper.convert(chLiForm, globalSkuId);
            channelListingPojos.add(channelListingPojo);
        }
        channelListingService.add(channelListingPojos);
    }

    private void validate(ChannelListingForm chLiForm) throws ApiException {
        if (chLiForm.getChannelId() == null)
            throw new ApiException("Channel Id can not be empty!!");
        if (chLiForm.getChannelSkuId() == null || chLiForm.getChannelSkuId().isEmpty())
            throw new ApiException("Channel Sku Id can not be empty!!");
        if (chLiForm.getClientId() == null)
            throw new ApiException("Client Id can not be empty!!");
        if (chLiForm.getClientSkuId() == null || chLiForm.getClientSkuId().isEmpty())
            throw new ApiException("Client Sku Id can not be empty!!");
    }

    public ChannelListingData get(Long id) throws ApiException {
        ChannelListingPojo channelListingPojo = channelListingService.get(id);
        return ChannelListingDtoHelper.convert(channelListingPojo);
    }

    public List<ChannelListingData> getAll() throws ApiException {
        List<ChannelListingPojo> channelListingPojos = channelListingService.getAll();
        return ChannelListingDtoHelper.convert(channelListingPojos);
    }

}
