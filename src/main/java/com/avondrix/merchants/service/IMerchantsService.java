package com.avondrix.merchants.service;

import com.avondrix.merchants.ov.CreateMerchantsRequest;
import com.avondrix.merchants.ov.PassTemplate;
import com.avondrix.merchants.ov.Response;

public interface IMerchantsService {

    /** 创建商户 */
    Response createMerchants(CreateMerchantsRequest request);

    /** 获取商户信息 */
    Response buildMerchantsById(Integer id);

    /** 发放优惠券 */
    Response dropPassTemplate(PassTemplate passTemplate);
}
