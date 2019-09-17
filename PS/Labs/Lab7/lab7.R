# Data import
Forest<-read.delim("Forest.txt",sep=",")

# Variables
names(Forest)

# Summery
summary(Forest)

#No of observations
nrow(Forest)

# Max = 100 , min = 15, wind
max(Forest$wind)
min(Forest$wind)

# 5 number summery of temp 0.0  6.5  8.4 10.8 56.1
fivenum(Forest$temp)

# Funtion for outliers
outval<-boxplot(Forest$wind)$out

# Boxplot
boxplot(Forest$wind)

# median temp = 8.4
median(Forest$temp)

# mean = 9.021663 and sd = 4.559477
mean(Forest$temp)
sd(Forest$temp)

# IQR = 20
IQR(Forest$wind)

# How many observations have measured during Friday in August
my.data<-subset(Forest,(Forest$day=="Friday")&(Forest$month=="August"))
nrow(my.data)

