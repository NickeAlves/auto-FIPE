package br.com.auto_fipe.service;

import java.util.List;

public interface IConverteDados {
    <T> List<T> obterDados(String json, Class<T> classe);
}
