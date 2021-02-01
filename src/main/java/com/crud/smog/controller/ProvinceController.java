package com.crud.smog.controller;

import com.crud.smog.domain.ProvinceDto;
import com.crud.smog.domain.UserDto;
import com.crud.smog.mapper.ProvinceMapper;
import com.crud.smog.service.DbProvinceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/smog")
public class ProvinceController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private ProvinceMapper provinceMapper;
    @Autowired
    private DbProvinceService dbProvinceService;

    @RequestMapping(method = RequestMethod.GET, value = "/province/{provinceId}")
    public ProvinceDto getProvince (@PathVariable("provinceId") Long provinceId) throws ProvinceNotFoundException {
        LOGGER.info("ProvinceController -> getProvince; province's Id:" + provinceId);
        return provinceMapper.mapToProvinceDto(dbProvinceService.getProvince(provinceId).orElseThrow(ProvinceNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/province/")
    public List<ProvinceDto> getProvinces() {
        LOGGER.info("ProvinceController -> getProvinces");
        return provinceMapper.mapToProvinceListDto(dbProvinceService.getListOfProvinces());
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/province/deleteProvince/{provinceId}")
    public void deleteProvince(@PathVariable("provinceId") Long provinceId) {
        LOGGER.info("ProvinceController -> deleteProvince; province's Id:" + provinceId);
        dbProvinceService.deleteProvince(provinceId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/province/updateProvince", consumes = APPLICATION_JSON_VALUE)
    public ProvinceDto updateProvince(@RequestBody ProvinceDto provinceDto) {
        LOGGER.info("ProvinceController -> updated old Province;");
        return provinceMapper.mapToProvinceDto(dbProvinceService.saveProvinceEntity(provinceMapper.mapToProvince(provinceDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/province/createProvince", consumes = APPLICATION_JSON_VALUE)
    public void createProvince(@RequestBody ProvinceDto provinceDto) {
        dbProvinceService.saveProvinceEntity(provinceMapper.mapToProvince(provinceDto));
        LOGGER.info("ProvinceController -> created new Province: " + "\n" + "province's name: " + provinceDto.getProvinceName() + "\n" +
                "province's central longitude: " + provinceDto.getCentralLongitude() + "\n" +
                "province's central latitude: " + provinceDto.getCentralLatitude());
    }
}
