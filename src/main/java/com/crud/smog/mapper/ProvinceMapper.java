package com.crud.smog.mapper;

import com.crud.smog.domain.ProvinceDto;
import com.crud.smog.domain.ProvinceEntity;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProvinceMapper {
    public ProvinceEntity mapToProvince (final ProvinceDto provinceDto) {
        return new ProvinceEntity(
                provinceDto.getId(),
                provinceDto.getProvinceName(),
                provinceDto.getCentralLongitude(),
                provinceDto.getCentralLatitude());
    }
    public ProvinceDto mapToProvinceDto (final ProvinceEntity provinceEntity) {
        return new ProvinceDto(
                provinceEntity.getId(),
                provinceEntity.getProvinceName(),
                provinceEntity.getCentralLongitude(),
                provinceEntity.getCentralLatitude());
    }
    public List<ProvinceDto> mapToProvinceListDto (final List<ProvinceEntity> provinceList) {
        return provinceList.stream()
                .map(e->new ProvinceDto(e.getId(),
                        e.getProvinceName(),
                        e.getCentralLongitude(),
                        e.getCentralLatitude()))
                .collect(Collectors.toList());
    }
}
