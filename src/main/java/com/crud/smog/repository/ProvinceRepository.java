package com.crud.smog.repository;

import com.crud.smog.domain.ProvinceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface ProvinceRepository extends JpaRepository<ProvinceEntity, Long> {
    @Override
    ProvinceEntity save (ProvinceEntity provinceEntity);
    @Override
    Optional<ProvinceEntity> findById (Long id);
    @Override
    List<ProvinceEntity> findAll ();
    @Override
    void deleteById (Long id);
    @Query
    ProvinceEntity retrieveProvinceByName(@Param("PROVINCENAME") String provinceName);
}
