

> - `FairLockThread:1` is waiting to acquire the lock
> - `FairLockThread:2` is waiting to acquire the lock
> - `FairLockThread:0` is waiting to acquire the lock
> - **FairLockThread:2** has acquired the lock
> - NoFairLockThread:3 is waiting to acquire the lock
> - `FairLockThread:4` is waiting to acquire the lock
> - NoFairLockThread:4 is waiting to acquire the lock
> - `FairLockThread:3` is waiting to acquire the lock
> - NoFairLockThread:3 has acquired the lock
> - NoFairLockThread:1 is waiting to acquire the lock
> - NoFairLockThread:0 is waiting to acquire the lock
> - NoFairLockThread:2 is waiting to acquire the lock
> - **FairLockThread:0** has acquired the lock
> - NoFairLockThread:3 has release the lock
> - *FairLockThread:2* has release the lock
> - NoFairLockThread:4 has acquired the lock
> - *FairLockThread:0* has release the lock
> - NoFairLockThread:4 has release the lock
> - NoFairLockThread:1 has acquired the lock
> - **FairLockThread:1** has acquired the lock
> - NoFairLockThread:1 has release the lock
> - *FairLockThread:1* has release the lock
> - NoFairLockThread:0 has acquired the lock
> - **FairLockThread:4** has acquired the lock
> - NoFairLockThread:2 has acquired the lock
> - NoFairLockThread:0 has release the lock
> - *FairLockThread:4* has release the lock
> - **FairLockThread:3** has acquired the lock
> - NoFairLockThread:2 has release the lock
> - *FairLockThread:3* has release the lock

> - This above is FairNonFairLockExample once executed result.
> - We found that the request sequence of the FairLockThread thread is 1, 2,0,4, and 3 of thread number, but the acquiring lock sequence of the FairLockThread thread is 2,0,1,4 and 3 of thread number.
> - By the result above we can notice the ReentrantLock(true) is not absolutely a reentrant lock.