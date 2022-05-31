| HTTP method | URL path                        | HTTP status code | description                                |   |
|-------------|---------------------------------|------------------|--------------------------------------------|---|
| GET         | localhost:8080/project/customer | 200              | returns all the customers                  |   |
| GET         | localhost:8080/project/customer/{id} | 200              | return the customer that has a specific id |   |
| POST        | localhost:8080/project/customer  | 200              | save a customer                            |   |
|PUT          |localhost:8080/project/customer/{id}|200| update a customer                          |
|DELETE|localhost:8080/project/customer/{id}|200| delete a customer                          |
##for the order:
| HTTP method | URL path                          | HTTP status code | description                             |   |
|-------------|-----------------------------------|------------------|-----------------------------------------|---|
| GET         | localhost:8080/project/order      | 200              | returns all the orders                  |   |
| GET         | localhost:8080/project/order/{id} | 200              | return the order that has a specific id |   |
| POST        | localhost:8080/project/order      | 200              | save an order                           |   |
|PUT          | localhost:8080/project/order/{id} |200| update an order                         |
|DELETE| localhost:8080/project/order/{id} |200| delete an order                         |

##for the product:
| HTTP method | URL path                          | HTTP status code | description                               |   |
|-------------|-----------------------------------|------------------|-------------------------------------------|---|
| GET         | localhost:8080/project/product    | 200              | returns all the products                  |   |
| GET         | localhost:8080/project/product/{id} | 200              | return the product that has a specific id |   |
| POST        | localhost:8080/project/product      | 200              | save an product                             |   |
|PUT          | localhost:8080/project/product/{id} |200| update a product                          |
|DELETE| localhost:8080/project/product/{id} |200| delete a product                          |

##for the product order:
| HTTP method | URL path                          | HTTP status code | description                                    |   |
|-------------|-----------------------------------|------------------|------------------------------------------------|---|
| GET         | localhost:8080/project/productOrder    | 200              | returns all the productOrders                  |   |
| GET         | localhost:8080/project/productOrder/{id} | 200              | return the productOrder that has a specific id |   |
| POST        | localhost:8080/project/productOrder      | 200              | save an productOrder                           |   |
|PUT          | localhost:8080/project/productOrder/{id} |200| update a productOrder                          |
|DELETE| localhost:8080/project/productOrder/{id} |200| delete a productOrder                          |

##for the stock:
| HTTP method | URL path                          | HTTP status code | description                                    |   |
|-------------|-----------------------------------|------------------|------------------------------------------------|---|
| GET         | localhost:8080/project/stock    | 200              | returns all the stock                  |   |
| GET         | localhost:8080/project/stock/{id} | 200              | return the stock that has a specific id |   |
| POST        | localhost:8080/project/stock      | 200              | save an stock                           |   |
|PUT          | localhost:8080/project/stock/{id} |200| update a stock                          |
|DELETE| localhost:8080/project/stock/{id} |200| delete a stock                          |

## for building the project, use maven
## for creating docker images, use docker build -t imageName .
## for running the docker images, use docker run -p 9092:9091 imageName
##https://hub.docker.com/repository/docker/mohadra123/project_2
