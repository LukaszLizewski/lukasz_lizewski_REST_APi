package com.crud.smog.repository;

import com.crud.smog.domain.ProvinceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProvinceRepository extends JpaRepository<ProvinceEntity, Long> {
    @Override
    ProvinceEntity save (ProvinceEntity provinceEntity);
    @Override
    Optional<ProvinceEntity> findById (Long id);
    @Override
    List<ProvinceEntity> findAll ();
    @Override
    void deleteById (Long id);
}
