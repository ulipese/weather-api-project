package com.example.wapp;

import android.net.Uri;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Connection {
    private static final String LOG_TAG = Connection.class.getSimpleName();
    // Constantes utilizadas pela API
    // URL para a API de Livros do Google.
    private static final String WEATHER_URL = "https://wapp.up.railway.app/weather/";
    // Parametros da string de Busca
    private static final String QUERY_PARAM = "name";

    static String buscaTempo(String queryString) {
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String tempoJSONString = null;
        try {
            // Construção da URI de Busca
            Uri builtURI = Uri.parse(WEATHER_URL).buildUpon()
                    .appendQueryParameter(QUERY_PARAM, queryString)
                    .build();
            // Converte a URI para a URL.
            URL requestURL = new URL(builtURI.toString());
            // Abre a conexão de rede
            urlConnection = (HttpURLConnection) requestURL.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            // Busca o InputStream.
            InputStream inputStream = urlConnection.getInputStream();
            // Cria o buffer para o input stream
            reader = new BufferedReader(new InputStreamReader(inputStream));
            // Usa o StringBuilder para receber a resposta.
            StringBuilder builder = new StringBuilder();
            String linha;
            while ((linha = reader.readLine()) != null) {
                // Adiciona a linha a string.
                builder.append(linha);
                builder.append("\n");
            }
            if (builder.length() == 0) {
                // se o stream estiver vazio não faz nada
                return null;
            }
            tempoJSONString = builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // fecha a conexão e o buffer.
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        // escreve o Json no log
        Log.d(LOG_TAG, tempoJSONString);
        return tempoJSONString;
    }
}
