package com.example.demo;

public class TestStub {

	private String name;
	private int age;
	private long phone;
	private String address;
	private int recodNo;
	private String gender;

	public  TestStub() {

		this.name = "Arun";
		this.age=22;
		this.address="Puthuparambil";
		
	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public int getRecodNo() {
		return recodNo;
	}

	public void setRecodNo(int recodNo) {
		this.recodNo = recodNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
