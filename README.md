# Cloud Balancing

A minimal OptaPlanner project to solve a cloud balancing problem

## Problem description

Suppose your company owns a number of cloud computers and needs to run a number of processes on those computers. Assign each process to a computer.

![cloudBalanceUseCase](https://docs.optaplanner.org/7.45.0.Final/optaplanner-docs/html_single/QuickStart/PlainJava/CloudBalancingTutorial/cloudBalanceUseCase.png)

## Define constraints

The following score constraints are implemented in the [Drools score file](app/src/main/resources/cloudbalancing/cloudBalancingConstraints.drl).

- The CPU power of a computer must be at least the sum of the CPU power required by the processes assigned to that computer
- The RAM memory of a computer must be at least the sum of the RAM memory required by the processes assigned to that computer
- Each computer that has one or more processes assigned, incurs a maintenance cost

## Load the problem

This problem is a form of bin packing. We assign four processes to two computers with two constraints (CPU and RAM) in the [App file](app/src/main/java/cloudbalancing/App.java).

## Solve for a solution

Make sure you have [Gradle](https://gradle.org) on your computer and run:

    $ ./gradlew run
    Solved cloudBalance with 2 computers and 4 processes:

    * Process A -> Computer Y
    * Process B -> Computer X
    * Process C -> Computer X
    * Process D -> Computer Y

    Score: -1hard/-25soft

Increase the time limit in the [solver config file](app/src/main/resources/cloudbalancing/solverConfig.xml) to get a better result.
