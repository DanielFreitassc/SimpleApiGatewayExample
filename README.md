# API Gateway Example Documentation

## Estrutura do Projeto

Este projeto contém um API Gateway que redireciona requisições para uma API de exemplo. O Gateway é configurado para encaminhar requisições para um serviço em execução em `http://localhost:8081/`.

## Configuração do Gateway

A configuração do Gateway é feita no arquivo `application.yml` e inclui a definição de rotas e filtros.

```yaml
backend-name: gateway
spring:
  cloud:
    gateway:
      routes:
        - id: first-api-example
          uri: http://localhost:8081/
          predicates:
            - Path=/request
          filters:
            - SetPath=/example-api
```

### Detalhes da Configuração

- **backend-name**: Define o nome do backend do gateway.
- **spring.cloud.gateway.routes**: Define as rotas que o gateway irá gerenciar.
  - **id**: Um identificador único para a rota (neste caso, `first-api-example`).
  - **uri**: O endereço do serviço de backend que irá receber as requisições.
  - **predicates**: Condições que devem ser satisfeitas para que a rota seja ativada.
    - **Path**: Define que a rota será ativada para requisições que correspondem ao caminho `/request`.
  - **filters**: Filtros aplicados às requisições que passam pela rota.
    - **SetPath**: Modifica o caminho da requisição antes de encaminhá-la para o serviço de backend, neste caso, alterando o caminho para `/example-api`.

## API de Exemplo

O serviço de backend que responde às requisições redirecionadas pelo Gateway está definido na classe `ApiTestController`.

```java
package com.danielfreitassc.api_example.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example-api")
public class ApiTestController {
    
    @GetMapping
    public String getHello(@RequestParam String message) {
        return message;
    }
}
```

### Detalhes do Endpoint

- **URL**: `/example-api`
- **Método**: `GET`
- **Parâmetros de Consulta**:
  - `message` (string) - A mensagem que será retornada na resposta.

- **Resposta**:
  - `200 OK` - Retorna a mensagem enviada no parâmetro `message`.

### Exemplo de Requisição

Para fazer uma requisição para o API Gateway, você deve chamar:

```
GET /request?message=HelloWorld
```

### Exemplo de Resposta

```yml

 HelloWorld

```


## Observações

Este exemplo demonstra como configurar um API Gateway com Spring Cloud Gateway para redirecionar requisições para um serviço de backend. Você pode expandir a configuração para incluir mais rotas, filtros e integrações com outros serviços conforme necessário.

