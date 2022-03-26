package br.com.lds;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import br.com.lds.models.Animal;
import br.com.lds.models.Cavalo;
import br.com.lds.models.Girafa;

public class Main {

	public static void main(String[] args) {

		Main app = new Main();
		app.start();

	}

	Scanner scanner = new Scanner(System.in);
	List<Animal> animais = new ArrayList<Animal>();
	int id = -1;

	private void start() {

		boolean emExecucao = true;

		while (emExecucao) {
			exibirMenu();

			int opcao = -1;

			try {

				opcao = scanner.nextInt();

			} catch (Exception e) {

				scanner.next();

				System.out.println(e.getMessage());
				System.out.println("Ocorreu um erro. Tente novamente");
				System.out.println("-----");

			}

			switch (opcao) {
			case 1:

				id += 1;
				cadastrarCavalo(id);

				break;

			case 2:

				id += 1;
				cadastrarGirafa(id);

				break;

			case 3:

				listarCavalo();

				break;

			case 4:

				listarGirafa();

				break;

			case 5:

				listarTodosAnimais();

				break;

			case 6:
				removerAnimalPorID();

				break;

			case 7:

				exibirQuantidadeDeAnimaisPorTipo();

				break;

			case 8:

				emExecucao = false;

				break;

			default:
				System.out.println("Opcao invalida.");
				break;
			}

		}

	}

	private void exibirMenu() {
		System.out.println("1. Cadastrar cavalo");
		System.out.println("2. Cadastrar girafa");
		System.out.println("3. Listar cavalo");
		System.out.println("4. Listar girafa");
		System.out.println("5. Listar todos os animais");
		System.out.println("6. Remover um animal por id");
		System.out.println("7. Exbir a quantidade de animais por tipo");
		System.out.println("8. Sair");

		System.out.print("Sua opcao: ");

	}

	private void cadastrarCavalo(int id) {
		try {
			System.out.print("Insira o nome do cavalo: ");
			String nome = scanner.next();
			Cavalo cavalo = new Cavalo(id, nome);
			System.out.println("O cavalo foi inserido com sucesso");
			animais.add(id, cavalo);
			TimeUnit.SECONDS.sleep(2);
		} catch (Exception e) {
			scanner.next();
			System.out.println(e.getMessage());
			System.out.println("Ocorreu um erro.");

		}
	}

	private void cadastrarGirafa(int id) {
		try {
			System.out.print("Insira o nome da girafa: ");
			String nome = scanner.next();
			Girafa girafa = new Girafa(id, nome);
			System.out.println("A girafa foi inserida com sucesso");
			animais.add(id, girafa);
			TimeUnit.SECONDS.sleep(2);
		} catch (Exception e) {
			scanner.next();
			System.out.println(e.getMessage());
			System.out.println("Ocorreu um erro.");

		}

		for (Animal animal : animais) {
			System.out.println("nome: " + animal.getNome() + " id: " + animal.getId());

		}
	}

	private void listarCavalo() {
		for (Animal animal : animais) {
			if (animal instanceof Cavalo) {
				System.out.println("Dados do cavalo: " + animal.getId() + "|" + animal.getNome());
			}
		}
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void listarGirafa() {
		for (Animal animal : animais) {
			if (animal instanceof Girafa) {
				System.out.println("Dados da girafa: " + animal.getId() + "|" + animal.getNome());
			}
		}
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void listarTodosAnimais() {
		for (Animal animal : animais) {
			System.out.println("Dados do animal:" + animal.getClass() + "|" + animal.getNome() + "|" + animal.getId());
		}

		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void removerAnimalPorID() {
		try {
			System.out.print("Insira o id do animal a ser removido: ");
			int remover = scanner.nextInt();
			animais.remove(remover);
			System.out.println("Animal removido com sucesso.");
			TimeUnit.SECONDS.sleep(2);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			scanner.next();
			// TODO: handle exception
		}
	}

	private void exibirQuantidadeDeAnimaisPorTipo() {
		int contaCavalo = 0;
		int contaGirafa = 0;
		for (Animal animal : animais) {
			if (animal instanceof Cavalo) {
				contaCavalo += 1;
				System.out.println("Dados do cavalo: " + animal.getId() + "|" + animal.getNome());
			} else if (animal instanceof Girafa) {
				contaGirafa += 1;
				System.out.println("Dados da Girafa: " + animal.getId() + "|" + animal.getNome());

			}

			System.out.println("Quantidade de cavalo: " + contaCavalo);
			System.out.println("Quantidade de girafa: " + contaGirafa);
			System.out.println("Total de animais cadastrados: " + animais.size());
		}
	}

}
