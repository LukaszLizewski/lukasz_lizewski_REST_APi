package com.crud.smog.repository;

import com.crud.smog.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    @Override
    UserEntity save (UserEntity userEntity);
    @Override
    Optional<UserEntity> findById (Long id);
    @Override
    List<UserEntity> findAll ();
    @Override
    void deleteById (Long id);
    @Override
    long count();
    @Query
    UserEntity retrieveUserById(@Param("USERID") Long userId);
}
