# Excel reading lib import
library(readxl) 

# Q1 - Data set import
data3 <- read_excel("DATA 3.xlsx")
names(data3) <- c("Age", "Gender", "Accommodation")

# Data set viewing
# View(data3)

# Q2 - univariate analysis