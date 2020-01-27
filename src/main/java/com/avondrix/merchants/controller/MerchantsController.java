package com.avondrix.merchants.controller;

import com.avondrix.merchants.ov.CreateMerchantsRequest;
import com.avondrix.merchants.ov.PassTemplate;
import com.avondrix.merchants.ov.Response;
import com.avondrix.merchants.service.IMerchantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("merchants")
public class MerchantsController {

    private final IMerchantsService service;

    @Autowired
    public MerchantsController(IMerchantsService service) {
        this.service = service;
    }

    @PostMapping("create")
    public Response createMerchants(@RequestBody CreateMerchantsRequest request) {
        return service.createMerchants(request);
    }

    @GetMapping("{id}")
    public Response buildMerchantsInfo(@PathVariable Integer id) {
        return service.buildMerchantsById(id);
    }

    @PostMapping("pass")
    public Response dropPassTemplate(@RequestBody PassTemplate passTemplate) {
        return service.dropPassTemplate(passTemplate);
    }
}
