package massivCalismalar;

public class calisma1 {

	public static void main(String[] args) {

//int tipində 5 elementli massiv yarat və adını (numbers) qoy.
//Bu massivin  elementlərinə müxtəlif dəyərlər mənimsət.

//for  operatoru vasitəsilə bu massivin daxilində 
//olan elementləri konsola çap et.

		int[] numbers = new int[5];
		numbers[0] = 40;
		numbers[1] = 24;
		numbers[2] = 16;
		numbers[3] = 37;
		numbers[4] = 12;

		for (int k = 0; k < 5; k++) {
		System.out.println(numbers[k]);
		}
	}
}
