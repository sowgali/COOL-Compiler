
(*Takes in a positive integer 'n' and prints out nth Fibonacci number (1,1,2,...)*)

class Main
{
  io : IO <- new IO;
  n : Int <- io.in_int();
  f1 : Int;
  f2 : Int;
  fib(m : Int) : Object
  {
    {
      f1 <- 1;
      f2 <- 1;
      if (m < 3)
      then {io.out_int(1);io.out_string("\n");}
      else
      {
        m <- (m - 2);
        while (0 < m)
        loop
        {
          f2 <- (f1+f2);
          f1 <- (f2-f1);
          m  <- m-1;
        }
        pool;
        io.out_int(f2);
        io.out_string("\n");
      }
      fi;
    }
  };
  main() : Object
  {
    {
      if (n <= 0)
      then {io.out_string("Invalid\n");}
      else{fib(n);}
      fi;
    }
  };
};
