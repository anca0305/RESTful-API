# RESTful-API
Implementation of RESTful API using Spring Boot and Bearer

# Quick Demo
[YouTube Video](https://www.youtube.com/watch?v=fTmU94QvHcQ&feature=youtu.be)

# Dependencies
- Maven
- Spring Boot 2.3.0
- JDK 14
- Spring Web
- jjwt
- Bearer

# Description

| Request Type  | Endpoint | Request Body | Purpose |
| ------------- | ------------- | ------------- | ------------- |
| POST  | {url}/Store/Register  | { "username: "user", "password" : "password" }  | Creates an user  |
| POST  | {url}/Store/Login  | { "username: "user", "password" : "password" }  | Main purpose for loggin in. It will return a Bearer token!  |
| POST  | {url}/Store/MyStore/Products  | { "name: "name", "price" : "price", "category" : "category" }  | Adds a product to the list!  |
| PUT  | {url}/Store/MyStore/Products/Id={id}  | { "name" : "name" } OR { "price" : "price" } OR  { "category" : "category" } | Updates the product with the id with a new name/category/price  |
| GET  | {url}/Store/MySotre/Products  | -  | Retrieves the list with products  |
| GET  | {url}/Store/MyStore/Products/Id={id}  | -  | {id} needs to be replaced with the wanted it. It will return the product with that id!  |
| GET  | {url}/Store/MyStore/Products/Category={category}  | -  | {category} has to be replaced with searched category. It will return a list with products in that category!  |
| GET  | {url}/Store/MyStore/Products/Name={Name}  | -  | {name} has to be replaced with searched name. It will return the info for the product with that name!  |
| DELETE  | {url}/Store/MyStore/Products/{id}  | -  | Deletes the product with that id!  |


The program has been written in Java, using IntelliJ IDEA and testing with Postman.

I tried to do my program user friendly (with intuitive messages).
