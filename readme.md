# API para consulta de entregas

Esta API tem como objetivo cálcular o preço do frete e verificar a data prevista da entrega.


### Consultar frete e verificar a data prevista da entrega
```http
POST http://localhost:8080/encomendas
```
Enviando como corpo o JSON:
```javascript
{
    "cepOrigem": "18035-645",
        "cepDestino": "18603-730",
        "nomeDestinatario": "João Guilherme",
        "peso": 100
}
```
Obteremos como resposta:
```javascript
{
    "cepOrigem": "01009-999",
        "cepDestino": "01009-999",
        "nomeDestinatario": "João Guilherme",
        "vlTotalFrete": 50.0,
        "dataPrevistaEntrega": "2022-02-08"
}
```
### Buscando todas as entregas
```http
GET http://localhost:8080/encomendas
```
Obteremos como resposta:
```javascript
[
    {
        "peso": 100.0,
        "cepOrigem": "01009-999",
        "cepDestino": "01009-999",
        "nomeDestinatario": "João Guilherme",
        "vlTotalFrete": 50.0,
        "dataPrevistaEntrega": "2022-02-08",
        "dataConsulta": "2022-02-07"
    }
]
```

The `message` attribute contains a message commonly used to indicate errors or, in the case of deleting a resource, success that the resource was properly deleted.

The `success` attribute describes if the transaction was successful or not.

The `data` attribute contains any other metadata associated with the response. This will be an escaped string containing JSON data.

## Status Codes

Gophish returns the following status codes in its API:

| Status Code | Description |
| :--- | :--- |
| 200 | `OK` |
| 201 | `CREATED` |
| 400 | `BAD REQUEST` |
| 404 | `NOT FOUND` |
| 500 | `INTERNAL SERVER ERROR` |
