package class_object;

public class MainClass {

	public static void main(String[] args) {
		
		Book nermin = new Book();
		nermin.name = "Nermin" ;
		nermin.id = 3925;
		nermin.author= "mavi";
		nermin.printBookInfo();
		
		Book terlan = new Book();
		terlan.name = "Terlan" ;
		terlan.id= 5474;
		terlan.author = "sarı"; 
		terlan.printBookInfo();
		
	}
      
}
