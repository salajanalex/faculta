clear all

close all
figure
hold on
x=linspace(-5,5,11);
n=length(x);
f=[];
fi=0;

for k=1:n

    tk(k) =0.5*(10*cos(((2*k-1)*pi)/(2*n)));
end


for i=1:n
    fi = 1/(1+x(i)^2);
    f=[f, fi];
end

sum=0;
sum2=0;

for i = 1:n
     p=1;
        for j=1:n
            if(i~=j)
             p=conv(p, [1/(tk(i)-tk(j)), -tk(j)/(tk(i)-tk(j))]);
            end
        end
     sum2 = sum2 + p*f(i);
end


for i = 1:n
     p=1;
        for j=1:n
            if(i~=j)
             p=conv(p, [1/(x(i)-x(j)), -x(j)/(x(i)-x(j))]);
            end
        end
     sum = sum + p*f(i);
end

sum
t=[-5:0.01:5];
salut = polyval(sum,t)
ceauo = polyval(sum2,t)
plot(t,salut)
plot(t,ceauo,'green')
ti = 1./(1+t.^2);
plot(t,ti,'red')
