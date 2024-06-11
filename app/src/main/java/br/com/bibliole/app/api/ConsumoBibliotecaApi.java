package br.com.bibliole.app.api;

import br.com.bibliole.app.model.LivroRespostaApi;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoBibliotecaApi {
    private final HttpClient clienteHttp = HttpClient.newHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public LivroRespostaApi buscarLivros (String parametroBusca) throws Exception {
        HttpRequest requisicao = HttpRequest.newBuilder()
                .uri(URI.create(parametroBusca))
                .build();

        HttpResponse<String> resposta = clienteHttp.send(requisicao, HttpResponse.BodyHandlers.ofString());

        return objectMapper.readValue(resposta.body(), LivroRespostaApi.class);
    }
}
