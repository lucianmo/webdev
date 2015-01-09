package com.proj.journaldev.model;

import java.util.Date;

import javax.persistence.Column;  
import javax.persistence.Entity;  
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;  
import javax.persistence.Id;  
import javax.persistence.OneToOne;  
import javax.persistence.PrimaryKeyJoinColumn;  
import javax.persistence.Table;  
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;  
import org.hibernate.annotations.Parameter; 

@Entity  
@Table(name="student_information") 
public class StudentInformation {

   private Integer studentId;
   private String address;
   private String registryNumber;
   private String phoneNumber;
   private Date enlisted;

   private Student student;
   
   public StudentInformation() {}

   @GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "student"))
   @Id
   @GeneratedValue(generator = "generator")
   @Column(name = "STUDENT_ID", unique = true, nullable = false)
   public Integer getStudentId() {
      return studentId;
   }

   public void setStudentId(Integer studentId) {
      this.studentId = studentId;
   }

   @Column(name = "ADDRESS", nullable = false, length = 100)
   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   @Column(name = "REGISTRY_NUMBER", length = 255)
   public String getRegistryNumber() {
      return registryNumber;
   }

   public void setRegistryNumber(String registryNumber) {
      this.registryNumber = registryNumber;
   }

   @Column(name = "PHONE_NUMBER", length = 255)
   public String getPhoneNumber() {
      return phoneNumber;
   }

   public void setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
   }

   @Temporal(TemporalType.DATE)
   @Column(name = "ENLISTED", nullable = false)
   public Date getEnlisted() {
      return enlisted;
   }

   public void setEnlisted(Date enlisted) {
      this.enlisted = enlisted;
   }

   @OneToOne(fetch = FetchType.LAZY)
   @PrimaryKeyJoinColumn
   public Student getStudent() {
      return student;
   }

   public void setStudent(Student student) {
      this.student = student;
   }

   @Override
   public String toString() {
      return "StudentInformation [studentId=" + studentId + ", address="
            + address + ", registryNumber=" + registryNumber + ", phoneNumber="
            + phoneNumber + ", enlisted=" + enlisted + ", student=" + student
            + "]";
   }
   
}
