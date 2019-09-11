# Constructing Quadratic Formula
result <- function(a, b, c) {
    if (delta(a,b,c) > 0) { # first case D > 0
       x1 = (-b + sqrt(delta(a, b, c))) / (2 * a)
       x2 = (-b - sqrt(delta(a, b, c))) / (2 * a)
       result = c(x1, x2)
    } else if (delta(a, b, c) == 0) { # Second case D = 0
       x = -b / (2 * a)
    } else {
       "There are no real roots"
    }
}

delta <- function(a , b, c){
    b^2 - (4 * a * c)
}