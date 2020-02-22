## Homework 7 - Week 7

### Motivation
* Demonstrate your ability to program using generics in the Java programming language.

### Instructions
* There are five tasks to complete.
    - Create a [Vault](src/main/java/edu/nyu/cs9053/homework7/Vault.java) which uses Java generics.  The `Vault` should be able to store an array (Java array) of the generic type.  There should be an `add` method (returning a `boolean` type indicating if the value was added, it should only be added if it doesn't already exist), a `contains` method (returning a `boolean` type), a `remove` method (returning a `boolean` if the value was found and removed from the array), a `get` method which takes an `int` index into the array (returning the generic type which is the value at the index, if the index does not exist an exception or null can be returned) and a `size` which returns the current amount of items inside the underlying array (returning an `int`).
    - Create a subclass of [Vault](src/main/java/edu/nyu/cs9053/homework7/Vault.java) which uses generics but only if the generic type extends from [Money](src/main/java/edu/nyu/cs9053/homework7/Money.java).  Create this `Money` class which has an instance field `amount` of type `BigDecimal`.  It should be named [BankVault](src/main/java/edu/nyu/cs9053/homework7/BankVault.java).
    - Create a [VaultTransfer](src/main/java/edu/nyu/cs9053/homework7/VaultTransfer.java) which has one method (an instance method) which can transfer any similar `Vault` values between each other.  For this to be correct any generic type which can be polymorphically assigned should be able to be exchanged.
    - Create a subclass of `Money` which is a particular type of `Money`.
    - For every type used by the `Vault` or its subclasses, create an implementation of the [ArrayCreator](src/main/java/edu/nyu/cs9053/homework7/ArrayCreator.java).  The `ArrayCreator` is an interface with a generic parameter.  It has one method `create` which takes in a `int` which is the size of the array to create for the parameter and it returns an array of that parameter type.

### Implementation
* Ensure your code is correct by compiling and testing it.
* Use immutable data.
* Ensure proper style.
* Ensure your `Money` and its subclass have proper getter methods and `equals` and `hashCode` implementations.
* Do not repeat past mistakes.
* A portion of your grade will be based upon readability and organization of your code.
    - Follow the naming guidelines of lecture
    - Break large functions into multiple functions based on logical organizations
    

    