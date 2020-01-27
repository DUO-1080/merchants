package com.avondrix.merchants.ov;

import com.avondrix.merchants.constant.ErrorCode;
import com.avondrix.merchants.dao.MerchantsDao;
import com.avondrix.merchants.entity.Merchants;
import org.springframework.util.StringUtils;

public class CreateMerchantsRequest {
    private String name;
    private String logoUrl;
    private String businessLicenseUrl;
    private String phone;
    private String address;

    public ErrorCode validate(MerchantsDao merchantsDao) {
        if (StringUtils.isEmpty(name)) {
            return ErrorCode.EMPTY_NAME;
        }
        if (null != merchantsDao.findByName(name)) {
            return ErrorCode.DUPLICATE_NAME;
        }
        if (StringUtils.isEmpty(logoUrl)) {
            return ErrorCode.EMPTY_LOGO;
        }
        if (StringUtils.isEmpty(businessLicenseUrl)) {
            return ErrorCode.EMPTY_BUSINESS_LICENSE;
        }
        if (StringUtils.isEmpty(phone)) {
            return ErrorCode.ERROR_PHONE;
        }
        if (StringUtils.isEmpty(address)) {
            return ErrorCode.EMPTY_ADDRESS;
        }
        return ErrorCode.SUCCESS;
    }

    public Merchants toMerchants() {
        Merchants merchants = new Merchants();
        merchants.setName(name);
        merchants.setLogoUrl(logoUrl);
        merchants.setBusinessLicenseUrl(businessLicenseUrl);
        merchants.setPhone(phone);
        merchants.setAddress(address);
        return merchants;
    }

    public CreateMerchantsRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getBusinessLicenseUrl() {
        return businessLicenseUrl;
    }

    public void setBusinessLicenseUrl(String businessLicenseUrl) {
        this.businessLicenseUrl = businessLicenseUrl;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
