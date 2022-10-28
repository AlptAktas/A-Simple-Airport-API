# **API Dökümantasyon**
___

**Base URI:** http://localhost:8080/api

___
## **Havayolları**


- **GET all airlines:** http://localhost:8080/api/airline

- **GET airlines by id:** http://localhost:8080/api/airline/id={id}

- **GET airlines by code:** http://localhost:8080/api/airline/code={code}

- **POST airline:** http://localhost:8080/api/airline

Örnek:

```
{
    "name": "Sun Express",  //airline name
    "code": "XQ"    //airline code
}
```

___
## **Havaalanları**


- **GET all airports:** http://localhost:8080/api/airport

- **GET airport by id:** http://localhost:8080/api/airport/id={id}

- **GET airport by code:** http://localhost:8080/api/airport/code={code}

- **POST airport:** http://localhost:8080/api/airport

Örnek:

```
{
    "name": "Bodrum Havalimanı",    //airport name
    "code": "BJV"   //airport code
}
```
___
## **Rotalar**


- **GET all routes:** http://localhost:8080/api/route

- **GET route by id:** http://localhost:8080/api/route/id={id}

- **POST route:** http://localhost:8080/api/route

Örnek:

```
{
    "fromAirportCode": "SAW",   //departure airport code
    "toAirportCode": "BJV"  //destination airport code
}
```

___
## **Uçuşlar**


- **GET all flights:** http://localhost:8080/api/flight

- **GET flight by id:** http://localhost:8080/api/flight/id={id}

- **GET flight by airline code:** http://localhost:8080/api/flight/airline={airlineCode}

- **GET flight by departure airport code:** http://localhost:8080/api/flight/departure={fromAirportCode}

- **GET flight by destination airport code:** http://localhost:8080/api/flight/dest={toAirportCode}

- **POST flight:** http://localhost:8080/api/flight

Örnek:

```
{
    "airlineCode":"PGS",        //airline code
    "flightNumber":"PGS501",    //flight number
    "fromAirportCode": "IST",   //departure airport code
    "toAirportCode": "SAW",     //destination airport code
    "capacity": "19",           //capacity
    "price": "1000"             //price
}
```

___
## **Satın Alma**


- **POST buyout:** http://localhost:8080/api/buyout

Örnek:

```
{
    "flightNumber": "PGS501",               //flight number
    "cardHolderName": "apppals",            //card holder name
    "cardNumber":"bmö1231923ycc12372137a",  //card number
    "lastDate": "22.10.22",                 //card last valid date
    "cv":"213"                              //cv???
}
```

___
## **Biletler**


- **GET tickets:** http://localhost:8080/api/ticket

- **GET ticket by id:** http://localhost:8080/api/ticket/id={id}

- **DEL ticket by id:** http://localhost:8080/api/ticket/id={id}

