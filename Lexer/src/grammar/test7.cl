(*Takes in two numbers and prints out sum, difference, product and quotient of the numbers in respective order*)

class Mynum
{
	a : Int;
	b : Int;
	mySum () : Int {{a+b;}};
	myDiff() : Int {{a-b;}};
	myPro() : Int {{a*b;}};
	myDiv() : Int {{a/b;}};
	init(x : Int, y : Int) : Mynum{
		{
			a <- x;
			b <- y;
			self;
		}
	};
};

class Main inherits IO
{
	a : Int <- in_int();
	b : Int <- in_int();
	x : Mynum <- (new Mynum).init(a,b);
	sum : Int <- x.mySum();
	diff : Int <- x.myDiff();
	pro : Int <- x.myPro();
	div : Int;
	main() : Object
	{
		{
			out_string("Sum is : ");
			out_int(sum);
			out_string("\n");
			out_string("Diffrence is : ");
			out_int(diff);
			out_string("\n");
			out_string("Product is : ");
			out_int(pro);
			out_string("\n");
			if(b=0)
			then{out_string("Division by zero is not possible\n");}
			else
			{
				div <- x.myDiv();
				out_string("Quotient is : ");
				out_int(div);
				out_string("\n");
			}
			fi;
	 }
 };
};
