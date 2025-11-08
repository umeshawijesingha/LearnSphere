package com.learnsphere.learnsphere.mapper;

import com.learnsphere.learnsphere.dto.TeacherResponse;
import com.learnsphere.learnsphere.entity.Teacher;

public interface Mapper<E, Req, Res> {

    // Convert DTO -> Entity
    E toEntity(Req request);

    // Convert Entity -> DTO
    Res toResponse(E entity);
}
