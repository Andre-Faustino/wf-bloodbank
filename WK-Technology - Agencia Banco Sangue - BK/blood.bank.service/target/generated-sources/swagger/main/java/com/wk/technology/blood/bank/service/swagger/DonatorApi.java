/**
 * NOTE: This class is auto generated by the swagger code generator program (2.3.1).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.wk.technology.blood.bank.service.swagger;

import com.wk.technology.blood.bank.service.swagger.models.AvgAgeByBlood;
import com.wk.technology.blood.bank.service.swagger.models.AvgIMCByAge;
import com.wk.technology.blood.bank.service.swagger.models.DonatorByReceptorBlood;
import com.wk.technology.blood.bank.service.swagger.models.DonatorDTO;
import com.wk.technology.blood.bank.service.swagger.models.DonatorDTOlist;
import com.wk.technology.blood.bank.service.swagger.models.DonatorsByState;
import com.wk.technology.blood.bank.service.swagger.models.GenderOverweight;
import com.wk.technology.blood.bank.service.swagger.models.ResponseMessage;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-07-11T22:34:21.360-03:00")

@Api(value = "donator", description = "the donator API")
public interface DonatorApi {

    @ApiOperation(value = "Insert Donator", nickname = "addDonator", notes = "", response = ResponseMessage.class, tags={ "donator", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = ResponseMessage.class),
        @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/donator",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<ResponseMessage> addDonator(@ApiParam(value = "JSON object with donator's data" ,required=true )  @Valid @RequestBody DonatorDTO body);


    @ApiOperation(value = "Insert Donators", nickname = "addDonatorList", notes = "", response = ResponseMessage.class, tags={ "donator", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = ResponseMessage.class),
        @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/donator/batch",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<ResponseMessage> addDonatorList(@ApiParam(value = "JSON object with donator's data" ,required=true )  @Valid @RequestBody DonatorDTOlist body);


    @ApiOperation(value = "Average Age by BloodType", nickname = "avgAgeByBlood", notes = "", response = AvgAgeByBlood.class, responseContainer = "List", tags={ "donator", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = AvgAgeByBlood.class, responseContainer = "List") })
    @RequestMapping(value = "/donator/age",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<List<AvgAgeByBlood>> avgAgeByBlood(@ApiParam(value = "Specifies Blood Type") @Valid @RequestParam(value = "blood", required = false) String blood);


    @ApiOperation(value = "Average IMC by Age Range", nickname = "avgIMCByAgeRange", notes = "", response = AvgIMCByAge.class, responseContainer = "List", tags={ "donator", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = AvgIMCByAge.class, responseContainer = "List") })
    @RequestMapping(value = "/donator/imc",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<List<AvgIMCByAge>> avgIMCByAgeRange(@ApiParam(value = "Specifies Range Age", defaultValue = "10") @Valid @RequestParam(value = "rangeAge", required = false, defaultValue="10") String rangeAge);


    @ApiOperation(value = "Overweight Between Genders", nickname = "avgOverweightByGenders", notes = "", response = GenderOverweight.class, responseContainer = "List", tags={ "donator", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = GenderOverweight.class, responseContainer = "List") })
    @RequestMapping(value = "/donator/imc/overweight",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<List<GenderOverweight>> avgOverweightByGenders();


    @ApiOperation(value = "Quantity of Donators for each blood receptor", nickname = "donatorsAmountByReceptorBlood", notes = "", response = DonatorByReceptorBlood.class, responseContainer = "List", tags={ "donator", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = DonatorByReceptorBlood.class, responseContainer = "List") })
    @RequestMapping(value = "/donator/receptorblood",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<List<DonatorByReceptorBlood>> donatorsAmountByReceptorBlood(@ApiParam(value = "Specifies Blood Type") @Valid @RequestParam(value = "blood", required = false) String blood);


    @ApiOperation(value = "Donators By State", nickname = "donatorsByState", notes = "", response = DonatorsByState.class, responseContainer = "List", tags={ "donator", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = DonatorsByState.class, responseContainer = "List") })
    @RequestMapping(value = "/donator/states",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<List<DonatorsByState>> donatorsByState(@ApiParam(value = "Find Specific State") @Valid @RequestParam(value = "name", required = false) String name);

}