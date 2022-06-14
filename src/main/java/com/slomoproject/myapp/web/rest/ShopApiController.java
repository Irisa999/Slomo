package com.slomoproject.myapp.web.rest;

import com.slomoproject.myapp.domain.Shop;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.slomoproject.myapp.service.ShopService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class ShopApiController implements ShopApi {

    private static final Logger log = LoggerFactory.getLogger(ShopApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    ShopService shopService;

    @org.springframework.beans.factory.annotation.Autowired
    public ShopApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> addShop(@Parameter(in = ParameterIn.DEFAULT, description = "Create a new shop in the store", required=true, schema=@Schema()) @Valid @RequestBody Shop body) {
        shopService.createShop(body);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteshop(@Parameter(in = ParameterIn.PATH, description = "ID of shop to return", required=true, schema=@Schema()) @PathVariable("shopId") String shopId) {
        shopService.deleteShop(shopId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<List<Shop>> findShopByCity(@Parameter(in = ParameterIn.PATH, description = "Status values that need to be considered for filter", required=true, schema=@Schema()) @PathVariable("city") String city) {
        return new ResponseEntity<List<Shop>>(shopService.findByCity(city),HttpStatus.OK);
    }

    public ResponseEntity<Shop> getShopById(@Parameter(in = ParameterIn.PATH, description = "ID of Shop to return", required=true, schema=@Schema()) @PathVariable("shopId") String shopId) {
            return new ResponseEntity<Shop>(shopService.findById(shopId), HttpStatus.OK);
    }

    public ResponseEntity<Shop> updateShop(@Parameter(in = ParameterIn.PATH, description = "ID of shop to return", required=true, schema=@Schema()) @PathVariable("shopId") String shopId,@Parameter(in = ParameterIn.DEFAULT, description = "Create a new shop in the store", required=true, schema=@Schema()) @Valid @RequestBody Shop body) {
                return new ResponseEntity<Shop>(shopService.updateShop(shopId,body), HttpStatus.OK);
    }

    public ResponseEntity<Void> validateShop(@Parameter(in = ParameterIn.PATH, description = "ID of shop to return", required=true, schema=@Schema()) @PathVariable("shopId") String shopId) {
        shopService.validate(shopId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
