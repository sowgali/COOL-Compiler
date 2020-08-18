
(*Takes in a positive integer and computes its factorial*)
(*After 16 factorial crosses integer limit of COOL      *)
class Main
{
  io : IO <- new IO;
  n : Int <- io.in_int();
  main() : Object
  {
    if n < 0 then
      io.out_string("Invalid\n")
    else
    {
      io.out_string("factorial is : ");
      io.out_int(fact(n));
      io.out_string("\n");
    }
    fi
  };
  fact(n : Int) : Int
  {
    if n = 0 then 1
    else
      n * fact(n-1)
    fi
  };
};
