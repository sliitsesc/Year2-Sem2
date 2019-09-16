#lab1
#Cannot create variable called 'c'
#'#' for comments
#'ctrl+l' to clear console


#arithmetic operators 

5+3
6-4
10*2
60/5
2**2 #exponentiation
2^2 #exponentiation
10%%4 #modulus
5%/%2 #quotient

#logical operators

5==4
5.66!=5.666
isTRUE(5<6)

#assign values to variable

v=5
v1<-5
v2<<-5 #assign values to variables in a function

#range

x<-1:10

#retrieve values of variables

v
v1
v2
x

#retrieve values according to a condition

x[x<5]
x[x<9|x>5]# '|' OR '&' AND operators
x[x<9&x>5]

#vectors 'c' keyword indexing begins with 1

a<-c(1,2,3,4) #numeric
a
b<-c("Dilshan","Dureksha","Mala") #character
b
d<-c(T,F,T) #logical
d
e<-c(TRUE,TRUE,FALSE) #logical
e
class(d) #check type of vector "class" keyword
v5<-c(1,30,50,45)
v5+2 #add 2 to all the elements of vector
v5[v5>30]
v5[3] #retrieve value in 3rd position
v5[-3] #delete value in 3rd position 
sort(v5) #sort vactor 

#sequnces

seq(5:10) #count no of elements between the range
seq(5,10) #get exact values between the range
seq(1,15,by=2) #get exact values between the range one another

#repetetions

rep(5,2) #first parameter - value , second parameter - no of times
rep(2:4,1:3) #with ranges


#factors

f<-c("m","f","f","m","s")
factor(f) #retrieve categories(levels)

#lists

l<-list(name=("A"),age=21,mark<-c(78,89,68))
l$name #retrieve value from column
l["name"] #retrieve value from column
l[["name"]] #retrieve value from column

#matrix

m<-matrix(1:20,nrow=5,ncol = 4) #column wise
m<-matrix(1:20,nrow=5,ncol = 4,byrow=TRUE) #row wise
m
length(m) #no of elements in a matrix
dim(m) #dimensions of a matrix
m[2,3] #retrieve value of 2nd row 3rd col
m[1,] #retrieve whole row
m[,2] #retrieve whole column

#data frame

df<-data.frame(name=c("A","B","C"),gender=factor(c("M","F","F")),height=c(1.5,1.6,1.8),age=c(21,34,24))
df
df[2] #retreive data
df["age"] #retrieve data
df$age #retreive data