`ThreadPoolExecutor contains five states such as RUNNING,SHUTDOWN,STOP,TIDYING and TERMINATED.`

> RUNNING: The initial or active state of the thread pool. In this state, the pool can accept new tasks and process submitted tasks.

>SHUTDOWN: No longer accepting new tasks, but will continue to process submitted tasks, including those in the wait queue. Calling the shutdown() method switches the thread pool to this state.

>STOP: No longer accepting new tasks, submitted tasks are not processed, and the executing task is interrupted. Calling the shutdownNow() method switches the thread pool to this state.

>TIDYING: All tasks have been terminated and the thread pool will enter this state for resource cleanup. The thread pool will switch to this state when all tasks are completed, including those in the wait queue.

>TERMINATED: The state in which the thread pool is completely terminated. The thread pool will enter the TERMINATED state after the TIDYING state is completed.

The following is the state switching relationship of the ThreadPoolExecutor
```markdown
[RUNNING] --shutdown()----> [SHUTDOWN]
          --shutdownNow()-> [STOP]
                                |
                                |
                                v
                         (all tasks completed)
                                |
                                |
                                v
                           [TIDYING] --(cleanup)--> [TERMINATED]
```

