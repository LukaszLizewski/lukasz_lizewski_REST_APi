package com.crud.smog.repository;

import com.crud.smog.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Override
    UserEntity save (UserEntity userEntity);
    @Override
    Optional<UserEntity> findById (Long id);
    @Override
    List<UserEntity> findAll ();
    @Override
    void deleteById (Long id);
}
