#### Thread function introduction:
`start`
- Used to start a new thread and execute the thread's run() method. After start() is called, the thread is added to the thread scheduling queue and waits for the system to schedule its execution.
- After calling start(), you should not call run() again, because calling run() directly does not create a new thread, but executes run() in the current thread.
- A thread can only be started once, if you try to call start() multiple times, an IllegalThreadStateException will be thrown.

`join`
- The join() method is a method used to wait for a thread to finish executing. When the join() method of another thread is called from within a thread, the current thread blocks until the called thread completes execution.
- If the thread throws an exception during execution, the join() method catches it and passes it to the calling thread.
- join() also has an overloaded method that allows you to set a maximum amount of time to wait, after which execution of the calling thread will continue even if the called thread has not completed execution.