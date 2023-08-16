# phone-directory
A Spring boot service with phone directory API's.

Instructions to build and execute:
1. Make sure you have java 17 downloaded.
2. Clone the latest code from master branch.
3. Run maven clean, install from desired IDE.
4. Edit Run Configurations by choosing the Main class.
5. Run the application.
6. Once the Tomcat server is up on port 8080, hit below mentioned Api's from Postman.

List of API's:
v1/contacts - GET - To get all existing contacts from directory
v1/contacts - POST - To save a new contact to directory
v1/contacts/{id} - GET - Get contact by Id
v1/contacts/{name} - GET - Get contact by Name
v1/contacts/{id} - PUT - Update an existing contact
v1/contacts/{id} - DELETE - Delete existing contact

Sample request url for GET: http://localhost:8080/v1/contacts

Sample request url for POST: http://localhost:8080/v1/contacts
request body: 
{
    "name":"test10",
    "phoneNumber": "1234567890",
    "email": "test@test"
}


