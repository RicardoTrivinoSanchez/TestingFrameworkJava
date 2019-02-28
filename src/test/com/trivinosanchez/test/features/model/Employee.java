package com.trivinosanchez.test.features.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private String name, salary, durationWorked, grade, email;

    public static Employee autogenerate() {
        return new Employee("John", "20000", "54", "2", "john@test.com");
    }

    public boolean compare(Employee other) {
        return this.name.equals(other.name)
            && this.salary.equals(other.salary)
            && this.durationWorked.equals(other.durationWorked)
            && this.grade.equals(other.grade)
            && this.email.equals(other.email);
    }
}
