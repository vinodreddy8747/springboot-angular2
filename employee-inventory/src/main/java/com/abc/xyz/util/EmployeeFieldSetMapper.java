package com.abc.xyz.util;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.abc.xyz.model.Employee;

@Component
public class EmployeeFieldSetMapper implements FieldSetMapper<Employee> {

    @Override
    public Employee mapFieldSet(FieldSet fieldSet) {
        final Employee emp = new Employee();
        emp.setName(fieldSet.readString("name"));
        String ageStr = fieldSet.readString("age");
        emp.setAge(StringUtils.isEmpty(ageStr) ? 0 : Integer.parseInt(ageStr));
        return emp;

    }
}