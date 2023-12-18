package com.zx.model;

import java.io.Serializable;


public class Student implements Serializable {
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private int age;
    /**
     * 性别
     */
    private String gender;
    /**
     * 班级
     */
    private String className;
    /**
     * 年级
     */
    private String grade;
    /**
     * 学校名称
     */
    private String schoolName;

    public Student() {
    }

    public Student(String name, int age, String gender, String className, String grade, String schoolName) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.className = className;
        this.grade = grade;
        this.schoolName = schoolName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", className='" + className + '\'' +
                ", grade='" + grade + '\'' +
                ", schoolName='" + schoolName + '\'' +
                '}';
    }
}
