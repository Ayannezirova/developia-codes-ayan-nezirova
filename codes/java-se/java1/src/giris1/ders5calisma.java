package giris1;

public class ders5calisma {

	public static void main(String[] args) {
		//müəllimin  izahı ilə
		
		int ata=50;
		int ana=47;
		
		int ilkovlad=25;
		int ikinciovlad=ilkovlad-3;
		int ucuncuovlad=ikinciovlad-3;
		int dorduncuovlad=ucuncuovlad-3;
		int besinciovlad=dorduncuovlad-3;
		int altinciovlad=besinciovlad-3;
		int yeddinciovlad=altinciovlad-3;
		
		ata+=5;
		ana+=5;
		ilkovlad+=5;
		ikinciovlad+=5;
		ucuncuovlad+=5;
		dorduncuovlad+=5;
		besinciovlad+=5;
		altinciovlad+=5;
		yeddinciovlad+=5;
		
		int cem=ata+ana+ilkovlad+ikinciovlad+ucuncuovlad+dorduncuovlad+besinciovlad+altinciovlad+yeddinciovlad;
		System.out.println("cem = "+cem);
	

	}

}
