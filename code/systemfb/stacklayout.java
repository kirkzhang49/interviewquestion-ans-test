THE PROCESSOR S STACK FRAME LAYOUT
 
Stack frame constructed during the function call for memory allocation implicitly.  
Explicitly, memory allocation can be requested from and released to heap area using malloc(), calloc(), 
realloc(), new, free() and delete respectively.  A typical layout of a stack frame is shown below although 
it may be organized differently in different operating systems:
Function parameters.
Function’s return address.
Frame pointer.
Exception Handler frame.
Locally declared variables.
Buffer.
Callee save registers.
And the arrangement in the stack can be illustrated as shown below.
 