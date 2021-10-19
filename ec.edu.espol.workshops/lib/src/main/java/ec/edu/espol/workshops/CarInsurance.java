package ec.edu.espol.workshops;
import java.util.*;

enum MaritalStatus {married, not_married };

public class CarInsurance{

	private int age;
	private char gender;
	private MaritalStatus status;
	// Premium base
	private static double premiumBase= 500.0f;

	public CarInsurance(int age, char gender, MaritalStatus maritalStatus){
		this.age=age;
		this.gender=gender;
		this.status=maritalStatus;
	};


	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public MaritalStatus getStatus() {
		return status;
	}

	public void setStatus(MaritalStatus status) {
		this.status = status;
	}

	public static double getPremiumBase() {
		return premiumBase;
	}

	public static void setPremiumBase(double premiumBase) {
		CarInsurance.premiumBase = premiumBase;
	}

	@Override
	public String toString(){
		String mStatus = this.status == MaritalStatus.married? "Married": "Not Married";
		return String.format( "Age: " + this.age + " - Gender: " + this.gender + " - Status: " + mStatus );
	}

}
