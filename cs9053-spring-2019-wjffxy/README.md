## Homework 2 - Week 2

### Motivation
* Demonstrate your ability to program the procedural aspects of Java by implementing real-world algorithms

### Instructions
* There are three tasks to complete
    - Implement the [Polyline Algorithm](https://developers.google.com/maps/documentation/utilities/polylinealgorithm) within the [PolylineEncoder](src/main/java/edu/nyu/cs9053/homework2/PolylineEncoder.java) class.
    - Implement the annuity methods of [AnnuityCalculator](src/main/java/edu/nyu/cs9053/homework2/AnnuityCalculator.java) class.
    - Implement the command line [Program](src/main/java/edu/nyu/cs9053/homework2/Program.java) class to test your code, see [Program Instructions](#program-instructions)

### Implementation
* Ensure your code is correct by compiling and testing it
* A portion of your grade will be based upon readability and organization of your code.
    - Follow the naming guidelines of lecture
    - Break large functions into multiple functions based on logical organizations


### Program Instructions
* The [Program](src/main/java/edu/nyu/cs9053/homework2/Program.java) should take command line arguments and parse them according to the following rules
    - The first argument should either be `gps` or `annuity`
    - If the first argument is `gps` then the remaining arguments are GPS lat,lng pairs separated by spaces. 
        - Parse these arguments and pass them into your [PolylineEncoder](src/main/java/edu/nyu/cs9053/homework2/PolylineEncoder.java) implementation and print the result
    - If the first argument is `annuity` then the remaining arguments are compound, annuity amount, annual interest rate and years of computing future value separated by spaces.
        - Parse these arguments and pass them into your [AnnuityCalculator](src/main/java/edu/nyu/cs9053/homework2/AnnuityCalculator.java) implementation and print the result
        - If the first argument (after `annuity`) is `compound` use the compounding method as appropriate
        - If the year duration argument is `15` call the appropriate method `computeFutureValueOfAnnuityIn15Years` or `computeMonthlyCompoundedFutureValueOfAnnuityIn15Years`
        - If the year duration argument is `30` call the appropriate method `computeFutureValueOfAnnuityIn30Years` or `computeMonthlyCompoundedFutureValueOfAnnuityIn30Years`
        - Otherwise, call the appropriate method `computeFutureValueOfAnnuity` or `computeMonthlyCompoundedFutureValueOfAnnuity`
* If any of the arguments are invalid then print `Invalid argument` to the command line and quit
    
### Example Runs of Program
    $ java -cp TODO edu.nyu.cs9053.homework2.Program foo
    $ Invalid argument
    $ java -cp TODO edu.nyu.cs9053.homework2.Program gps 38.5,-120.2 40.7,-120.95 43.252,-126.453
    $ _p~iF~ps|U_ulLnnqC_mqNvxq`@
    $ java -cp TODO edu.nyu.cs9053.homework2.Program annuity foo
    $ Invalid argument
    $ java -cp TODO edu.nyu.cs9053.homework2.Program annuity 100000 12
    $ Invalid argument
    $ java -cp TODO edu.nyu.cs9053.homework2.Program annuity 400000 3.5 15
    $ 7718272.3514400000
    $ java -cp TODO edu.nyu.cs9053.homework2.Program annuity 400000 3.5 30
    $ 20649070.9108800000
    $ java -cp TODO edu.nyu.cs9053.homework2.Program annuity 400000 3.5 20
    $ 11311872.7253200000
    $ java -cp TODO edu.nyu.cs9053.homework2.Program annuity compound 400000 3.5 15
    $ 94514413.3829200000
    $ java -cp TODO edu.nyu.cs9053.homework2.Program annuity compound 400000 3.5 30
    $ 254165098.7184400000
    $ java -cp TODO edu.nyu.cs9053.homework2.Program annuity compound 400000 3.5 20
    $ 138747708.2595600000

### Hints
* To construct an object in Java use `new ClassName();` (i.e., to construct a [Gps](src/main/java/edu/nyu/cs9053/homework2/Gps.java) object -> `Gps point = new Gps(40.693368d, -73.9879034d);`).
* If you are implementing the Polyline Algorithm using String you are doing things incorrectly; i.e., bit flipping should be done with primitive types.



    

    