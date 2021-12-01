# Advent of Code 2016

Contains my personal solutions to Advent of code problems.

Advent of code is hosted on http://adventofcode.com

## Usage

This projects assumes having inputs named ```input/dayXY``` at the root, where ```X``` is the number of the day and ```Y``` is the letter of the problem for the day.
Example : ```input/day03b```

To run the app, you need to have a Clojure REPL ready.
If you are using Leiningen, simply run ```lein run```, then input the desired problem number when asked

Example :
```
10:47 - grasseh:~/projects/cloj/adventofcode-2021 (master) - lein run
Select a level
>03b
You select problem #03b.
Your solution is 1234567
```

## Units tests

Unit tests are set up using the default leiningen application framework. Simply run

```
10:47 - grasseh:~/projects/cloj/adventofcode-2021 (master) - lein test
```

Inputs for the tests are in ```test/input```. They are based on the examples provided in the official exemples.
