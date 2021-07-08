package br.com.senai.marca;

import java.util.List;
import java.util.Scanner;

import br.com.senai.carro.Veiculo;
import br.com.senai.motorista.Motorista;

public class Menu {
	
	Scanner tec = new Scanner(System.in);

	public void listarMenu(List<Veiculo> veiculos, List<Motorista> motoristas) {
		System.out.println("\n---------------- MENU ----------------");
		System.out.println("1) MOTORISTA");
		System.out.println("2) VEICULO");
		System.out.println("3) SAIR");
		System.out.println("----------------------------------------");
	}

	public int leOpcao() {
		System.out.print("> ");
		return tec.nextInt();
	}
}




