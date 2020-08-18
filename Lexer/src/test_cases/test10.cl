
(*Takes in a positive integer and prints out its factors*)

class Main
{
  io : IO <- new IO;
  n : Int <- io.in_int();
  temp : Int;
  modulus(a : Int, b : Int) : Bool
  {
    {(a-((a/b)*b)) = 0;}
  };
  get_factors(m : Int) : Object
  {
    {
      temp <- 2;
      io.out_int(1);
      io.out_string(" ");
      while (temp < m)
      loop
      {
        if (modulus(m,temp))
        then {io.out_int(temp);io.out_string(" ");temp <- temp+1;}
        else {temp <- temp+1;}
        fi;
      }
      pool;
      io.out_int(m);
      io.out_string("\n");
    }
  };
  main() : Object
  {
    {
      if (n<=0)
      then {io.out_string("Invalid\n");}
      else
      {
        if (n = 1)
        then {io.out_int(1); io.out_string("\n");}
        else {get_factors(n);}
        fi;
      }
      fi;
    }
  };
};
