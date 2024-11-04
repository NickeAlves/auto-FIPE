package br.com.auto_fipe.principal;

import br.com.auto_fipe.model.Dados;
import br.com.auto_fipe.model.Modelos;
import br.com.auto_fipe.model.Veiculo;
import br.com.auto_fipe.service.ConsumoApi;
import br.com.auto_fipe.service.ConverteDados;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private Scanner scanner = new Scanner(System.in);
    private final ConsumoApi consumoApi = new ConsumoApi();
    private final ConverteDados converteDados = new ConverteDados();
    private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";

    public void exibeMenu() {
        var menu = """
                *** Opções de automóveis: ***
                Carro
                Moto
                Caminhão
                """;

        System.out.println(menu);
        System.out.print("Digite uma das opções para consultar: ");
        var opcaoAutomovel = scanner.nextLine();
        String endereco;

        if(opcaoAutomovel.toLowerCase().contains("carr")) {
            endereco = URL_BASE + "carros/marcas/";
        } else if ((opcaoAutomovel.toLowerCase().contains("mot"))) {
            endereco = URL_BASE + "motos/marcas/";
        } else {
            endereco = URL_BASE + "caminhoes/marcas/";
        }
        var json = consumoApi.obterDados(endereco);
        System.out.println(json);
        var marcas = converteDados.obterLista(json, Dados.class);
        marcas.stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);

        System.out.print("\n Informe o código da marca para consulta: ");
        var codigoMarca = scanner.nextLine();

        endereco += codigoMarca + "/modelos/";
        json = consumoApi.obterDados(endereco);
        var modeloLista = converteDados.obterDados(json, Modelos.class);

        System.out.println("\n Modelos dessa marca: ");
        modeloLista.modelos().stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);

        System.out.print("\nDigite um trecho do moodelo do carro a ser buscado: ");
        var nomeVeiculo = scanner.nextLine();

        List<Dados> modelosFiltrados = modeloLista.modelos().stream()
                .filter(m -> m.nome().toLowerCase().contains(nomeVeiculo.toLowerCase()))
                        .collect(Collectors.toList());
        System.out.println("\nModelos filtrados:");
        modelosFiltrados.forEach(System.out::println);

        System.out.print("Digite o código do modelo desejado: ");
        var codigoModelo = scanner.nextLine();

        endereco += codigoModelo + "/anos/";
        json = consumoApi.obterDados(endereco);
        List<Dados> anos = converteDados.obterLista(json, Dados.class);
        List<Veiculo> veiculos = new ArrayList<>();
        for (int i = 0; i < anos.size(); i++) {
            var enderecoAnos = endereco + anos.get(i).codigo();
            json = consumoApi.obterDados(enderecoAnos);
            Veiculo veiculo = converteDados.obterDados(json, Veiculo.class);
            veiculos.add(veiculo);
        }

        System.out.println("\nTodos os veículos filtrados com avaliações por ano: ");
        veiculos.forEach(System.out::println);



    }
}
