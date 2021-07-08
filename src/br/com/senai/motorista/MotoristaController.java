package br.com.senai.motorista;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.senai.carro.Veiculo;
import br.com.senai.carro.VeiculoController;



public class MotoristaController {
	
	private Scanner tec;
	private VeiculoController veiculoController;
	
	List<Motorista> motoristas = new ArrayList<>();

	public MotoristaController() {
		veiculoController = new VeiculoController();
		tec = new Scanner(System.in);
	}

	public int leOpcao() {
		System.out.print("Informe a opção desejada:");
		return tec.nextInt();
	}

	public void menuMotorista(List<Motorista> motoristas, List<Veiculo> veiculos) {

		boolean sair = false;

		do {
			System.out.println("\n--------------MENU--------------");
			System.out.println("1) CADASTRAR MOTORISTA");
			System.out.println("2) LISTAR MOTORISTAS CADASTRADOS");
			System.out.println("3) EDITAR MOTORISTA");
			System.out.println("4) EXCLUIR MOTORISTAS");
			System.out.println("5) SAIR");
			System.out.println("---------------------------------");
			
			int opcao = leOpcao();
			switch (opcao) {

			case 1:
				motoristas.add(cadastrarMotorista(veiculos));
				break;

			case 2:
				listarMotoristas(motoristas);
				break;

			case 3:
				editarMotorista(motoristas);
				break;

			case 4:
				excluirMotorista(motoristas);
				break;
			
			case 5: 
				sair = true;
				break;
				
			default:
				System.out.println("Opção Inválida!!!");
				break;
			}


		} while (!sair);
	}
		
	public Motorista cadastrarMotorista(List<Veiculo> veiculos) {

		if (veiculos.isEmpty()) {
			System.out.println("Impossível realizar o cadastro de um motorista antes de efetuar o cadastro dos veiculos! Volte para o menu principal :)");
			return null;
		}

		veiculoController.listarVeiculos(veiculos);

		Motorista motorista = new Motorista();
		Veiculo veiculo = new Veiculo();

		System.out.println("------------------CADASTRAR MOTORISTAS------------------");

		System.out.print("Informe o ID do veiculo: ");
		int idVeiculo = tec.nextInt() - 1;

		veiculo.setModelo(veiculos.get(idVeiculo).getModelo());

		motorista.setVeiculo(veiculo);

		System.out.print("Informe o nome: ");
		tec.nextLine();
		motorista.setNome(tec.nextLine());

		System.out.print("Informe a idade: ");
		motorista.setIdade(tec.nextInt());
		
		System.out.print("Informe a categoria de habilitação: ");
		motorista.setCategoriaHabilitacao(tec.next());

		return motorista;
	}

	public List<Motorista> listarMotoristas(List<Motorista> motoristas) {

		if (motoristas.isEmpty()) {
			System.out.println("Ops, não existem dados a serem listados!");
			return null;
		}

		System.out.printf("| %2s | %15s | %2s | %25s | %10s |\n", "ID", "Nome", "Idade", "Categoria de Habilitação","Veiculo");

		for (int i = 0; i < motoristas.size(); i++) {
			System.out.printf("| %2d | %15s | %5d | %25s | 10s |\n", 
					i + 1, 
					motoristas.get(i).getNome(),
					motoristas.get(i).getIdade(),
					motoristas.get(i).getCategoriaHabilitacao(),
					motoristas.get(i).getVeiculo().getModelo());
		}

		return motoristas;
	}

	public List<Motorista>editarMotorista(List<Motorista>motoristas) {

		Motorista motorista = new Motorista();

		if (motoristas.isEmpty()) {
			
			System.out.println("Não há dados para serem listados!!");
			
			return null;
		}

		System.out.print("Informe o Id do motorista para editar: ");
		int idMotorista = tec.nextInt() - 1;

		System.out.println("1) NOME DO MOTORISTA");
		System.out.println("2) IDADE");
		System.out.println("3) CATEGORIA DE HABILITAÇÃO");


		System.out.print("Informe o campo para ser editado: ");
		int opcao = tec.nextInt();
	
		switch(opcao) {

		case 1: 
			System.out.println("---------------------EDITAR NOME DO MOTORISTA---------------------");
			System.out.print("Informe o novo nome do motorista: ");
			motorista.setNome(tec.next().toUpperCase());

			motorista.setIdade(motoristas.get(idMotorista).getIdade());
			motorista.setCategoriaHabilitacao(motoristas.get(idMotorista).getCategoriaHabilitacao());

			motoristas.set(idMotorista, motorista);

			break;

		case 2:
			System.out.println("---------------------EDITAR IDADE---------------------");

			System.out.print("Informe a nova idade: ");
			motorista.setIdade(tec.nextInt());

			motorista.setNome(motoristas.get(idMotorista).getNome());
			motorista.setCategoriaHabilitacao(motoristas.get(idMotorista).getCategoriaHabilitacao());
			
			motoristas.set(idMotorista, motorista);

			break;

		case 3:
			System.out.println("---------------------EDITAR CATEGORIA DE HABILITAÇÃO---------------------");


			System.out.print("Informe a nova categora: ");
			motorista.setCategoriaHabilitacao(tec.next());
			
			motorista.setNome(motoristas.get(idMotorista).getNome());
			motorista.setIdade(motoristas.get(idMotorista).getIdade());
			
			motoristas.set(idMotorista, motorista);

			break;

		
		default:
			System.out.println("Opção Inválida!");
		

		return motoristas; 
	}
		return motoristas;


	}

	public void excluirMotorista(List <Motorista> motoristas) {
		listarMotoristas(motoristas);
		if(motoristas.isEmpty()) {
			return;
		}

		System.out.println("---------------------EXCLUIR MOTORISTA---------------------");

		System.out.print("Informe o ID do motorista para exclui-lo: ");
		int idMotorista = tec.nextInt() - 1;

		if(motoristas.size() <= idMotorista) {

			System.out.println("Motorista não cadastrado.");
			return;
		}

		motoristas.remove(idMotorista);
	}		
		

}		