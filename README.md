---------API Dökümantasyon----------------

base URI: http://localhost:8080/api


_________________________________
/////Havayolları//////

GET all airlines: http://localhost:8080/api/airline     \n
GET airlines by id: http://localhost:8080/api/airline?id={id}   \n
GET airlines by code: http://localhost:8080/api/airline?code={code}   \n
POST airline: http://localhost:8080/api/airline

________________________________
/////Havaalanları/////

GET all airports: http://localhost:8080/api/airport
GET airport by id: http://localhost:8080/api/airport?id={id}
GET airport by code: http://localhost:8080/api/airport?code={code}

POST airport: http://localhost:8080/api/airport

_______________________________
/////Rotalar/////

GET all routes: http://localhost:8080/api/route
GET route by id: http://localhost:8080/api/route?id={id}

POST route: http://localhost:8080/api/route

_______________________________
/////Uçuşlar/////

GET all flights: http://localhost:8080/api/flight
GET flight by id: http://localhost:8080/api/flight/?id={id}
GET flight by airline code: http://localhost:8080/api/flight?airline={airlineCode}
GET flight by departure airport code: http://localhost:8080/api/flight?departure={fromAirportCode}
GET flight by destination airport code: http://localhost:8080/api/flight?dest={toAirportCode}

POST flight: http://localhost:8080/api/flight

________________________________
/////Satın Alma/////

POST buyout: http://localhost:8080/api/buyout

_______________________________
/////Biletler//////

GET tickets: http://localhost:8080/api/ticket
GET ticket by id: http://localhost:8080/api/ticket?id={id}

DEL ticket by id: http://localhost:8080/api/ticket?id={id}

