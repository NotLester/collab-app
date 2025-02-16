package com.pdc.masterdataservice.dto.request;

import com.pdc.masterdataservice.entities.Course;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Update Course request")
public class UpdateCourseDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "Course name is required")
    private String name;

    private String description;

    @NotNull(message = "Credits are required")
    @Min(value = 1, message = "Credits must be at least 1")
    private Integer credits;

    @Min(value = 1, message = "Semester must be at least 1")
    private Integer semester;

    @NotNull(message = "Academic year is required")
    @Min(value = 2000, message = "Invalid academic year")
    private Integer academicYear;

    @NotNull(message = "Status is required")
    private Course.CourseStatus status;
}