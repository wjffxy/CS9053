## Homework 4 - Week 4

### Motivation
* Demonstrate your ability to program using inheritance in the Java programming language.
* Demonstrate your knowledge of proper `equals` and `hashCode` implementations in the Java programming language.
* Demonstrate your knowledge of variable arguments and enum types in the Java programming language.

### Instructions
* There are four tasks to complete
    - Create an object hierarchy which mimics the classification of a [tree](https://en.wikipedia.org/wiki/Tree).
        - The hierarchy should be contained within package [edu.nyu.cs9053.homework4.hierarchy](src/main/java/edu/nyu/cs9053/homework4/hierarchy)
        - There should be a base class called [Tree](src/main/java/edu/nyu/cs9053/homework4/hierarchy/Tree.java)
        - There should be the following subtypes:
            - [Conifer](src/main/java/edu/nyu/cs9053/homework4/hierarchy/Conifer.java)
            - [Magnolia](src/main/java/edu/nyu/cs9053/homework4/hierarchy/Magnolia.java)
            - [Palm](src/main/java/edu/nyu/cs9053/homework4/hierarchy/Palm.java)
            - [Larch](src/main/java/edu/nyu/cs9053/homework4/hierarchy/Larch.java)
            - [Cycad](src/main/java/edu/nyu/cs9053/homework4/hierarchy/Cycad.java)
            - [Redwood](src/main/java/edu/nyu/cs9053/homework4/hierarchy/Redwood.java)
            - [Nutmeg](src/main/java/edu/nyu/cs9053/homework4/hierarchy/Nutmeg.java)
            - [Avocado](src/main/java/edu/nyu/cs9053/homework4/hierarchy/Avocado.java)
            - [Birch](src/main/java/edu/nyu/cs9053/homework4/hierarchy/Birch.java)
            - [Camphor](src/main/java/edu/nyu/cs9053/homework4/hierarchy/Camphor.java)
        - Create an enum named [Type](src/main/java/edu/nyu/cs9053/homework4/hierarchy/Type.java) which is either
            - Evergreen
            - Deciduous
        - Each of the subtypes should have the following methods:
            - `isSeedEnclosed` which returns a boolean indicating whether the tree produces seeds which are fully enclosed in a container (i.e., a fruit).
            - `getType` which returns a [Type](src/main/java/edu/nyu/cs9053/homework4/hierarchy/Type.java)
            - `getName` returns a name for the tree. This value is per object and not defined by the class
            - `getAge` returns the age of the tree as an `int`. This value is per object and not defined by the class
        - Certain trees are further classified as [eudicot](https://en.wikipedia.org/wiki/Eudicots) or [monocot](https://en.wikipedia.org/wiki/Monocotyledon).
            - create a method on these trees called `isEudicot` which returns a boolean indicating if the tree is an [eudicot](https://en.wikipedia.org/wiki/Eudicots)
        - For each class which has no sub-types itself, add a property to the class particular to the type which is also used in the `equals` and `hashCode` methods.
        - Try to limit code by sharing across classes. This can include composition where you create another object hierarchy which your [Tree](src/main/java/edu/nyu/cs9053/homework4/hierarchy/Tree.java) implementations leverage.
    - Provide implementations of the `equals` and `hashCode` methods for each class within package [edu.nyu.cs9053.homework4.hierarchy](src/main/java/edu/nyu/cs9053/homework4/hierarchy)
        - Note, these methods are testing equality and returning hashes for the objects and so should only include checks on type information and object specific values.
        - Note, do not use Objects helper class, write your own implementations.
    - Create an enum type representing the 9 biomes in the [Walter system](https://en.wikipedia.org/wiki/Biome#Walter_system) of biome classification;
        - Each biome must also have a method returning a description of the biome, name it `getDescription`.
        - The enum should be called [Biome](src/main/java/edu/nyu/cs9053/homework4/Biome.java) with package `edu.nyu.cs9053.homework4`
    - Create a static varargs method within [Biome](src/main/java/edu/nyu/cs9053/homework4/Biome.java) which takes a variable number of Biome objects and prints each object's description.

### Implementation
* Ensure your code is correct by compiling and testing it
* A portion of your grade will be based upon readability and organization of your code.
    - Follow the naming guidelines of lecture
    - Break large functions into multiple functions based on logical organizations
    

    