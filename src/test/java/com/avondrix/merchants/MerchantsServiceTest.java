package com.avondrix.merchants;

import com.alibaba.fastjson.JSON;
import com.avondrix.merchants.ov.CreateMerchantsRequest;
import com.avondrix.merchants.ov.PassTemplate;
import com.avondrix.merchants.ov.Response;
import com.avondrix.merchants.service.IMerchantsService;
import org.apache.commons.lang.time.DateUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class MerchantsServiceTest {

    @Autowired
    IMerchantsService merchantsService;

    /** 测试 CreateMerchantsService，添加事务后，测试用例对于数据库的更改将在测试结束后回滚。 */
    @Test
    @Transactional
    public void CreateMerchantsServiceTest() {
        CreateMerchantsRequest createMerchantsRequest = new CreateMerchantsRequest();
        createMerchantsRequest.setName("The Second");
        createMerchantsRequest.setAddress("Here");
        createMerchantsRequest.setBusinessLicenseUrl("Some License");
        createMerchantsRequest.setLogoUrl("a logo");
        createMerchantsRequest.setPhone("12312390");
        Response merchants = merchantsService.createMerchants(createMerchantsRequest);
        System.out.println(JSON.toJSONString(merchants));
    }

    @Test
    public void buildMerchantsByIdTest() {
        System.out.println(JSON.toJSONString(merchantsService.buildMerchantsById(17)));
    }

    @Test
    public void dropPassTemplate() {
        PassTemplate passTemplate = new PassTemplate();
        passTemplate.setId(17);
        passTemplate.setTitle("pass title");
        passTemplate.setDesc("pass desc");
        passTemplate.setLimit(120L);
        passTemplate.setHasToken(false);
        passTemplate.setBackground(2);
        passTemplate.setStart(new Date());
        passTemplate.setEnd(DateUtils.addDays(new Date(), 10));
        System.out.println(
                JSON.toJSONString(
                        merchantsService.dropPassTemplate(passTemplate)
                )
        );

    }
}
