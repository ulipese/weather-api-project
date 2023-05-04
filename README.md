# weather-api-project - PAM II

## Nome da dupla
Felipe Sene Souza - 3DS <br>
Felipe Sousa de Oliveira - 3DS

## Documentação da API
[OpenWeather API](https://openweathermap.org/current#name)

## URL de acesso da API
https://api.openweathermap.org/data/2.5

## Endpoints e parâmetros da API

| Endpoints (principais)  | Parâmetros                                              | Método      |
| ------------------------| --------------------------------------------------------|-------------|
|/roadrisk                | ?appid={token}&lat={latitude}&lon={longitude}           | GET         |
|/weather                 | ?appid={token}&q={city name},{state code},{country code}| GET         |         
|/forecast/climate        | ?appid={token}&lat={latitude}&lon={longitude}           | GET         |
|/forecast/hourly         | ?appid={token}&lat={latitude}&lon={longitude}           | GET         |
|/forecast/daily          | ?appid={token}&lat={latitude}&lon={longitude}           | GET         |

#### A endpoint que será usada na aplicação será a /weather, por ser a endpoint mais completa e a que mais atende as nossas necessidades.

## Quais dados serão usados na aplicação
São retornados os seguintes dados pela chamada da API no endpoint que será usado: coord, weather, base, main, visibility, wind, rain, clouds, dt, sys, timezone, id, name, cod.    <br>                               
Dos dados retornados pelo endpoint, serão usados: country, name (da cidade), rain, weather, temp. Veja abaixo um exemplo de retorno da rota /weather, sobre o clima atual da cidade de Londres.
```json
{
  "coord": {
    "lon": -0.1257,
    "lat": 51.5085
  },
  "weather": [
    {
      "id": 800,
      "main": "Clear",
      "description": "clear sky",
      "icon": "01n"
    }
  ],
  "base": "stations",
  "main": {
    "temp": 278.92,
    "feels_like": 276.19,
    "temp_min": 276.27,
    "temp_max": 280.01,
    "pressure": 1018,
    "humidity": 84
  },
  "visibility": 10000,
  "wind": {
    "speed": 3.6,
    "deg": 300
  },
  "clouds": {
    "all": 7
  },
  "dt": 1680830331,
  "sys": {
    "type": 2,
    "id": 2075535,
    "country": "GB",
    "sunrise": 1680844983,
    "sunset": 1680892922
  },
  "timezone": 3600,
  "id": 2643743,
  "name": "London",
  "cod": 200
}
```

# Descrição da aplicação:
O aplicativo trará informações específicas sobre o clima atual ou de uma região escolhida pelo usuário. Podendo também favoritar uma área de interesse para próximas visualizações.
As informações mostradas serão: Nome da região, data, hora, temperatura, clima (com ícones para melhor informação visual).
Telas: Histórico de pesquisas anteriores (permitindo selecionar uma região que levará à tela principal com as informações climáticas daquele local), tela principal (com as informações do local atual do usuário), detalhes de cada clima(explicando o significado de cada ícone).

# Protótipo e mapa de navegação:
<center>![image](https://user-images.githubusercontent.com/91497871/236342488-95ceb084-47cc-4e2e-83cb-3b5aad3cbf53.png)</center>

# Diagrama de classes:
![image](https://user-images.githubusercontent.com/91497871/236342698-276a5386-53aa-4263-982a-1bad0234fc7b.png)</center>

# Diagrama do banco de dados local:
![image](https://user-images.githubusercontent.com/91497871/236342750-add4da86-7c56-4d0b-8291-0ca36a8d0fc0.png)</center>
