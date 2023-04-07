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

## A endpoint que será usada na aplicação será a /weather, por ser a endpoint mais completa e a que mais atende as nossas necessidades.

## Quais dados serão usados na aplicação
São retornados os seguintes dados pela chamada da API no endpoint que será usado: coord, weather, base, main, visibility, wind, rain, clouds, dt, sys, timezone, id, name, cod.    <br>                               
Dos dados retornados pelo endpoint, serão usados: country, name (da cidade), weather, temp_min, temp, temp_max, humidity, clouds.
```json
{
  "response": "",
  "results-for": "",
  "results": [
    {
      "id": "",
      "name": "B",
      "powerstats": {
        "intelligence": "",
        "strength": "",
        "speed": "",
        "durability": "",
        "power": "",
        "combat": ""
      },
      "biography": {
        "full-name": "",
        "alter-egos": "",
        "aliases": [
          ""
        ],
        "place-of-birth": "",
        "first-appearance": "",
        "publisher": "",
        "alignment": ""
      },
      "appearance": {
        "gender": "",
        "race": "",
        "height": [
          "",
          ""
        ],
        "weight": [
          "",
          ""
        ],
        "eye-color": "",
        "hair-color": ""
      },
      "work": {
        "occupation": "",
        "base": ""
      },
      "connections": {
        "group-affiliation": "",
        "relatives": ""
      },
      "image": {
        "url": ""
      }
    }
```
