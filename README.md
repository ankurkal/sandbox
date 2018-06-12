# MD101 - Step 5: Creating new users

In this step, we will get an introduction on what a _POST_ request is, in the context of _REST_. By the end of this lesson,
you will be able to create new users for our service via _HTTP_ and _REST_.

## Introducing HTTP POST for creation

Create new resources. _POST_ must be used to create a new resource in a collection. The _POST_ request's body contains the suggested state representation
of the new resource to be added to the server collection.

The _POST_ method is used to invoke the function-oriented controller resources. The _POST_ request may include both 
the headers and a body as inputs to a controller resource's function. When the request is sent to the server, it is intercepted
by the controller. The controller is in charge of curating as well as any transformation that is needed for the data being passed.
In our exercise for the _UserController_ we are going to notice that the _ID_ property is not passes in the body of the _POST_
request, but it is added inside the _createUser_ method.

This behavior can be seen in the following diagram:
![Rest Diagram](images/Post.png "HTTP REST Request")

HTTP calls the _POST_ request method to be _unsafe_ and _non-idempotent_, which means that its outcome is unpredictable
and not guaranteed to be repeatable without potentially undesirable side effects.

## Updating the controller and the service to handle creating users
Creating a new user.
```POST /user```

### Adding a POST action to our _UserController_ 
In order to handle the _POST_ request. Our controller must have the following changes:

```
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(final UserService userService){
        this.userService = userService;
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<User> createUser(@RequestBody @Valid final UserDetails user){
        final User createdUser = this.userService.createUser(user);
        
        return new ResponseEntity<User>(createdUser, HttpStatus.CREATED);
    }
}
```

First thing to notice is that we add a new method `createUser` to our controller (this will be our _RequestHandlerMethod_). We add the annotation with a new
`RequestMehod`, now implementing a _POST_ action.


One very important thing to notice is that, our controller is only acting as a broker. It only creates the interaction between the data that 
is being passed in, and the business logic (in this case the _UserService_).

## Handling the ID field
TODO: We want to generate a random uuid for our user id, User/UserDetails objects, and how users shouldnt need to pass this field

## Validating our request
Next thing to notice, is that our `createUser` method is taking a `user` input and adding some validations (`@Valid` annotation) against our `UserDetails` POJO.
This is really helpful since spring will make sure that the data being passed meets the requirements, comparing them to a given class.

If we look into our `UserDetails` class, we will find a new Spring annotation, the `@NotNull` annotation. This will make sure that for any of 
those values where the annotiation is set, there will be a corresponding not-null value.

## Updating our tests
In previous chapters we got an introduction to unit and integration testing for our Spring application. In order to test our _POST_ action, 
we are going to use the same dependencies and frameworks (_SpringBootTest, Mockito, JUnit_), if you are not familiar with the basic usage of those, please take a look at _step_4_.

In our previous exercise we implemented a test to validate a _GET_ action against our controller. We will now implement unit and integration test for our _POST_ action.

The next step is to go ahead and write the unit test for the _POST_ action. This should be done inside our _UserControllerTest_ as well.
The expected behavior should be as follows:
* When given a valid user:
    * The controller should return a `201` status code.
    * The controller should return a response body similar to the user that was passed in, but adding an `id` property.

### Adding Assertions
_UserControllerTest_
```
public class UserControllerTest {
    UserService userService = Mockito.mock(UserService.class);
    final UserController controller = new UserController(userService);
    
    @Test
    public void createUser(){
        final User createRequestUser = new User(null, "test", "test", "t", UserType.PATRON, LocalDate.now());
        final User createdUser = new User("1", "test", "test", "t", UserType.PATRON, LocalDate.now());

        Mockito.when(userService.createUser(Mockito.any())).thenReturn(createdUser);
        final ResponseEntity<User> responseEntity = this.controller.createUser(createRequestUser);

        Assert.assertEquals(201, responseEntity.getStatusCodeValue());
        Assert.assertEquals(createdUser, responseEntity.getBody());
    }
    
}
```

#### Integration Tests

_UserIntegrationTest_
```
public class UserIntegrationTest {
    @LocalServerPort
    private int port;
    
    @Autowired
    private TestRestTemplate restTemplate;
    
    @Test
    public void createUser() throws Exception {
        final UserDetails user = new User(null, "firstName", "lastName", "M", UserType.PATRON, LocalDate.now());
        final ResponseEntity<User> responseEntity = this.restTemplate.postForEntity("http://localhost:" + port + "/user", user, User.class);
    
        Assert.assertEquals(201, responseEntity.getStatusCodeValue());
        Assert.assertNotNull(responseEntity.getBody()); 
    }
}
```

_UserServiceTest_

```
public class UserServiceTest {
    final UserService userService = new UserService();

    @Test
    public void testCreateUser(){
        final UserDetails newUser = new UserDetails("new first", "new last", "M", UserType.PATRON, LocalDate.now());
        final User createdUser = userService.createUser(newUser);
        final Optional<User> retrievedUser = userService.getUserById(createdUser.getId());

        Assert.assertTrue(retrievedUser.isPresent());
        Assert.assertEquals(createdUser, retrievedUser.get());
    }
}
```

## Building and running
First, we have to re-package our application by running `mvn clean verify package` in our home directory (_`user-middle/`_).
At this point, if we go through the logs, we should see something similar to:

_Passing Tests_

![Unit Tests](images/PassingTests.png "Unit Test")
![Integration Tests](images/integration.png "Integration Test")

_Successful Build_

![Successful Build](images/success.png "Successful Build")


To start the application, head to _Terminal_ then run the `java -jar /target/user-middle-md101-end-0.1.0.jar` command.

## Summary
TODO: Summarize POST, request validation, and lead into updating users
On this step, you walked through the process on how to create new users via HTTP POST. You were able to see the flow of the 
HTTP request, implement unit and integration tests, and successfully run our application.

Up to this point we are able to create new users as well as retrieve existing users from our service. In the next step you will
learn how to update existing users.

When you are ready, `git checkout step_6`