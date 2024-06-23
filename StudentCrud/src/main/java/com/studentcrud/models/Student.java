package com.studentcrud.models;

public class Student {
	private int id;
	   private String name;
	   private String phone;
	   private String gender;
	   private float marks;
	   private String city;

	   public Student() {
	   }

	   public Student(int id, String name, String phone, String gender, float marks, String city) {
	      this.id = id;
	      this.name = name;
	      this.phone = phone;
	      this.gender = gender;
	      this.marks = marks;
	      this.city = city;
	   }

	   public int getId() {
	      return this.id;
	   }

	   public void setId(int id) {
	      this.id = id;
	   }

	   public String getName() {
	      return this.name;
	   }

	   public void setName(String name) {
	      this.name = name;
	   }

	   public String getPhone() {
	      return this.phone;
	   }

	   public void setPhone(String phone) {
	      this.phone = phone;
	   }

	   public String getGender() {
	      return this.gender;
	   }

	   public void setGender(String gender) {
	      this.gender = gender;
	   }

	   public float getMarks() {
	      return this.marks;
	   }

	   public void setMarks(float marks) {
	      this.marks = marks;
	   }

	   public String getCity() {
	      return this.city;
	   }

	   public void setCity(String city) {
	      this.city = city;
	   }
}
