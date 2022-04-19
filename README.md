# JBench Overview
Is a GUI benchmarking tool to visually compare performance of functions. The functions are passed into this utility and the runtime results are presented through a graph. 
<br><br>
![Screenshots](/screenshots/averaged.PNG)
![Screenshots](/screenshots/non-averaged.PNG)
## Tutorial
1. Instantiated PView class with the number of trials to be run for each function and whehter to average the times. Additionally, include timescale.The available time scales are nano, milli, sec, and minutes

```
// PView (trialNum, average, timescale framesizeX, framesizeY) (Last two optional)

PView measure = new PView(10, false, PView.Time.SECONDS)

Pview measure = new PView(10, true, PView.Time.MINUTES, 600, 300) 

```


2. A List containing the lambda expressions is created and then passed to the PView.benchmark method.

```
LinkedList<PView.Compare> functions = new LinkedList<>();

functions.add(Test::function1);

// or the latter option works as well

functions.add(()->Test.function2);

measure.benchmark(functions);
```

## Dependencies
[JFreeCharts](https://github.com/jfree/jfreechart)
