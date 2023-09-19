package com.example.wapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.mbms.StreamingServiceInfo;
import android.util.Log;
import android.view.View;

import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {

    private EditText nmSearch;
    private TextView nmTemp, nmHumidity;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Intent permissions = new Intent(this, PermissionsActivity.class);
            startActivity(permissions);
            finish();
        }

        // Recebe a informação da intent anterior
        Intent intentDisplay = getIntent();
        //String messageDisplay = intentDisplay.getStringExtra(Widget.EXTRA_MESSAGE);

        nmSearch = findViewById(R.id.txtSearch);
        nmTemp = findViewById(R.id.txtTemp);
        nmHumidity = findViewById(R.id.txtHumidity);
        if (LoaderManager.getInstance(this).getLoader(0) != null) {
            LoaderManager.getInstance(this).initLoader(0, null, this);
        }

        MainActivity buscaWeather = new MainActivity();

        //nmSearch.setText(messageDisplay);

    }

    public void buscaWeather(View view){
        // Recupera a string de busca.
        String queryString = nmSearch.getText().toString();
        // esconde o teclado qdo o botão é clicado
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputManager != null) {
            inputManager.hideSoftInputFromWindow(view.getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }

        // Verifica o status da conexão de rede
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = null;
        if (connMgr != null) {
            networkInfo = connMgr.getActiveNetworkInfo();
        }
        /* Se a rede estiver disponivel e o campo de busca não estiver vazio
         iniciar o Loader CarregaLivros */
        if (networkInfo != null && networkInfo.isConnected()
                && queryString.length() != 0) {
            Bundle queryBundle = new Bundle();
            queryBundle.putString("queryString", queryString);
            LoaderManager.getInstance(this).restartLoader(0, queryBundle, this);
        }

        // atualiza a textview para informar que não há conexão ou termo de busca
        else {
            if (queryString.length() == 0) {
                Toast.makeText(MainActivity.this, "Termo inválido", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Verifique a conexão", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        String queryString = "";
        if (args != null) {
            queryString = args.getString("queryString");
        }
        return new WeatherApi(this, queryString);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
        JSONObject weather = null;
        try {
            // Converte a resposta em Json
            JSONObject jsonObject = new JSONObject(data);
            // Obtem o JSONArray dos itens
            JSONArray itemsArray = jsonObject.getJSONArray("main");
            weather = jsonObject.getJSONObject("main");
            // inicializa o contador
            int i = 0;
            int a = 1;

            String temperatura = null;
            String humidity = null;


            // Procura pro resultados nos itens do array
            while (i < itemsArray.length() &&
                    (humidity == null)) {
                // Obtem a informação

                Log.v("ERRO APLICAÇÃO", String.valueOf(itemsArray));

                weather = jsonObject.getJSONObject("main");

                JSONArray tempInfo = weather.getJSONArray("temp_min");
                JSONArray humidityInfo = weather.getJSONArray("humidity");


                //  Obter temperatura e humidade para o item,
                // erro se o campo estiver vazio
                try {
                    temperatura = weather.getString("temp_min");
                    humidity = weather.getString("humidity");
                    //humidity = volumeInfo.getString(0);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
                // move para a proxima linha
                i++;
            }
            //mostra o resultado qdo possivel.
            if (temperatura != null) {
                nmTemp.setText(temperatura);
                nmHumidity.setText(humidity);
                //picasso serve carregar a imagem
                //Picasso.get().load(imagem).into(nmImagem);
                //Picasso.get().load(imagem2).into(nmImagem2);


            } else {
                Toast.makeText(MainActivity.this, "Resultado não encontrado", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            // Se não receber um JSOn valido, informa ao usuário
            //nmHumidtiy.setText("deu");
            //nmtemp.setText("errado");
        }


    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {
        // obrigatório implementar, nenhuma ação executada
    }







    public void goInfo (View view) {
        Intent info = new Intent(this, InfoActivity.class);
        startActivity(info);
        finish();
    }
    public void goHistory (View view) {
        Intent history = new Intent(this, HistoryActivity.class);
        startActivity(history);
        finish();
    }
    public void goHome (View view) {
        Intent home = new Intent(this, MainActivity.class);
        startActivity(home);
        finish();
    }


}