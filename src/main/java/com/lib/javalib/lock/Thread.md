#### Thread function introduction:
`start`
- Used to start a new thread and execute the thread's run() method. After start() is called, the thread is added to the thread scheduling queue and waits for the system to schedule its execution.
- After calling start(), you should not call run() again, because calling run() directly does not create a new thread, but executes run() in the current thread.
- A thread can only be started once, if you try to call start() multiple times, an IllegalThreadStateException will be thrown.

`join`
- The join() method is a method used to wait for a thread to finish executing. When the join() method of another thread is called from within a thread, the current thread blocks until the called thread completes execution.
- If the thread throws an exception during execution, the join() method catches it and passes it to the calling thread.
- join() also has an overloaded method that allows you to set a maximum amount of time to wait, after which execution of the calling thread will continue even if the called thread has not completed execution.

`Thread containers six states such as New, Runnable, Running, Blocked, Waiting AND Terminated`

> New: The state of a thread object when it has been created but not yet started. After a thread object is created with new Thread(), the thread is in the New state.

> Runnable: After the thread object is created, the start() method is called and the thread enters the ready state. A thread in the ready state waits for a CPU time slice, and once the time slice is acquired, it can be switched to the running state.

>Running: A thread in the ready state enters the running state after getting a CPU time slice to perform a specific task.

>Blocked: A thread may enter a blocked state while waiting for a condition to be met. For example, a thread is trying to acquire a lock held by another thread, or a thread calls the sleep() method.

>Waiting: A thread is waiting for some reason, either to be notified by another thread or for a certain period of time. A thread can be put into a waiting state by methods such as Object.wait(), Thread.join(), LockSupport.park(), and so on.

>Terminated: A thread enters a dead state after it finishes executing a task, or throws an uncaught exception, or calls the stop() method.

`The following is the state switching relationship of Java thread`
```markdown
New -> (start()) Runnable -> (acquires lock) Blocked -> (unlocks) Runnable
             |
             v
          Running
             |
        (wait()/sleep()) -> Waiting -> (receives notification) Runnable
             |
        (join()) -> Timed Waiting -> (time elapses/thread completes) Runnable
             |
             v
Terminated <--
```