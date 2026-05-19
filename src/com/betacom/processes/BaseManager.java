package com.betacom.processes;

import java.util.ArrayList;
import com.betacom.interfaces.GeneralProcess;
import com.betacom.objects.User;
import com.betacom.utils.AutomaticPromotion;




public class BaseManager  implements GeneralProcess{

	@Override
	public boolean execute() throws Exception {
		System.out.println("\n" + "Begin mainBase");
		/*
		 * primitives
		 * nome        bit   byte         range valore
		 * byte        0     1            -128 +127
		 * int         32    4            +/- 2*10 9
		 * short       16    2            -32768 + 32767
		 * long        64    8             +/- 9*10 ^18
		 * float       32    4             340282347 - 10 ** 38     7 cifre dopo la virgola
		 * double      64    8                                      15 cifre dopo la virgola
		 * 
		 */
		byte b = 127;
		int  i  = 2_000_000_000; 
		short s = 32767;
		long  l = 123456788;
		double d = 1234;
		boolean bool = true;  // false
		char c = 'z';
		
		
		String str = "Ciao sono una string" + "\n";
		
		System.out.print(str);
		System.out.print(str);
		
		
//		Scanner sc = new Scanner(System.in);
//		System.out.print("Nome:");
//		String nome = sc.next();
//		System.out.println("valore di nome:" + nome.toUpperCase());
		
		/*
		 * operatore logici
		 * ! not
		 * && and
		 * || or 
		 * == 
		 * < > <= >=
		 */
		char p3 = 'z';
		int p1= 30;
		int p2 = 16;
		boolean rc = (p1 > p2) && (p3 != 'z');
		System.out.println("Valore di rc:" + rc);
		
		
		int eta = 35;
		String result = "";
		if (eta < 30)
			result = "Sono un ragazzino";
		else 
			result = "Sono un vachietto";
		System.out.println(result);	
		
		eta = 25;		
		result = (eta < 30) ? "Sono un ragazzino" : "Sono un vachietto";
		System.out.println(result);	
		
		/*
		 * operatori aritmetici
		 * + - / * %
		 */
		
		i = 30;
		i++;
		System.out.println("Valore di i:" + i);
		i--;
		System.out.println("Valore di i:" + i);
		int j = 3;
		int res = i * j;
		res++;
		int div = res / 2;
		int rim = res % 2;

		System.out.println("Valore di i :" + i
				+ " valore di res:" + res
				+ " valore di div:" + div
				+ " valore di rim:" + rim
				);
		
		String param = "12345";
		long iL = Long.parseLong(param) / 2;
		System.out.println("valore di parame / 2 :" + i );
		
		param = "sklkdlkdlkofkfofmgjhjitjjfmgogojgojgog";
		System.out.println("parame length:" + param.length() +  " part of string:" + param.substring(4, 8));
		
		param = "     inizio  dell'academy Java    ";
		System.out.println(">>" + param.trim() + "<<");
		
		String search = "academy  ";
		if (param.trim().contains(search.trim()))
			System.out.println(search.trim() + " tovato dentro la string parame");
		else 
			System.out.println(search.trim() + " NON tovato dentro la string parame");
		
		
		String[] array = {"primo", "secomdo", "terso", "quarto"};
		array[2] = "qudo";
		
		for (int idx=0; idx <array.length ; idx++) {
			System.out.println("idx:" + idx + " valore:" + array[idx] );
		}
		
		for (String it:array) {
			System.out.println(it);
		}
		
	
		AutomaticPromotion.metod(10);
		AutomaticPromotion.metod(2.0f);
		AutomaticPromotion.metod("AAAaa");
		
		
//		Integer[] numeri = {10, 20, null, 30, 40 };
		Integer[] numeri = new Integer[5];
		numeri[0] = AutomaticPromotion.MAX_USERS;
		numeri[1] = 20;
		numeri[2] = null;
		numeri[3] = 30;
		numeri[4] = 40;
		
		for (Integer it:numeri) {
			System.out.println(it);
		}
		
	
		/*
		 * Array 2d
		 */
		String[] [] multi = new String[3] [4];
		for (int id=0; id < multi.length; id++) {
			for (int jd = 0; jd < multi[id].length; jd++) {
				multi[id] [jd] = "prova_" + id + "_" +jd;

			}
		}
		System.out.println("id 2 , jd 3:" + multi[1] [3]);
		
		/*
		 * Array dinamiche
		 */
		ArrayList<String> aL = new ArrayList<String>();
		aL.add("Pietro");
		aL.add("Anna");
		aL.add("Angelo");
		aL.add("Lucia");
		
		System.out.println("Area length:" + aL.size());
		aL.add("Celina");
		
		aL.remove(2);
		for (String it:aL) {
			System.out.println(it);
		}
		
		ArrayList<User> aU = new ArrayList<User>();
		aU.add(new User("Pietro","Ilgrande", true));
		aU.add(new User("Anna","Labella", false));
		aU.add(new User("Angelo","Ilpiccolo", "M"));
		aU.add(new User("Lucia","Rossi", "F"));
		aU.add(new User("Luca","Ilbello", true));
		
		search = "Ilpiccolo1";
		int idx= 0;
		for (User it:aU) {
			if (it.getSurname().equalsIgnoreCase(search))
				break;
			idx++;
		}
		if (idx >= aU.size()) {
			System.out.println("item non trovato");

		} else {
			System.out.println("item trovato:" + aU.get(idx));			
		}
		
		User aa = new User();
		return false;
		
	}


}