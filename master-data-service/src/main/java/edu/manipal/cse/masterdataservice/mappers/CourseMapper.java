package edu.manipal.cse.masterdataservice.mappers;

import edu.manipal.cse.masterdataservice.dto.response.CourseDto;
import edu.manipal.cse.masterdataservice.dto.request.CreateCourseDto;
import edu.manipal.cse.masterdataservice.dto.request.UpdateCourseDto;
import edu.manipal.cse.masterdataservice.entities.Course;
import edu.manipal.cse.masterdataservice.entities.Specialization;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class CourseMapper {

    private final ModelMapper modelMapper;

    public CourseDto toDto(Course course) {
        return modelMapper.map(course, CourseDto.class);
    }

    public Course toEntity(CreateCourseDto dto, Specialization specialization) {
        Course course = modelMapper.map(dto, Course.class);
        course.setSpecialization(specialization);
        course.setStatus(Course.CourseStatus.ACTIVE);
        log.info("Course : {}", course);
        return course;
    }

    public void updateEntityFromDto(UpdateCourseDto dto, Course course) {
        modelMapper.map(dto, course);
    }

    public List<CourseDto> toDtoList(List<Course> courses) {
        return courses.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
