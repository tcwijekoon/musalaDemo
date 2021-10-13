# musalaDemo

How to run the Demo
--------------------
Open project using IDE (Intellij idea)

download required maven dependencies

Apply required username, password and database changes in below file

    src/main/resources/application.properties

Run the application


How to test the Demo
--------------------
Open Postman Application

import attached postman collection

Execute each request and check

postman collection json
------------------------
{
"info": {
"_postman_id": "98179a7e-5598-43b2-9189-3cd8bb1d478c",
"name": "musala",
"description": "musala",
"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
},
"item": [
{
"name": "gateway-getall",
"request": {
"method": "GET",
"header": [],
"url": {
"raw": "localhost:8080/musala/gateway/getAll",
"host": [
"localhost"
],
"port": "8080",
"path": [
"musala",
"gateway",
"getAll"
]
}
},
"response": []
},
{
"name": "gateway-create",
"request": {
"method": "POST",
"header": [
{
"key": "Content-Type",
"value": "application/json"
}
],
"body": {
"mode": "raw",
"raw": "{\n\t\n\t\"serial\":\"12345673\",\n\t\t\"name\":\"test\",\n\t\t\t\"ip\":\"192.168.1.2\"\n}"
},
"url": {
"raw": "localhost:8080/musala/gateway/create",
"host": [
"localhost"
],
"port": "8080",
"path": [
"musala",
"gateway",
"create"
]
}
},
"response": []
},
{
"name": "device-create",
"request": {
"method": "POST",
"header": [
{
"key": "Content-Type",
"value": "application/json"
}
],
"body": {
"mode": "raw",
"raw": "{\n\t\"serial\":\"12345673\",\n    \"name\":\"test\",\n    \"ip\":\"192.168.1.2\"\n}"
},
"url": {
"raw": "localhost:8080/musala/device/create",
"host": [
"localhost"
],
"port": "8080",
"path": [
"musala",
"device",
"create"
]
}
},
"response": []
},
{
"name": "gateway-get-by-id",
"request": {
"method": "GET",
"header": [],
"url": {
"raw": "localhost:8080/musala/gateway/2",
"host": [
"localhost"
],
"port": "8080",
"path": [
"musala",
"gateway",
"2"
]
}
},
"response": []
},
{
"name": "device-by-gatewayId",
"request": {
"method": "GET",
"header": [],
"url": {
"raw": "localhost:8080/musala/device/gateway/1",
"host": [
"localhost"
],
"port": "8080",
"path": [
"musala",
"device",
"gateway",
"1"
]
}
},
"response": []
},
{
"name": "device-delete",
"request": {
"method": "DELETE",
"header": [],
"url": {
"raw": "localhost:8080/musala/device/1",
"host": [
"localhost"
],
"port": "8080",
"path": [
"musala",
"device",
"1"
]
}
},
"response": []
}
]
}
