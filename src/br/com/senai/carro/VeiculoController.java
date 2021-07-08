package br.com.senai.carro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.senai.motorista.Motorista;


public class VeiculoController {
	
	private Scanner tec;

	List<Veiculo> veiculos = new ArrayList<>();

	public VeiculoController() {
		tec = new Scanner(System.in);
	}

	public int leOpcao() {
		System.out.print("Informe a opção desejada: ");
		return tec.nextInt();
	}

	public void menuVeiculo(List<Veiculo> veiculos, List<Motorista> motoristas) {
		boolean sair = false;

		do {
			
			System.out.println("\n--------------MENU--------------");
			System.out.println("1) CADASTRAR VEICULO");
			System.out.println("2) LISTAR VEICULOS CADASTRADOS");
			System.out.println("3) EDITAR VEICULO");
			System.out.println("4) EXCLUIR VEICULO");
			System.out.println("5) SAIR");
			System.out.println("---------------------------------");
			
			int opcao = leOpcao();
			switch(opcao) {
			
			case 1:

				veiculos.add(cadastrarVeiculo());
				break;

			case 2: 

				listarVeiculos(veiculos);
				break;

			case 3:
				editarVeiculos(veiculos);
				break;

			case 4:
				excluirVeiculo(veiculos, motoristas);
				break;

			case 5:
				sair = true;
				break;


			default: 
				System.out.println("Opção inválida!!!");

			}

		}while(!sair);	
	}
	
	public Veiculo cadastrarVeiculo() {
		Veiculo veiculo = new Veiculo();

		System.out.println("------------------CADASTRAR VEICULO------------------");

		System.out.print("Informe o modelo do veiculo: ");
		veiculo.setModelo(tec.next());
		
		System.out.print("Informe a marca do veiculo: ");
		veiculo.setMarca(tec.next());
		
		System.out.print("Informe o ano do veiculo: ");
		veiculo.setAno(tec.nextInt());
		
		System.out.print("Informe a placa do veiculo: ");
		veiculo.setPlaca(tec.next());
		
		System.out.print("Informe o tipo de combustivel do veiculo: ");
		veiculo.setTipoCombustivel(tec.next());


		return veiculo;
	}
	
	
	public List<Veiculo> listarVeiculos(List<Veiculo> veiculos) {

		if (veiculos.isEmpty()) {
			System.out.println("Ops, não há nada para listar!!");
			return null;
		}

		System.out.println("------------------VEICULOS CADASTRADOS------------------");

		System.out.printf("| %2s | %12s | %12s | %12s | %12s | %12s | \n", "ID", "Modelo", "Marca", "Ano", "Placa", "Tipo de combustível");

		for (int i = 0; i < veiculos.size(); i++) {
			System.out.printf("| %2d | %12s |  %12s | %12d | %12s | %12s |\n", 
					i + 1, 
					veiculos.get(i).getModelo(),
					veiculos.get(i).getMarca(),
					veiculos.get(i).getAno(),
					veiculos.get(i).getPlaca(),
					veiculos.get(i).getTipoCombustivel());
					
		}


		return veiculos;
	}
	public List<Veiculo>editarVeiculos(List<Veiculo>veiculos) {

		Veiculo veiculo = new Veiculo();

		if (veiculos.isEmpty()) {
			
			System.out.println("Não há dados para serem listados!!");
			
			return null;
		}

		System.out.print("Informe o Id do veiculo para editar: ");
		int idVeiculo = tec.nextInt() - 1;

		System.out.println("1) MODELO DO VEICULO");
		System.out.println("2) MARCA DO VEICULO");
		System.out.println("3) ANO DO VEICULO");
		System.out.println("4) PLACA DO VEICULO");
		System.out.println("5) TIPO DE COMBUSTÍVEL DO VEICULO");


		System.out.print("Informe o campo para ser editado: ");
		int opcao = tec.nextInt();
	
		switch(opcao) {

		case 1: 
			System.out.println("---------------------EDITAR MODELO---------------------");
			System.out.println("Informe o novo modelo: ");
			veiculo.setModelo(tec.next());
			
			veiculo.setMarca(veiculos.get(idVeiculo).getMarca());
			veiculo.setAno(veiculos.get(idVeiculo).getAno());
			veiculo.setPlaca(veiculos.get(idVeiculo).getPlaca());
			veiculo.setTipoCombustivel(veiculos.get(idVeiculo).getTipoCombustivel());

			
			veiculos.set(idVeiculo, veiculo);

			break;

		case 2:
			System.out.println("---------------------EDITAR MARCA---------------------");
			System.out.print("Informe a nova marca: ");
			veiculo.setMarca(tec.next());

			veiculo.setModelo(veiculos.get(idVeiculo).getModelo());
			veiculo.setAno(veiculos.get(idVeiculo).getAno());
			veiculo.setPlaca(veiculos.get(idVeiculo).getPlaca());
			veiculo.setTipoCombustivel(veiculos.get(idVeiculo).getTipoCombustivel());
			
			veiculos.set(idVeiculo, veiculo);

			break;

		case 3:
			System.out.println("---------------------EDITAR ANO DO VEICULO---------------------");
			System.out.print("Informe a novo ano: ");
			veiculo.setAno(tec.nextInt());
			
			veiculo.setModelo(veiculos.get(idVeiculo).getModelo());
			veiculo.setMarca(veiculos.get(idVeiculo).getMarca());
			veiculo.setPlaca(veiculos.get(idVeiculo).getPlaca());
			veiculo.setTipoCombustivel(veiculos.get(idVeiculo).getTipoCombustivel());
			
			veiculos.set(idVeiculo, veiculo);
			

			break;
			
			
		case 4: 
			System.out.println("---------------------EDITAR PLACA DO VEICULO---------------------");
			System.out.print("Informe a nova placa: ");
			veiculo.setPlaca(tec.next());
			
			veiculo.setModelo(veiculos.get(idVeiculo).getModelo());
			veiculo.setMarca(veiculos.get(idVeiculo).getMarca());
			veiculo.setAno(veiculos.get(idVeiculo).getAno());
			veiculo.setTipoCombustivel(veiculos.get(idVeiculo).getTipoCombustivel());
			
			veiculos.set(idVeiculo, veiculo);
			

			break;
			
		case 5:
			
			System.out.println("---------------------EDITAR TIPO DE COMBUSTÍVEL---------------------");
			System.out.println("Informe o novo tipo:");
			veiculo.setTipoCombustivel(tec.next());
			
			veiculo.setModelo(veiculos.get(idVeiculo).getModelo());
			veiculo.setMarca(veiculos.get(idVeiculo).getMarca());
			veiculo.setAno(veiculos.get(idVeiculo).getAno());
			veiculo.setPlaca(veiculos.get(idVeiculo).getPlaca());
			
			veiculos.set(idVeiculo, veiculo);
			

			break;
			
		default:
			System.out.println("Opção Inválida!");
		

		return veiculos; 
	}
		return veiculos;


	}

	public void excluirVeiculo(List <Veiculo> veiculos, List<Motorista> motoristas) {
		listarVeiculos(veiculos);
		if(veiculos.isEmpty()) {
			return;
		}

		System.out.println("---------------------EXCLUIR VEICULO---------------------");

		System.out.print("Informe o ID do veiculo que deseja excluir: ");
		int idVeiculo = tec.nextInt() - 1;

		String modelo = veiculos.get(idVeiculo).getModelo();

		for (int i = 0; i < motoristas.size(); i++) {
			String motoristaVeiculo = motoristas.get(i).getVeiculo().getModelo();

			if (motoristaVeiculo.equals(modelo)) {
				System.out.println("\n");
				System.out.println("Não é possível excluir o curso pois há um aluno cadastrado neste curso!");
				System.out.println("\n");
				return;
			}
		}

		veiculos.remove(idVeiculo);
	}	
		
		

}