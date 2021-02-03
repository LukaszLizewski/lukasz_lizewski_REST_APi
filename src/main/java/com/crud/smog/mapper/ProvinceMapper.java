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
                provinceDto.getCentralLatitude(),
                provinceDto.getLongitudeNW(),
                provinceDto.getLatitudeNW(),
                provinceDto.getLongitudeNE(),
                provinceDto.getLatitudeNE(),
                provinceDto.getLongitudeSE(),
                provinceDto.getLatitudeSE(),
                provinceDto.getLongitudeSW(),
                provinceDto.getLatitudeSW()
        );
    }
    public ProvinceDto mapToProvinceDto (final ProvinceEntity provinceEntity) {
        return new ProvinceDto(
                provinceEntity.getId(),
                provinceEntity.getProvinceName(),
                provinceEntity.getCentralLongitude(),
                provinceEntity.getCentralLatitude(),
                provinceEntity.getLongitudeNW(),
                provinceEntity.getLatitudeNW(),
                provinceEntity.getLongitudeNE(),
                provinceEntity.getLatitudeNE(),
                provinceEntity.getLongitudeSE(),
                provinceEntity.getLatitudeSE(),
                provinceEntity.getLongitudeSW(),
                provinceEntity.getLatitudeSW());
    }
    public List<ProvinceDto> mapToProvinceListDto (final List<ProvinceEntity> provinceList) {
        return provinceList.stream()
                .map(e->new ProvinceDto(e.getId(),
                        e.getProvinceName(),
                        e.getCentralLongitude(),
                        e.getCentralLatitude(),
                        e.getLongitudeNW(),
                        e.getLatitudeNW(),
                        e.getLongitudeNE(),
                        e.getLatitudeNE(),
                        e.getLongitudeSE(),
                        e.getLatitudeSE(),
                        e.getLongitudeSW(),
                        e.getLatitudeSW()))
                .collect(Collectors.toList());
    }
}
