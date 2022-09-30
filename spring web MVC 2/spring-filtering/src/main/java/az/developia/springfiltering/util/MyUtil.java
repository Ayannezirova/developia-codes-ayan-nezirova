package az.developia.springfiltering.util;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.converter.json.MappingJacksonValue;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import az.developia.springfiltering.dto.StudentDTO;
import az.developia.springfiltering.model.Student;

public class MyUtil {

	public static List<StudentDTO> dtos(List<Student> students, ModelMapper mapper) {
		List<StudentDTO> studentDtos = new ArrayList<StudentDTO>();
		for (Student st : students) {
			StudentDTO dto = new StudentDTO();
			mapper.map(st, dto);
			studentDtos.add(dto);
		}
		return studentDtos;
	}

	public static MappingJacksonValue filter(Object data, String dto, String... properties) {

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(properties);
		FilterProvider provider = new SimpleFilterProvider().addFilter(dto, filter);

		MappingJacksonValue value = new MappingJacksonValue(data);
		value.setFilters(provider);
		return value;
	}
}
