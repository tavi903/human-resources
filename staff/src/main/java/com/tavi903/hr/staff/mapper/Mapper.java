package com.tavi903.hr.staff.mapper;

import java.util.List;

public interface Mapper<Entity, DTO> {

    DTO toDTO(Entity entity);
    Entity toEntity(DTO dto);

    default List<Entity> toEntities(List<DTO> dtos) {
        return dtos.stream().map(this::toEntity).toList();
    }

    default List<DTO> toDTOs(List<Entity> entities) {
        return entities.stream().map(this::toDTO).toList();
    }

}
