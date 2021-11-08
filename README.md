# BlueBank
O BlueBank é uma API desenvolvida utilizando SpringBoot para criação e transação de contas bancárias.

# API Endpoints

## Clientes
`POST /api/cliente`
```
    {
        "nome":"string",
        "pessoa":"string",
        "status":"string",
        "endereco":"string",
        "email":"string",
        "telefone":"string",
        "celular":"string",
        "cgc":"string"
    }
```

`POST /api/cliente/listar`
```
    {
        "id": 0,
        "nome":"string",
        "pessoa":"string",
        "status":"string",
        "endereco":"string",
        "email":"string",
        "telefone":"string",
        "celular":"string",
        "cgc":"string"
    }
```

## Contas
`POST /api/contas`
```
    {
        "idcliente": 0,
        "numagencia":"string",
        "nomeagencia":"string",
        "numconta":"string",
        "nomeconta":"string",
        "saldoinicial":0
    }
```

`POST /api/contas/listar`
```
    {
        "id": 0,
        "idcliente": 0,
        "numagencia":"string",
        "nomeagencia":"string",
        "numconta":"string",
        "nomeconta":"string"
    }
```

## Lançamentos
`POST /api/lancamento`
```
    {
        "idcliente": 0,
        "idconta": 0,
        "data_evento":"string",
        "tipo":"string",
        "motivo":"string",
        "valor": 0
    }
```

`POST /api/lancamento/listar`
```
    {
        "id": 0,
        "idcliente": 0,
        "idconta": 0,
        "data_evento":"string",
        "tipo":"string",
        "motivo":"string",
        "valor": 0
    }
```

## Transferências
`POST /api/transferencia`
```
    {
        "idcontaprincipal": 0,
        "idcontafavorecido": 0,
        "valor": 0
    }
```
