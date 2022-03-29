package br.com.lds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

				continue;

			}

			switch (opcao) {
			case 1:

				cadastrarCavalo();

				break;

			case 2:

				cadastrarGirafa();

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
				System.out.println("----------");
				System.out.print("Insira o id do animal a ser removido: ");

				try {

					int idDoAnimal = scanner.nextInt();
					removerAnimalPorID(idDoAnimal);
				} catch (Exception e) {
					System.out.println(e.getMessage());
					scanner.next();
				}

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

			System.out.println("----------");

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

	private void cadastrarCavalo() {

		System.out.println("----------");
		System.out.print("Insira o nome do cavalo: ");
		try {
			String nome = scanner.next();
			Cavalo cavalo = new Cavalo(nome);
			animais.add(cavalo);
			System.out.println("O cavalo foi inserido com sucesso");
			TimeUnit.SECONDS.sleep(2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			scanner.next();
			System.out.println("Ocorreu um erro.");

		}
	}

	private void cadastrarGirafa() {

		System.out.print("Insira o nome da girafa: ");
		try {
			String nome = scanner.next();
			Girafa girafa = new Girafa(nome);

			animais.add(girafa);
			System.out.println("A girafa foi inserida com sucesso");

			TimeUnit.SECONDS.sleep(2);
		} catch (Exception e) {

			System.out.println(e.getMessage());
			scanner.next();
			System.out.println("Ocorreu um erro.");

		}

		for (Animal animal : animais) {
			System.out.println("nome: " + animal.getNome() + " id: " + animal.getId());

		}
	}

	private void listarCavalo() {

		System.out.println("----------");

		for (Animal animal : animais) {
			if (animal instanceof Cavalo) {
				System.out.println("Dados do cavalo: " + animal.getId() + "|" + animal.getNome());
			}
		}
	}

	private void listarGirafa() {

		System.out.println("----------");

		for (Animal animal : animais) {
			if (animal instanceof Girafa) {
				System.out.println("Dados da girafa: " + animal.getId() + "|" + animal.getNome());
			}
		}
	}

	private void listarTodosAnimais() {
		for (Animal animal : animais) {
			System.out.println("Dados do animal:" + animal.getClass().getSimpleName() + "|" + animal.getNome() + "|"
					+ animal.getId());
		}
	}

	private void removerAnimalPorID(int idDoAnimal) {

		int indiceDaLista = -1;

		for (int i = 0; i < animais.size(); i++) {

			Animal animal = animais.get(i);
			if (animal.getId() == idDoAnimal) {
				indiceDaLista = i;
				break;

			}

		}

		if (indiceDaLista == -1) {
			System.out.println("Animal não encontrado");
			return;

		}

		animais.remove(indiceDaLista);
		System.out.println("Animal removido com sucesso.");

	}

	private void exibirQuantidadeDeAnimaisPorTipo() {

		System.out.println("----------");
		if (animais.size() == 0) {
			System.out.println("Lista vazia");
			return;
		}

		final String chaveCavalo = "CAVALO";
		final String chaveGirafa = "GIRAFA";

		Map<String, List<Animal>> mapaDeAnimais = new HashMap<String, List<Animal>>();

		mapaDeAnimais.put(chaveCavalo, new ArrayList<Animal>());
		mapaDeAnimais.put(chaveGirafa, new ArrayList<Animal>());

		for (Animal animal : animais) {

			if (animal instanceof Cavalo) {

				List<Animal> listaDeCavalos = mapaDeAnimais.get(chaveCavalo);

				listaDeCavalos.add(animal);

			} else if (animal instanceof Girafa) {

				List<Animal> listaDeGirafas = mapaDeAnimais.get(chaveGirafa);

				listaDeGirafas.add(animal);

			}

		}

		List<Animal> cavalos = mapaDeAnimais.get(chaveCavalo);
		List<Animal> girafas = mapaDeAnimais.get(chaveGirafa);

		System.out.println("Quantidade de cavalo: " + cavalos.size());
		System.out.println("Quantidade de girafa: " + girafas.size());
		System.out.println("Total de animais cadastrados: " + animais.size());

		for (Animal animal : animais) {
			if (animal instanceof Cavalo) {

				System.out.println("Dados do cavalo: " + animal.getId() + "|" + animal.getNome());

			} else if (animal instanceof Girafa) {

				System.out.println("Dados da girafa: " + animal.getId() + "|" + animal.getNome());

			}

		}
	}

}
