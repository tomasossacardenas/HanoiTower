package ui;

import java.util.Scanner;

public class Main {
	static Scanner sc= new Scanner(System.in);
	private static int discosTorre1, discosTorre2, discosTorre3;
	static String mensaje;

	public static void main(String[] args) {
		mensaje="";
		int cantidad=sc.nextInt();
		for(int i=0;i<cantidad;i++) {
			if(i!=0) {
				mensaje+="\n";
			}
			int entrada=sc.nextInt();
			discosTorre1=entrada;
			discosTorre2=0;
			discosTorre3=0;
			mensaje+=discosTorre1+" "+discosTorre2+" "+discosTorre3+"\n";
			play(entrada, 1, 2, 3);
		}
		System.out.println(mensaje);
		
	}
	
	public static void play(int discos,int torre1, int torre2, int torre3) {
	    if (discos == 1) {
	    	if(torre1==1) {
		    	discosTorre1--;
	    	}
	    	else if(torre1==2) {
	    		discosTorre2--;
	    	}
	    	else if(torre1==3) {
		    	discosTorre3--;
	    	}
	    	
	    	if(torre3==1) {
	    		discosTorre1++;
	    	}
	    	else if(torre3==2) {
	    		discosTorre2++;
	    	}
	    	else if(torre3==3) {
	    		discosTorre3++;
	    	}
	    	mensaje+=(discosTorre1+" "+discosTorre2+" "+discosTorre3+"\n");
	    }
	    else {
	    	play(discos-1, torre1,torre3, torre2);
	    	if(torre1==1) {
		    	discosTorre1--;
	    	}
	    	else if(torre1==2) {
	    		discosTorre2--;
	    	}
	    	else if(torre1==3) {
		    	discosTorre3--;
	    	}
	    	if(torre3==1) {
	    		discosTorre1++;
	    	}
	    	else if(torre3==2) {
	    		discosTorre2++;
	    	}
	    	else if(torre3==3) {
	    		discosTorre3++;
	    	}
	    	mensaje+=(discosTorre1+" "+discosTorre2+" "+discosTorre3+"\n");
	    	play(discos-1, torre2,torre1, torre3);
	    }
	}

}
