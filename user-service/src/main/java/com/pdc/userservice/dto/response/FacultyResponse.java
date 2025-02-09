package com.pdc.userservice.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pdc.userservice.entities.enums.Position;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FacultyResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private UUID facultyId;
    private UUID schoolId;
    private String email;
    private String name;
    private Position position;
    //    private SchoolDTO school;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;
}