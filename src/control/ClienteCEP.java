package control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClienteCEP {
	private static Scanner scan;

	public static void main(String[] args) {
		Socket sckCliente;
		InputStream canalDeEntrada;
		OutputStream canalDeSaida;
		PrintWriter saida;
		BufferedReader entrada;
		
		
		try {
			sckCliente = new Socket("127.0.0.1", 4000);
			canalDeEntrada = sckCliente.getInputStream();
			canalDeSaida = sckCliente.getOutputStream();
					
			entrada = new BufferedReader(new InputStreamReader(canalDeEntrada));
			saida = new PrintWriter(canalDeSaida, true);
			
			scan = new Scanner(System.in);
			System.out.println("Digite o CEP que deseja Consulta : ");
			String resp = scan.nextLine();
			
			saida.println(resp);
			
			while(true) {
				String s = entrada.readLine();
				if (s == null)
					break;
				System.out.println(s);
			}

			sckCliente.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
