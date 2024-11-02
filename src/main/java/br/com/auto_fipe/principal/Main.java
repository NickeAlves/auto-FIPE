package br.com.auto_fipe.principal;

import br.com.auto_fipe.model.Marcas;
import br.com.auto_fipe.model.Modelos;
import br.com.auto_fipe.service.ConsumoApi;
import br.com.auto_fipe.service.ConverteDados;

import java.util.List;
import java.util.Scanner;

public class Main {
    private final Scanner scanner = new Scanner(System.in);
    private final ConsumoApi consumoApi = new ConsumoApi();
    private final ConverteDados converteDados = new ConverteDados();
    private final String BASE_URL = "https://parallelum.com.br/fipe/api/v1/";

    public void exibeMenu() {
        while (true) {
            System.out.println(" Bem-vindo(a) ao Auto-FIPE! ");
            System.out.println("""
                    Opções disponíveis:
                    - Carro
                    - Moto
                    - Caminhão
                    - Sair
                    """);
            System.out.print("Digite a opção desejada: ");
            var opcaoAutomovel = scanner.nextLine();

            if (opcaoAutomovel.equalsIgnoreCase("carro")){
                var urlMarcas = BASE_URL + opcaoAutomovel.toLowerCase() + "s/marcas/";
                System.out.println(urlMarcas);

                String jsonMarcas = consumoApi.obterDados(urlMarcas);
                List<Marcas> marcasList = converteDados.obterDados(jsonMarcas, Marcas.class);
                marcasList.forEach(System.out::println);

                System.out.print("Selecione o código da marca desejada: ");
                int codigoMarca = scanner.nextInt();
                scanner.nextLine();

                var urlModelos = urlMarcas + codigoMarca + "/modelos/";
                System.out.println(urlModelos);
                String jsonModelos = consumoApi.obterDados(urlModelos);
                List<Modelos> modelosList = converteDados.obterDados(jsonModelos, Modelos.class);
                modelosList.forEach(System.out::println);



            } else if (opcaoAutomovel.equalsIgnoreCase("moto")) {
                var urlMarcas = BASE_URL + opcaoAutomovel.toLowerCase() + "s/marcas/";
                String jsonMarcas = consumoApi.obterDados(urlMarcas);
                List<Marcas> marcasList = converteDados.obterDados(jsonMarcas, Marcas.class);
                marcasList.forEach(System.out::println);

                System.out.print("Selecione o código da marca desejada: ");
                int codigoMarca = scanner.nextInt();
                scanner.nextLine();

                var urlModelos = urlMarcas + codigoMarca + "/modelos/";
                System.out.println(urlModelos);
                String jsonModelos = consumoApi.obterDados(urlModelos);
                List<Modelos> modelosList = converteDados.obterDados(jsonModelos, Modelos.class);
                modelosList.forEach(System.out::println);

            } else if (opcaoAutomovel.equalsIgnoreCase("caminhao")) {
                var urlMarcas = BASE_URL + opcaoAutomovel.toLowerCase() + "s/marcas/";
                String jsonMarcas = consumoApi.obterDados(urlMarcas);
                List<Marcas> marcasList = converteDados.obterDados(jsonMarcas, Marcas.class);
                marcasList.forEach(System.out::println);

                System.out.print("Selecione o código da marca desejada: ");
                int codigoMarca = scanner.nextInt();
                scanner.nextLine();

                var urlModelos = urlMarcas + codigoMarca + "/modelos/";
                System.out.println(urlModelos);
                String jsonModelos = consumoApi.obterDados(urlModelos);
                List<Modelos> modelosList = converteDados.obterDados(jsonModelos, Modelos.class);
                modelosList.forEach(System.out::println);


            } else if (opcaoAutomovel.equalsIgnoreCase("sair")) {
                System.out.println("Saindo...");
                break;
            } else {
                System.out.println("Opção inválida! Tente novamente");
            }




        }
    }
    public static void main(String[] args) {
        new Main().exibeMenu();
    }
}
