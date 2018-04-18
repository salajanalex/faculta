function y = Lab5ex1a(x,fx)

rez = [x;fx];
k=1;
y = zeros(length(x), length(x)+1)*NaN;

rez=[rez'];
y(:,1)=rez(:,1);
y(:,2)=rez(:,2);
l=length(x);

for j = 3:l+1
    for i = 1:(l-k)
        y(i,j) = (y(i+1,j-1)-y(i,j-1))/(x(i+(k+1)-1)-x(i));
    end
    k=k+1
end
y
end
