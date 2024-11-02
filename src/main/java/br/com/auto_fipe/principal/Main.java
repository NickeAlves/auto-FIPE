package br.com.auto_fipe.principal;

import br.com.auto_fipe.model.InfoVeiculos;
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
                List<InfoVeiculos> infoVeiculosList = converteDados.obterDados(urlMarcas, InfoVeiculos.class);
                infoVeiculosList.forEach(System.out::println);

            } else if (opcaoAutomovel.equalsIgnoreCase("moto")) {
                var urlMarcas = BASE_URL + opcaoAutomovel.toLowerCase() + "s/marcas/";
                System.out.println(urlMarcas);
                List<InfoVeiculos> infoVeiculosList = converteDados.obterDados(urlMarcas, InfoVeiculos.class);
                infoVeiculosList.forEach(System.out::println);


            } else if (opcaoAutomovel.equalsIgnoreCase("caminhao")) {
                var urlMarcas = BASE_URL + "caminhoes/marcas/";
                System.out.println(urlMarcas);
                List<InfoVeiculos> infoVeiculosList = converteDados.obterDados(urlMarcas, InfoVeiculos.class);
                infoVeiculosList.forEach(System.out::println);


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
