# product-management
This project is made using spring boot version (3.1.x).
It exposes three endpoints for viewing, inserting and deleting a product.

Setup Guide:
Run the Docker Image using the following command. Use port 8080 for running the container.
docker run -p 8081:8081 -d --name product-management-c zazhar/product_management-app

Create Product:
url: http://127.0.0.1:8081/api/products/add
body format: {
{
    "productId" : 18,
    "productName" : "TestProd4",
    "quantity" : 1,
    "price" : 12
}

Delete Product:
url: http://127.0.0.1:8081/api/products/delete
body format: {
{
    "productId" : 18
}

List All Products:
url: http://127.0.0.1:8081/api/products/index
body format: none
