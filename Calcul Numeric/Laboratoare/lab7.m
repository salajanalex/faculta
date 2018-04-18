xi= [3,4,5];
f = [1,2,4];
x= min(xi):0.01:max(xi);
a=Lab5ex1a(xi,f);
m=2;
figure
hold on

for j=1:length(x)
    sum(j) = a(1,2);
    
 for k=1:m
    prod=1;
    for i=1:k
    prod = prod * (x(j)-xi(i));
    
    end
sum(j) = sum(j) + prod*a(1,(k+2));
 end


plot(x(j),sum(j),'r.');
end