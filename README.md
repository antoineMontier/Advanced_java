# tabPolynom

## Threads methods
- `getState()` returns `RUNNABLE`, `BLOCKED`, `NEW` or `TERMINATED`
- `getPriority()` returns the priority of the thread. Priority is an integer between 1 and 10. The higher the priority the more efficient the execution is
- `setPriority()` sets the priority of the thread
- `start()` starts the thread, calls the `run()` method in the thread class
- `join()` ou `join(ms)` waits for the thread to end. If a ms delay is specified, the main thread will force finish the other thread after waiting for the delay even if other thread is not finished.