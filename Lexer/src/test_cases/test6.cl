
(* This problem breaks rules from section 10.1                        *
 * '$' should not be used for identifiers -> only letters,numbers,'_' *
 * Type identifiers begin with capital letter, int -> Int             *
 * Object identifiers should begin with small letters : Fg -> fg      *)

class Main
{
  main() : Object
  {
    {Fg$2 : int;}
  };
};
