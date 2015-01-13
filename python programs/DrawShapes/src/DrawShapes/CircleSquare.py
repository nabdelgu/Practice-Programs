import turtle

__author__="Noah Abdelguerfi"
__date__ ="$Dec 27, 2014 10:57:10 PM$"

"""
# method draws a square incriments heading
# continues until it reaches 360 degrees
"""

def draw_circle_with_squares():
    degrees = 0
    
    squareCircle = turtle.Turtle()
    squareCircle.shape("turtle")
    squareCircle.color("green")
    squareCircle.speed(100)
    
    while degrees != 360:

        for i in range(0,4): 
            squareCircle.forward(100)
            squareCircle.right(90)
                       
        degrees += 1
        squareCircle.setheading(degrees)

"""
#create a screen 
#set backround color to red
#call methods: draw_circle_with_squares
"""  
def main():
    
    window = turtle.Screen()
    window.bgcolor("red")
    draw_circle_with_squares()

main()

    
    
