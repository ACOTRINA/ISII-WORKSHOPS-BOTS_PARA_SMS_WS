package ec.edu.espol.workshops;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;

import static org.junit.Assert.*;

public class StepsDefs {
    private double actualAnswer;
    private double actualAnswer1;
    public CarInsurance carInsurance = new CarInsurance(); 
    
    @Given("customer is 85 years old")
    public void customer_over_eighty() {
        carInsurance.setAge(85);
    }
 
     @When("i calculate the premium")
     public void i_calculate_the_premium() {
     actualAnswer = carInsurance.computePremium();
     }
 
     @Then("show -1")
     public void i_should_be_shown() {
         assertEquals(-1, actualAnswer, 0);
     } 
    
     @Given("customer is male")
     public void customer_is_male() {
         carInsurance.setGender('M');
     }
     
     @And("customer is not married")
     public void customer_is_not_married() {
         carInsurance.setStatus(MaritalStatus.not_married);
     }
     
     @And("customer is 22 years old")
     public void customer_is_twentytwo() {
         carInsurance.setAge(22);
     }
  
      @When("calculate the premium")
      public void calculate_the_premium() {
      actualAnswer1 = carInsurance.computePremium();
      }
  
      @Then("show 2000")
      public void should_be_shown() {
          assertEquals(2000, actualAnswer1, 0);
      }
      
      @Given("customer is 51 years old")
      public void customer_is_fiftyone() {
          carInsurance.setAge(51);
      }
   
       @When("we calculate the premium")
       public void we_calculate_the_premium() {
       actualAnswer = carInsurance.computePremium();
       }
   
       @Then("show 400")
       public void we_should_be_shown() {
           assertEquals(400, actualAnswer, 0);
       }  
}