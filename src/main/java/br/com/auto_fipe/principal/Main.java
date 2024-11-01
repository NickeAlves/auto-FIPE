package br.com.auto_fipe.principal;

import br.com.auto_fipe.model.DadosCaminhoes;
import br.com.auto_fipe.model.DadosCarros;
import br.com.auto_fipe.model.DadosMotos;
import br.com.auto_fipe.service.ConsumoApi;
import br.com.auto_fipe.service.ConverteDados;

import java.util.List;
import java.util.Scanner;

public class Main {
    private final Scanner scanner = new Scanner(System.in);
    private final ConsumoApi consumoApi = new ConsumoApi();
    private final ConverteDados converteDados = new ConverteDados();
    private final String BASE_ENDERECO = "https://parallelum.com.br/fipe/api/v1/";

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

            switch (opcaoAutomovel.toLowerCase()) {
                case "carro" -> {
                    String urlMarcas = exibirMarcas("carros", DadosCarros.class);
                    exibirModelos("carros", DadosCarros.class, urlMarcas);
                }
                case "moto" -> {
                    String urlMarcas = exibirMarcas("motos", DadosMotos.class);
                    exibirModelos("motos", DadosMotos.class, urlMarcas);
                }
                case "caminhao" -> {
                    String urlMarcas = exibirMarcas("caminhoes", DadosCaminhoes.class);
                    exibirModelos("caminhoes", DadosCaminhoes.class, urlMarcas);
                }
                case "sair" -> {
                    System.out.println("Saindo do programa...");
                    return;
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private String exibirMarcas(String tipo, Class<?> classe) {
        String urlMarcas = BASE_ENDERECO + tipo + "/marcas/";
        String jsonMarcas = consumoApi.obterDados(urlMarcas);
        List<?> marcas = converteDados.obterDados(jsonMarcas, classe);
        marcas.forEach(System.out::println);
        System.out.println(urlMarcas);
        return urlMarcas;
    }

    System.out.print("\nSelecione o código da marca desejada: ");
    int codigoMarca = scanner.nextInt();

    private String exibirModelos(int codigoMarca, Class<?> classe, String urlMarcas) {
        String urlModelos = urlMarcas + codigoMarca + "/modelos/";
        String jsonModelos = consumoApi.obterDados(urlModelos);
        System.out.println(jsonModelos);
        List<?> modelos = converteDados.obterDados(jsonModelos, classe);
        modelos.forEach(System.out::println);
        return urlModelos;
    }

    public static void main(String[] args) {
        new Main().exibeMenu();
    }
}
