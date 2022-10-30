**For mocking soap api:**\

_Download Tool From(soap ui)_: https://www.soapui.org/

_Provided WSDL:_ [soap-api.xml](./src/main/resources/wsdl/soap-api.xml)

_Reference for creating mock api:_ https://www.softwaretestinghelp.com/soapui-mock-service-and-dynamic-response/

**Application tech:**

Gradle\
WebFlux\
H2 DB\
Jpa\
Java 11

**Application Flow:**

**DTOs:**\
MessageRequestDto: Structures request

`{
"id": 5,
"message":"test"
}`

MessageResponseDto: Structures Response

`{
"id": 5
}`

MessageEntity: Database Object for saving message in db

**MessageController** 

**POST:** _/message_ (for saving message and id to db) 
   
**GET:** _/get_message_ (for testing records in db)

**MessageService**

* _saveMessage_: Takes MessageRequestDto as parameter and performs save operation on db if soap api call get success
* _getWebClient_: Creates webflux client.
* _getRequest_: Crates request xml for passing in soap api call as body.
* _soapApiCall_: Makes soap api call and returns response
* _getMessages_: Get all messages( testing purpose )
    






