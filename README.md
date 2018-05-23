# MD101 - Step 5: Creating new users

TODO: This will walk you through RESTful creation via POST

## Introducing HTTP POST for creation
TODO: Explain POST and how it pertains to RESTful HTTP. Explain how we will be creating users with it. Specify how our ID is not determined by the caller, but by the server (random uuid)

## Updating the controller and the service to handle creating users
TODO: Explain what code changes to make to allow creation of users from the REST and service layers

## Handling the ID field
TODO: We want to generate a random uuid for our user id, introduce setter for id, and how users shouldnt need to pass this field

## Validating our request
TODO: How do we know our data is good? Introduce @NotNull annotations into our User pojo, and @Valid for our request body

## Updating our tests
TODO: Implement additional unit/integration tests

## Building and running
TODO: Build a re-run project, test creation, followed by a get to verify the resource was made

## Summary
TODO: Summarize POST, request validation, and lead into updating users

When you are ready, `git checkout step_6`