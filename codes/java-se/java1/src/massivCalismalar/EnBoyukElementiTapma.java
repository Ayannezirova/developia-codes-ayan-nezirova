package massivCalismalar;

public class EnBoyukElementiTapma {

	public static void main(String[] args) {
		
		int[] numbers = new int[5];
		numbers[0] = 40;
		numbers[1] = 24;
		numbers[2] = 16;
		numbers[3] = 37;
		numbers[4] = 12;

		boolean enboyukelement = true;
		int saygac = 1;
		
		while (enboyukelement) {
	    enboyukelement = false;
	    
	    for(int i = 0; i < 5 - saygac; i++) {
        if (numbers[i] > numbers[i + 1]) {
        int h = numbers[i];
        numbers[i] = numbers[i + 1];
        numbers[i + 1] = h;
        enboyukelement = true;
    }	
	    }
        saygac++;
		 }
	    for(int i = 0; i < 5; i++) 
	    System.out.println(numbers[i]);
 
 }
}