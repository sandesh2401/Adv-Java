package com.cruddemo.model;

public class Student {
		private int id;
		private String name;
		private String phone;
		private float marks;
		
		public Student() {
			// TODO Auto-generated constructor stub
		}

		public Student(int id, String name, String phone, float marks) {
			super();
			this.id = id;
			this.name = name;
			this.phone = phone;
			this.marks = marks;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public float getMarks() {
			return marks;
		}

		public void setMarks(float marks) {
			this.marks = marks;
		}

		@Override
		public String toString() {
			return "Student [id=" + id + ", name=" + name + ", phone=" + phone + ", marks=" + marks + "]";
		}
		
		
}
