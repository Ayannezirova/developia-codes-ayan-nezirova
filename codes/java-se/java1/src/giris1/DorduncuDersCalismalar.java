package giris1;

public class DorduncuDersCalismalar {

	public static void main(String[] args) {
        
	//while istifadə edərək 1-10 aralığında olan tam ədədləri konsola çap et.
		
		 int a=0;
		 while(a<10) {
	     a++;
    	 System.out.println(a)
		 ;
		 
		 }
		 
	//while istifadə edərək 1-10 aralığında olan double ədədləri konsola çap et.
		 
		 double c=0D;
		 while(c<=10) {
		 c+=0.1;
		 System.out.println(c);
		 }
		 
	 //İstənilən tam ədədin rəqəmlərinin ədədi ortasını hesablayan proqram yaz.
		 
		 int i= 15;
		 int cem=0;
		 while(i>0) {
		  int qaliq=i%10;
		  cem+=qaliq;
		  i=i/10;
		 
		 }
		 System.out.println(cem+"/2"+"="+cem/2);
		 

			
		 }
		  
}
