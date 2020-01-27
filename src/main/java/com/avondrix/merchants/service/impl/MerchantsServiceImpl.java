package com.avondrix.merchants.service.impl;

import com.alibaba.fastjson.JSON;
import com.avondrix.merchants.constant.Constants;
import com.avondrix.merchants.constant.ErrorCode;
import com.avondrix.merchants.dao.MerchantsDao;
import com.avondrix.merchants.entity.Merchants;
import com.avondrix.merchants.ov.CreateMerchantsRequest;
import com.avondrix.merchants.ov.CreateMerchantsResponse;
import com.avondrix.merchants.ov.PassTemplate;
import com.avondrix.merchants.ov.Response;
import com.avondrix.merchants.service.IMerchantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class MerchantsServiceImpl implements IMerchantsService {

    private final MerchantsDao merchantsDao;
    //    private final KafkaTemplate<String, String> kafkaTemplate;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public MerchantsServiceImpl(MerchantsDao merchantsDao, KafkaTemplate<String, String> kafkaTemplate) {
        this.merchantsDao = merchantsDao;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    @Transactional
    public Response createMerchants(CreateMerchantsRequest request) {
        Response response = new Response();
        CreateMerchantsResponse createMerchantsResponse = new CreateMerchantsResponse();

        ErrorCode errorCode = request.validate(merchantsDao);

        if (errorCode != ErrorCode.SUCCESS) {
            createMerchantsResponse.setId(-1);
            response.setErrorCode(errorCode.getCode());
            response.setErrorMsg(errorCode.getDesc());
        }else {
            createMerchantsResponse.setId(merchantsDao.save(request.toMerchants()).getId());
        }

        response.setData(createMerchantsResponse);
        return response;
    }

    @Override
    public Response buildMerchantsById(Integer id) {
        Response response = new Response();
        Optional<Merchants> merchants = merchantsDao.findById(id);

        if (!merchants.isPresent()){
            response.setErrorMsg(ErrorCode.MERCHANTS_NOT_EXIST.getDesc());
            response.setErrorCode(ErrorCode.MERCHANTS_NOT_EXIST.getCode());
        }else
            response.setData(merchants.get());
        return response;
    }

    @Override
    public Response dropPassTemplate(PassTemplate passTemplate) {
        Response response = new Response();
        ErrorCode errorCode = passTemplate.validate(merchantsDao);

        if (ErrorCode.SUCCESS != errorCode) {
            response.setErrorCode(ErrorCode.MERCHANTS_NOT_EXIST.getCode());
            response.setErrorMsg(ErrorCode.MERCHANTS_NOT_EXIST.getDesc());
        }else {
            String pass = JSON.toJSONString(passTemplate);
            kafkaTemplate.send(
                    Constants.TEMPLATE_TOPIC,
                    Constants.TEMPLATE_TOPIC,
                    pass
            );
        }
        return response;
    }
}
