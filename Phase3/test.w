fact = {
input(n); 
(
m:=1; 
while (n>1) 
do 
(m:=(m*n); 
n:= (n-1)) 
od); 
output(m)};

(i:=5;
f:= fact(i))
