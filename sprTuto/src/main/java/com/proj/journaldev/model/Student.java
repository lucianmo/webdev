package com.proj.journaldev.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

//@Entity class denoted that the class is being mapped to a table with name 
@Entity
@Table(name="STUDENT")
public class Student implements Serializable {

   private static final long serialVersionUID = 1L;

   //@Id tells that the specified column is being used as a primary key in the table
   //@GeneratedValue makes the specified column a auto-increment field. 
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   @Column(name="STUDENT_ID")   
   private Integer studentId;
   
   @Column(name="STUDENT_NAME")
   private String  studentName;
   
   @Column(name="STUDENT_AGE")
   private String  studentAge;
   
   //@OneToOne(mappedBy = "student", cascade = CascadeType.ALL) tells that the particular column is being associated with 'Student' in a one to one relationship. 
   @OneToOne(mappedBy="student")
   @Cascade(value=org.hibernate.annotations.CascadeType.SAVE_UPDATE)
   private StudentInformation studentInfo;
   
   public Student() {}

   public Student(String studentName, String studentAge) {
      this.studentName = studentName;
      this.studentAge = studentAge;
   }


   public Integer getStudentId() {
      return this.studentId;
   }

   public void setStudentId(Integer studentId) {
      this.studentId = studentId;
   }

   public String getStudentName() {
      return this.studentName;
   }

   public void setStudentName(String studentName) {
      this.studentName = studentName;
   }

   public String getStudentAge() {
      return this.studentAge;
   }

   public void setStudentAge(String studentAge) {
      this.studentAge = studentAge;
   }

   public StudentInformation getStudentInfo() {
      return studentInfo;
   }

   public void setStudentInfo(StudentInformation studentInfo) {
      this.studentInfo = studentInfo;
   }

   public static long getSerialversionuid() {
      return serialVersionUID;
   }
   
}
