#Lab2

#Keyboard Inputs

my.name<-readline(prompt = "Enter Name :")#input is saved as character
my.age<-readline(prompt = "Enter Age :")#input is a character

my.age <- as.integer(my.age)#convert character to integer

#convert and assign
#my.age <- as.integer(readline(prompt = "Enter Age :"))

print(paste("Hi, ",my.name,"Next Year You Will Be ",my.age+1," Years Old."))


if(my.age<18){
  print("You cannot work")
}else if(my.age>=18&my.age<60){
  print("You can work")
}else{
  print("You are too old to work")
}

#for loop
for(i in 1:10){
  print(i)
  
}

#while loop
i=0
while(i<10){
  print(i)
  i=i+1
}

#charater vector
student<-c("Dureksha","Sura","Dilshan")

#print vector elements
for(i in 1:3){
  print(student[i])
}


x<-2.987
while(x<=4.987){
  x=x+0.987
  print(c(x,x-2,x-1))
}


#functions

w<-2

#create function
m<-function()
{
  w<<-20 #have to use third option of assignment
}

#call a function
m()
w

#print working directory
getwd()

#change directory
setwd("C:\\Users\\it18113228\\Desktop\\Lab2")

#Import CSV file
#header = true import table headers
data<-read.csv("Lab2.csv",header = TRUE)

#display values
fix(data)

