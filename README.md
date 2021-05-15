# API Rest Service Testing Exercise

A good API service for testing purposes can be found here:

[https://petstore.swagger.io](https://petstore.swagger.io)

The task is to write a Java client that has one method: 
```java
getPetsByStatus(PetStatus peStatus)
```

and uses the following REST endpoint:

[https://petstore.swagger.io/#/pet/findPetsByStatus](https://petstore.swagger.io/#/pet/findPetsByStatus)

When you have done this write a Cucumber BDD test that uses the method you created to get the JSON response payload and validate how many pets have the status “available” and the name “doggie”.

## Additional Notes:

- The number of pets returned from the live service may vary so it doesn’t matter if the test actually passes, so long as the failure is readable.

- If for any reason the swagger service was down, please use the json response file included with this pack and instead of a client that calls a REST API make the client just read the file and return contents as a JSON string.  The test can then perform the same validation as described above.

- As an additional challenge, provide a mocking service like Wiremock to return the JSON payload instead of the live swagger service controlled by a flag. (This is optional for this exercise)

- Provide logging and readable test reports for this exercise.