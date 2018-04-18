x=[3 4 5];
f=[1 2 4];
sum=0;
n = 3;
for i = 1:n
    p=1;
    for j=1:n
        if(i~=j)
            p=conv(p, [1/(x(i)-x(j)), -x(j)/(x(i)-x(j))]);
        end
    end
   sum = sum + p*f(i)
  
end
 sum
    