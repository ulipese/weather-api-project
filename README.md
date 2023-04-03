# weather-api-project - PAM

## Nome da dupla
Felipe Sene Souza - 3DS <br>
Felipe Sousa de Oliveira - 3DS

## Documentação da API
[OpenWeather API](https://openweathermap.org/current#name)

## URL de acesso da API
https://api.openweathermap.org/data/2.5

## Endpoints e parâmetros da API
.../roadrisk?lat={latitude}&lon={longitude}&dt={date and time}&appid={API key} - esse endpoint é o segundo mais utilizado na API, porém, não atende ao uso da aplicação;
<br>
.../weather?q={city name}&appid={API key} - esse endpoint será usado na aplicação, appid é onde será passado a API key do usuário ou empresa, para autenticação na api;
<br>
.../weather?q={city name}&appid={API key}&mode={xml} - o mode diz como será o formato da resposta, o padrão é json, mas tem html e xml também;
<br>
.../weather?q={city name}&appid={API key}&units={metric} - units diz a unidade que será usada para mostrar as informações do clima, existe standard (padrão), metric e imperial;
<br>
.../weather?q={city name}&appid={API key}&lang={language} - lang referencia a linguagem desejada dos dados, como "pt_br".

## Quais dados serão usados na aplicação
São retornados os seguintes dados pela chamada da API no endpoint que será usado: coord, weather, base, main, visibility, wind, rain, clouds, dt, sys, timezone, id, name, cod.    <br>                               
Dos dados retornados pelo endpoint, serão usados: country, name (da cidade), weather, temp_min, temp, temp_max, humidity, clouds.
