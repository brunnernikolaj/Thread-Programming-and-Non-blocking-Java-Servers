# Thread-Programming-and-Non-blocking-Java-Servers
___
#####When and why we will use Threads in our programs?
  One usecase is when you have a long running operation and you still wanna keep the main thread free for UI/input.
  
  Another usecase is when you wanna take advantages of modern CPU's, which have multiple cores. Without using threads its only    possible to use one core  
  
___
#####Explain about the Race Condition Problem and ways to solve it in Java
  A Race Condition Problem is when two or more threads access a varible almost simultaneously, resulting in unexpected behavior   such as a varible being incremented by 1 instead of 2
  
  To solve these kind of problems Java has build in syncronization features. These features work by for example, only allowing one thread inside a method at a time.    

___
#####Explain how we can write reusable non-blocking Java Controls using Threads
  By implementing Runnable/Callable on a class, its possible to start a new Thread like so
  
```Java
    new Thread(new (class implements Runnable/Callable)).start()
```
___
#####Explain about deadlocks, how to detect them and ways to solve the Deadlock Problem
  A deadlock is when 2 threads are trying to aquire 2 or more locks.
  For example if thread 1 aquires lock 1 and thread 2 aquires lock 2, then both will try and aquire the other's lock. This will   result in a deadlock and the threads will halt. 
  
  To detect a deadlock one can use the class `ThreadMXBean` and then watch for `findDeadlockedThreads();`
  
```Java
    ThreadMXBean tmxb = ManagementFactory.getThreadMXBean();
    long[] threadIds = tmxb.findDeadlockedThreads();
    if (threadIds.length > 0)
      //Do something
```

 One way to solve the deadlock problem is by using `lock.tryLock` which will make one thread free its lock if it can't aquire both locks
