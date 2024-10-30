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
        System.out.println(" Bem-vindo(a) ao Auto-FIPE! ");
        System.out.println("""
                Opções disponíveis:
                - Carro
                - Moto
                - Caminhão
                """);
        System.out.print("Digite a opção desejada: ");
        var opcaoAutomovel = scanner.nextLine();

        switch (opcaoAutomovel.toLowerCase()) {
            case "carro" -> exibirDados("carros", DadosCarros.class);
            case "moto" -> exibirDados("motos", DadosMotos.class);
            case "caminhao" -> exibirDados("caminhoes", DadosCaminhoes.class);
            default -> System.out.println("Opção inválida!");
        }

        private <T> void exibirDados(String tipo, Class<T> classe) {
            try{
                String json = consumoApi.obterDados(BASE_ENDERECO + opcaoAutomovel + "/marcas/");
                List<T> marcas = converteDados.obterDados(json, classe);
            }
        }
    }

}
