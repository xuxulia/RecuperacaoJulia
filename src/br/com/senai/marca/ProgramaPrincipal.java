package br.com.senai.marca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.senai.carro.Veiculo;
import br.com.senai.carro.VeiculoController;
import br.com.senai.motorista.Motorista;
import br.com.senai.motorista.MotoristaController;

public class ProgramaPrincipal {
	
	private Scanner tec;

	public ProgramaPrincipal() {
		tec = new Scanner(System.in);

	}

	public int leOpcao() {
		System.out.print("> ");
		return tec.nextInt();
	}

	public static void main(String[] args) {
		List<Motorista> motoristas = new ArrayList<>();
		List<Veiculo> veiculos = new ArrayList<Veiculo>();

		boolean sair = false;
		MotoristaController motoristaController = new MotoristaController();
		VeiculoController veiculoController = new VeiculoController();
		Menu menu = new Menu();


		do {

			menu.listarMenu(veiculos, motoristas);
			int opcao = menu.leOpcao();

			switch (opcao) {

			case 1:
				motoristaController.menuMotorista(motoristas, veiculos);
				break;

			case 2:
				veiculoController.menuVeiculo(veiculos, motoristas);
				break;

			case 3:
				sair = true;
				break;

			default:
				System.out.println("Opção inválida!");
				break;

			}

		} while (!sair);

		System.out.println("SISTEMA FINALIZADO!!");

	}

}


