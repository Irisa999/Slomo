/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.34).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.slomoproject.myapp.web.rest;

import com.slomoproject.myapp.domain.Shop;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;


@Validated
public interface ShopApi {

    @Operation(summary = "Add a new shop to the store", description = "", tags={ "shop" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successful operation"),

        @ApiResponse(responseCode = "405", description = "Invalid input") })
    @RequestMapping(value = "/shop",
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> addShop(@Parameter(in = ParameterIn.DEFAULT, description = "Create a new shop in the store", required=true, schema=@Schema()) @Valid @RequestBody Shop body);


    @Operation(summary = "Deletes a shop", description = "", tags={ "shop" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Success"),

        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),

        @ApiResponse(responseCode = "404", description = "Shop not found") })
    @RequestMapping(value = "/shop/{shopId}",
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteshop(@Parameter(in = ParameterIn.PATH, description = "ID of shop to return", required=true, schema=@Schema()) @PathVariable("shopId") String shopId);


    @Operation(summary = "Finds Shops by city", description = "", tags={ "shop" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "successful operation"),

        @ApiResponse(responseCode = "400", description = "Invalid status value") })
    @RequestMapping(value = "/shop/find/{city}",
        method = RequestMethod.GET)
    ResponseEntity<List<Shop>> findShopByCity(@Parameter(in = ParameterIn.PATH, description = "Status values that need to be considered for filter", required=true, schema=@Schema()) @PathVariable("city") String city);


    @Operation(summary = "Find shop by ID", description = "Returns a single shop", tags={ "shop" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Shop.class))),

        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),

        @ApiResponse(responseCode = "404", description = "Shop not found") })
    @RequestMapping(value = "/shop/{shopId}",
        produces = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<Shop> getShopById(@Parameter(in = ParameterIn.PATH, description = "ID of Shop to return", required=true, schema=@Schema()) @PathVariable("shopId") String shopId);


    @Operation(summary = "Updates a shop", description = "", tags={ "shop" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Shop.class))),

        @ApiResponse(responseCode = "405", description = "Invalid input") })
    @RequestMapping(value = "/shop/{shopId}",
        produces = { "application/json" },
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Shop> updateShop(@Parameter(in = ParameterIn.PATH, description = "ID of shop to return", required=true, schema=@Schema()) @PathVariable("shopId") String shopId, @Parameter(in = ParameterIn.DEFAULT, description = "Create a new shop in the store", required=true, schema=@Schema()) @Valid @RequestBody Shop body);


    @Operation(summary = "Deletes a shop", description = "", tags={ "shop" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Success"),

        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),

        @ApiResponse(responseCode = "404", description = "Shop not found") })
    @RequestMapping(value = "/shop/{shopId}",
        method = RequestMethod.PUT)
    ResponseEntity<Void> validateShop(@Parameter(in = ParameterIn.PATH, description = "ID of shop to return", required=true, schema=@Schema()) @PathVariable("shopId") String shopId);

}

