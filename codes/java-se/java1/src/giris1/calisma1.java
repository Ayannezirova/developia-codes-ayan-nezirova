package giris1;

public class calisma1 {

	// 1-ci ders calisma 1:

	jshell>
	int e1 = 0;e1==>0

	jshell>
	int e2 = 0;e2==>0

	jshell>for(int j=1;j<=10;j++)
	{
		e1++;
		e2 += e1;
	}

	jshell>
	e2
		e2==>55

	jshell>
	e1 e1==>10

	evvelki ders misal 2:

	jshell>
	int e1 = 0;e1==>0

	jshell>
	int e2 = 0;e2==>0

	jshell>for(int j=1;j<=20;j++)
	{
		e1 += 2;
		e2 += e1;
}

jshell>
e2
		e2==>420

jshell>
e1 e1==>40

// 2-ci ders calisma 1:

public static void main(String[] args) {
			jshell> int e1=48;
			e1 ==> 48

			jshell> int e2=12;
			e2 ==> 12

			jshell> System.out.println(e1+ "+" +e2+ "="+(e1+e2));
			48+12=60

			jshell> System.out.println(e1+ "-" +e2+ "="+(e1-e2));
			48-12=36

			jshell> System.out.println(e1+ "*" +e2+ "="+(e1*e2));
			48*12=576

			jshell> System.out.println(e1+ "/" +e2+ "="+(e1/e2));
			48/12=4
			
		//calisma 2:
			jshell> String sirket1="Nurgun Group"
			sirket1 ==> "Nurgun Group"

			jshell> String sirket2="Pasha Holding"
			sirket2 ==> "Pasha Holding"

			jshell> String sirket3="Gilan Holding"
			sirket3 ==> "Gilan Holding"

			jshell> String sirket4="Synergy Group"
			sirket4 ==> "Synergy Group"

			jshell> String sirket5="Evsen Group"
			sirket5 ==> "Evsen Group"

			jshell> System.out.println(sirket1+", "+sirket2+", "+sirket3+", "+sirket4+", "+sirket5);
			Nurgun Group, Pasha Holding, Gilan Holding, Synergy Group, Evsen Group
		
		//calisma 3:
			
			jshell> String prg1="Python";
			prg1 ==> "Python"

			jshell> String prg2="Java";
			prg2 ==> "Java"

			jshell> String prg3="Assembler";
			prg3 ==> "Assembler"
			
			jshell> System.out.println(prg1+","+prg2+","+prg3);
			Python,Java,Assembler
		
		//calisma 4:
			
			jshell> String name="Ayan";
			name ==> "Ayan"
			
			jshell> System.out.println(name);
			Ayan
			
		//calisma 5:
			
			a) -9 + 2 * 6

        jshell> int e1=-9;
        e1 ==> -9

        jshell> int e2=2;
        e2 ==> 2

        jshell> int e3=6;
        e3 ==> 6
        		
        jshell> System.out.print(e1+"+"+e2+"*"+e3+"="+(e1+e2*e3));
		
        jshell> System.out.print(e1+"+"+e2+"*"+e3+"="+(e1+e2*e3));
        -9+2*6=3
        	  
        	b) (22+9) % 9

        jshell> int e1=22;
        e1 ==> 22

        jshell> int e2=9;
        e2 ==> 9
             
        jshell> int e3=9;
        e3 ==> 9

        jshell> System.out.println("("+e1+"+"+e2+")"+"%"+e3+"="+((e1+e2)%9));
        (22+9)%9=4
        	
        	c) 20 + -3 *5 / 8
        
        jshell> int e1=20;
        e1 ==> 20

        jshell> int e2=-3;
        e2 ==> -3

        jshell> int e3=5;
        e3 ==> 5

        jshell> int e4=8;
        e4 ==> 8
 
        jshell> System.out.println(e1+"+"+e2+"*"+e3+"/"+e4+"="+(e1+e2*e3/e4));
        20+-3*5/8=19
        	
        	d) 5 + 15 / 3 * 2 - 8 % 3

        jshell> int e1=5
        e1 ==> 5

        jshell> int e2=15
        e2 ==> 15

        jshell> int e3=3
        e3 ==> 3

        jshell> int e4=2
        e4 ==> 2

        jshell> int e5=8
        e5 ==> 8

        jshell> System.out.println(e1+"+"+e2+"/"+e3+"*"+e4+"-"+e5+"%"+e3+"="+(e1+e2/e3*e4-e5%e3));
        5+15/3*2-8%3=13
