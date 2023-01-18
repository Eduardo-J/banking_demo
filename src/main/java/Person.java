
public class Person extends AccountHolder {

	String firstName;
	String lastName;
	
	Person(String firstName, String lastName, int idNumber){
		
		super(idNumber);
		this.firstName = firstName;
		this.lastName = lastName;
	}
}
