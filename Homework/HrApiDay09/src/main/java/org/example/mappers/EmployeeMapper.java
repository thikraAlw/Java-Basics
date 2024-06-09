package org.example.mappers;

import org.example.dto.EmployeeDto;
import org.example.models.Employee;
import org.example.models.Job;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {JobMapper.class}, imports = {java.util.UUID.class})
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    @BeforeMapping
    static void validate(Employee e) {
        System.out.println("VALIDATE");
        if (e.getFirstName() != null) {
            e.setFirstName(e.getFirstName().toUpperCase());
        }
    }

    @AfterMapping
    static void doAfter(@MappingTarget EmployeeDto dto) {
        System.out.println("Do Something After");

    }


    @Mapping(source = "employeeId", target = "employeeId")
    @Mapping(source = "firstName", target = "firstName", defaultValue = "No Name")
//    @Mapping(constant = "Data Hidden", target = "deptName")
//    @Mapping(source = "lastName", target = "lastName", defaultExpression = "java((int)(Math.random() * 4))")
//    @Mapping(expression = "java((int)(Math.random() * 4))", target = "locId")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "phone_number", target = "phone_number")
    @Mapping(source = "hireDate", target = "hireDate")
    @Mapping(source = "jobId", target = "jobId")
    @Mapping(source = "salary", target = "salary")
    @Mapping(source = "manager_id", target = "manager_id")
    @Mapping(source = "departmentId", target = "departmentId")
//    @Mapping(source = "location.locationId", target = "loc.locationId")
//    @Mapping(source = "location.city", target = "loc.city")
    EmployeeDto toEmplDto(Employee e);

    @Mapping(source = "e.employeeId", target = "employeeId")
    @Mapping(source = "e.firstName", target = "firstName")
    @Mapping(source = "e.lastName", target = "lastName")
    @Mapping(source = "e.email", target = "email")
    @Mapping(source = "e.phone_number", target = "phone_number")
    @Mapping(source = "e.hireDate", target = "hireDate")
    @Mapping(source = "e.jobId", target = "jobId")
    @Mapping(source = "e.salary", target = "salary")
    @Mapping(source = "e.manager_id", target = "manager_id")
    @Mapping(source = "e.departmentId", target = "departmentId")
//    @InheritConfiguration
    EmployeeDto toEmplDto(Employee e, Job j);

    @Mapping(source = "employeeId", target = "employeeId")
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "phone_number", target = "phone_number")
    @Mapping(source = "hireDate", target = "hireDate")
    @Mapping(source = "jobId", target = "jobId")
    @Mapping(source = "salary", target = "salary")
    @Mapping(source = "manager_id", target = "manager_id")
    @Mapping(source = "departmentId", target = "departmentId")
//    @InheritInverseConfiguration
    Employee toModel(EmployeeDto dto);

}
