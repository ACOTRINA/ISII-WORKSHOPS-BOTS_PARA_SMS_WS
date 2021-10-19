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

	
	
	
	public static void main (String[] args) {

		Scanner sc = new Scanner(System.in);
		CarInsurance request = null;

		boolean validData = false;

		while(!validData){

			try {
				System.out.print("Ingrese la edad: ");
				String age = sc.next();
				System.out.print("Ingrese el genero(M o F): ");
				String gender = sc.next();
				System.out.print("Ingrese el estado ( Casado o No Casado): ");
				String status = sc.next();

				boolean validGender = gender.charAt(0) == 'M' || gender.charAt(0) == 'F';
				boolean validStatus = status == "Casado" || status == "No Casado";

				if(!validStatus && !validGender) throw new Exception();

				request = new CarInsurance(Integer.parseInt(age), gender.charAt(0), status=="Casado"?MaritalStatus.married:MaritalStatus.not_married);
				
				validData = true;

			} catch(Exception e){
				System.out.println("Datos incorrectos");
			}

		}


		// Imprime el objeto
		System.out.println(request);
		System.out.println(request.computePremium());

	}

	// Funciones del taller
	public double computePremium(){

		double totalPremium = this.premiumBase;

		switch(this.gender){
			case 'M':
				if(this.status==MaritalStatus.not_married){
					if(this.age<25){
						totalPremium += 1500.0f;
					}else{
						break;
					}
				}else{
					totalPremium -= 200.0f;
				}
				break;
			case 'F':
				if(this.status == MaritalStatus.not_married){
					break;
				}else{
					totalPremium -=200.0f;
				}
				break;
		}

		if(this.age>=45 && this.age<65){
			totalPremium = this.premiumBase - 100.0f;
		}else if(this.age>80){
			return -1;
		}

		return totalPremium;
	}
	
	
	
	
	
	

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
