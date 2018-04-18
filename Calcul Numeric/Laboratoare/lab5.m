x=[0 1 3 4];
f=[2 1 2 4];
a(:,1)=x
a(:,2)=f
d=[];
b=[diff(f)]
c=[diff(x)]
d=[];
for i=1:length(b)
    d(i)=b(i)/c(i);
end  
d(4)=NaN
a(:,3)=d
k=[];
l=[diff(d)]

for i=1:length(l)-1
    k(i)=l(i)/(x(i+2)-x(i))
end 
k(3)=NaN;
k(4)=NaN;
a(:,4)=k

t=[];
m=[diff(k)];
for i=1:length(m)-2
    t(i)=m(i)/(x(i+3)-x(i))
end 
t(2)=NaN
t(3)=NaN
t(4)=NaN
a(:,5)=t





    