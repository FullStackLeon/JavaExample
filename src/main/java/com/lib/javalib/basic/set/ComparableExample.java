package com.lib.javalib.basic.set;

import com.sun.tracing.dtrace.ArgsAttributes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
class Student implements Comparable<Student>{
    private String name;
    private int mathGrade;
    private int chineseGrade;


    @Override
    public int compareTo(Student o) {
        return (this.mathGrade + chineseGrade) - (o.mathGrade + o.chineseGrade);
    }

    public static String operatorCovert(int result) {
        if (result > 0) return ">";
        else if (result == 0) return "=";
        else return "<";
    }
}

@Slf4j
public class ComparableExample {
    public static void main(String[] args) {
        Student stu1 = new Student("Li",100,99);
        Student stu2 = new Student("Zhang",99,95);

        log.debug("Student {}'s grade {} {}'s grade", stu1.getName(), Student.operatorCovert(stu1.compareTo(stu2)) , stu2.getName());
    }
}
