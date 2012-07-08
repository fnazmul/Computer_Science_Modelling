factorial1 = {
input(n);
if (n=1) then 
	result:=n
else
	result:= (n * factorial2((n-1)))
fi;
output(result)
};

factorial2 = {
input(n);
if (n=1) then 
	result:=n
else
	result:= (n * factorial1((n-1)))
fi;
output(result)
};

(n := 7;
x:=factorial1(n))