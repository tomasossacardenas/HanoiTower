package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Main {
	static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
	private static int discosTorre1, discosTorre2, discosTorre3;
	static String mensaje="";

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println("Ingrese la ruta del archivo con los casos");
		String rutaOrigen=br.readLine();
		System.out.println("Ingrese la ruta del archivo final");
		String rutaFinal=br.readLine();
		
		String message=readFile(rutaOrigen);
		
		String[] parts=message.split("\n");
		int cantidad=Integer.parseInt(parts[0]);

		for(int i=0;i<cantidad;i++) {
			if(i!=0) {
				mensaje+="\n";
			}
			int entrada=Integer.parseInt(parts[i+1]);
			discosTorre1=entrada;
			discosTorre2=0;
			discosTorre3=0;
			mensaje+=discosTorre1+" "+discosTorre2+" "+discosTorre3+"\n";
			play(entrada, 1, 2, 3);
		}
		mensaje+="\n";
		exportFile(rutaFinal,mensaje);
		
		br.close();
		bw.close();
	}
	public static void exportFile(String file,String message) throws FileNotFoundException {
		PrintWriter pw= new PrintWriter(file);
		pw.write(message);
		pw.close();
	}
	
	public static String readFile(String fileRuta) throws IOException {
		String message="";
		BufferedReader br2 = new BufferedReader(new FileReader(fileRuta));
		
    	String line = br2.readLine();
    	
    	while(line!=null){
    		//System.out.println("entro a line mensaje actual:"+message);
    		message+=line+"\n";
    		line = br2.readLine();
    	}
    	br2.close();
    	
    	//System.out.println("Message to return is: \n"+message);
		return message;
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
