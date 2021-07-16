getwd()
#this is my first comment
setwd("F:\\1YS1_SE_Curtin\\Y2 S2 Curtin\\Notes & Works\\PS\\Lab Sheet")
getwd()

#operators
#Scalar Operators 
5+2
5*9
9/3
9%%4
9%/%4
2**3
2^3

#Logical Operators 
x=5
y=-3
isTRUE(x==y)
isTRUE(x>y)
isTRUE(x<y)
isTRUE(x!=y)
#AND Operator
isTRUE(x<6 & y>0)
isTRUE(x<6 & y<0)

#OR Operator
isTRUE(x<6 | y>0)
isTRUE(x>6 | y>0)

#Assignment Operator 
a=5
a<-5
a<--5

#Data Object 
#Vector
a<-c(1,2,3,4,5)
a
class(a)
b<-c("A","B","C","D")
b
class(b)

#Factor 
Gender=c(0,1,0,1,1,1)
Gender
Gender<-factor(Gender,c(0,1),c("Male","Female"))
Gender

#List 
a<-c(1,2,3)
b<-"Blue"
C<-21
Data<-list(a,b,C)
Data
class(Data)

#See what are the objects in all session
objects()

#Matrix
matrix_1<-matrix(c(1,2,3,4),nrow = 2,ncol = 2,byrow =FALSE)
matrix_1

#Data Frame
Height<-c(12,23,56,49)
Weight<-c(45,56,82,87)
data_set<-data.frame(Height,Weight)
data_set
class(data_set)

#Install new package
install.packages("gglot2")






