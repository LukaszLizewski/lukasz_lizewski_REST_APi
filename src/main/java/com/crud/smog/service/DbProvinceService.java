package com.crud.smog.service;

import com.crud.smog.domain.ProvinceEntity;
import com.crud.smog.domain.UserEntity;
import com.crud.smog.repository.ProvinceRepository;
import com.crud.smog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbProvinceService {
    @Autowired
    private ProvinceRepository provinceRepository;
    public ProvinceEntity saveProvinceEntity (final ProvinceEntity provinceEntity) {
        return provinceRepository.save(provinceEntity);
    }
    public Optional<ProvinceEntity> getProvince (final Long id) {
        return provinceRepository.findById(id);
    }
    public List<ProvinceEntity> getListOfProvinces () {
        return provinceRepository.findAll();
    }
    public void deleteProvince (final Long id) {
        provinceRepository.deleteById(id);
    }

}
