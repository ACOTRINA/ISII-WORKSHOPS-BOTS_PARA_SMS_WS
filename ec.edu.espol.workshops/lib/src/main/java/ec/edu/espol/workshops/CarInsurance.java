package ec.edu.espol.workshops;

import java.util.*;
/**
* Marital Status
*
* @author Enrique Yugcha
*/

enum MaritalStatus {
    married, not_married}


/**
* Class Car Insurance
*
* @author Enrique Yugcha
*/
public class CarInsurance {
   /**
    * Variable age in class car insurance
    */
  private int age;
  /**
   * Variable gender in class car insurance
   */
  private char gender;
  /**
   * Variable marital status in class car insurance
   * 
   * @author Enrique Yugcha
   */
  private MaritalStatus status;
  // Premium base
  private static double premiumBase = 500.0f;
  
  /**
   * Constructor method of the class Car Insurance
   *
   * @author Enrique Yugcha
   */
  public CarInsurance(int age, char gender, MaritalStatus maritalStatus) {
    this.age = age;
    this.gender = gender;
    this.status = maritalStatus;
  }
  ;
  
  /**
   * Method main in class car insurance
   * 
   * @author Enrique Yugcha
   */
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    CarInsurance request = null;

    boolean validData = false;

    while (!validData) {

      try {
        System.out.print("Enter your age: ");
        String age = sc.next();
        System.out.print("Enter your gender(M o F): ");
        String gender = sc.next();
        System.out.print("Enter your marital status (Married or Not Married): ");
        String status = sc.next();

        boolean validGender = gender.charAt(0) == 'M' || gender.charAt(0) == 'F';
        boolean validStatus = "Married".equals(status) || "Not married".equals(status);

        if (!validStatus && !validGender) {
          throw new Exception();    
        }
          
        request = new CarInsurance(Integer.parseInt(age), gender.charAt(0), status.equals("Married")?MaritalStatus.married:MaritalStatus.not_married);

        validData = true;

      } catch (Exception e) {
        System.out.println("Incorrect data");
      }

    }

    //Prints the object
    System.out.println(request);
    System.out.println(request.computePremium());

  }

  //Workshop functions
  public double computePremium() {

    double totalPremium = this.premiumBase;

    switch (this.gender) {
      case 'M':
        if (this.status == MaritalStatus.not_married) {
          if (this.age < 25) {
            totalPremium += 1500.0f;
          } else {
            break;
          }
        } else {
          totalPremium -= 200.0f;
        }
        break;
      case 'F':
        if (this.status == MaritalStatus.not_married) {
          break;
        } else {
          totalPremium -= 200.0f;
        }
        break;
    }

    if (this.age >= 45 && this.age < 65) {
      totalPremium = this.premiumBase - 100.0f;
      //Modification of Empirical Test 001
    } else if (this.age > 80 || this.age <= 0) {
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
  public String toString() {
    String mStatus = this.status == MaritalStatus.married ? "Married" : "Not Married";
    return String.format("Age: " + this.age + " - Gender: " + this.gender + " - Status: " + mStatus);
  }

}