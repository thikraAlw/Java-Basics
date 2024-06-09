package org.example.mappers;

import org.example.dto.JobDto;
import org.example.models.Job;
import org.mapstruct.Mapper;

@Mapper
public interface JobMapper {

    JobDto toLocDto(Job j);

    Job toModel(JobDto dto);

}
