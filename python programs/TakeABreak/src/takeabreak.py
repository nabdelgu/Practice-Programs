import webbrowser
import time

__author__="Noah Abdelguerfi"
__date__ ="$Dec 25, 2014 1:17:49 PM$"

#launches your favorite music video every 2 hours
#performs action 3 times

loops = 0
while loops != 3:
    time.sleep(7200)
    print "Break Time"
    webbrowser.open('http://youtu.be/nSKUXqJ5l1k')
    loops += 1
