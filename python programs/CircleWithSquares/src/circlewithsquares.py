import turtle
__author__="Noah Abdelguerfi"
__date__ ="$Dec 28, 2014 8:49:59 PM$"

def draw_square(size, color):
    number = 0
   
    drawSquare = turtle.Turtle()
    drawSquare.shape("turtle")
    drawSquare.color(color)
    drawSquare.speed(1)

    while(number != 4):
    
        drawSquare.forward(size)
        drawSquare.right(90)
        number += 1

"""
#_param_  = radius
#_param_ = color
# method draws a circle
"""
def draw_circle(radius, color):
    drawCircle = turtle.Turtle()
    drawCircle.speed(1)
    drawCircle.shape("arrow")
    drawCircle.color(color)
    drawCircle.circle(radius)
    
"""
# method draws a equalateral triangle
"""    
def draw_triangle():
    drawTriangle = turtle.Turtle()
    drawTriangle.speed(1)
    drawTriangle.shape("circle")
    
    drawTriangle.setheading(60)
    drawTriangle.forward(100)
    drawTriangle.setheading(-60)
    drawTriangle.forward(100)
    drawTriangle.right(120)
    drawTriangle.forward(100)

"""
#Creates a window to draw in 
#Sets backround color to red
#Calls methods draw_square, draw_circle, and draw_triangle
"""      
def main():   
    window = turtle.Screen()
    window.bgcolor("red")
    draw_square(100, "green")
    draw_circle(90, "blue")
    draw_triangle()
    
main()
