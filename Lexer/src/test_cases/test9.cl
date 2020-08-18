
(* Takes in a positive integer and prints out a lower triangular pattern and an*
 * upper triangular pattern.                                                   *
 * Eg:                                                                         *
 *  In : 3                                                                     *
 *  Out :                                                                      *
 *       Upper Triangle pattern :                                              *
 *       1 2 3                                                                 *
 *       1 2                                                                   *
 *       1                                                                     *
 *       Lower Triangle pattern :                                              *
 *           3                                                                 *
 *         2 3                                                                 *
 *       1 2 3                                                                 *)

class Pattern
{
  size : Int;
  io : IO <- new IO;
  n : Int;
  i : Int;
  temp : Int;
  init(m : Int) : Pattern
  {
    {
      size <- m;
      self;
    }
  };

  upperT () : Object
  {
    {
      n <- size;
      while 0 < n
      loop
      {
        temp <- n;
        while 0 < temp
        loop
        {
          io.out_int(n-temp+1);
          io.out_string(" ");
          temp <-temp - 1;
        }
        pool;
        io.out_string("\n");
        n <- n - 1;
      }
      pool;
    }
  };

  lowerT () : Object
  {
    {
      n <- size;
      while 0 < n
      loop
      {
        temp <- n;
        while 1 < temp
        loop
        {
          io.out_string("  ");
          temp <-temp - 1;
        }
        pool;
        i <- 1;
        while i <= (size-n+1)
        loop
        {
          io.out_int(i);
          io.out_string(" ");
          i <- i + 1;
        }
        pool;
        io.out_string("\n");
        n <- n - 1;
      }
      pool;
    }
  };
};

class Main
{
  io : IO <- new IO;
  n : Int <- io.in_int();
  p : Pattern <- (new Pattern).init(n);
  main() : Object
  {
    {
      io.out_string("Upper Triangle pattern : \n");
      p.upperT();
      io.out_string("Lower Triangle pattern : \n");
      p.lowerT();
    }
  };
};
