package com.crud.smog.mapper;

import com.crud.smog.domain.UserDto;
import com.crud.smog.domain.UserEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    public UserEntity mapToUser (final UserDto userDto) {
        return new UserEntity(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getAddressCity(),
                userDto.getAddressStreet(),
                userDto.getAddressProvince());
    }
    public UserDto mapToUserDto (final UserEntity userEntity) {
        return new UserDto(
                userEntity.getId(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getAddressCity(),
                userEntity.getAddressStreet(),
                userEntity.getAddressProvince());
    }
    public List<UserDto> mapToUserListDto (final List<UserEntity> usersList) {
        return usersList.stream()
                .map(e->new UserDto(e.getId(),
                                       e.getFirstName(),
                                       e.getLastName(),
                                       e.getAddressCity(),
                                       e.getAddressStreet(),
                                       e.getAddressProvince()))
                .collect(Collectors.toList());
    }
}
