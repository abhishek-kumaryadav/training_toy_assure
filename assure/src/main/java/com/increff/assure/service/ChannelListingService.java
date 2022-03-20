package com.increff.assure.service;

import java.util.List;
import com.increff.assure.dao.ChannelListingDao;
import com.increff.assure.pojo.ChannelListingPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ChannelListingService {

    @Autowired
    private ChannelListingDao dao;

    @Transactional(rollbackFor = ApiException.class)
    public void add(List<ChannelListingPojo> p) throws ApiException {
        for (ChannelListingPojo chLiPojo : p) {
            dao.insert(chLiPojo);
        }
    }

    @Transactional(readOnly = true)
    public ChannelListingPojo get(Long id) throws ApiException {
        return getCheck(id);
    }

    @Transactional(readOnly = true)
    public List<ChannelListingPojo> getAll() throws ApiException {
        List<ChannelListingPojo> channelListingPojos = dao.selectAll();
        if (channelListingPojos == null) {
            throw new ApiException("No ChannelListing Category Pair in database!");
        }
        return channelListingPojos;
    }

    @Transactional(readOnly = true)
    public ChannelListingPojo getCheck(Long id) throws ApiException {
        ChannelListingPojo p = dao.select(id);
        if (p == null) {
            throw new ApiException("ChannelListing with given ID does not exist, id: " + id);
        }
        return p;
    }

}
