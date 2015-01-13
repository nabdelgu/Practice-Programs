import sys
__author__="Noah Abdelguerfi"
__date__ ="$Jan 3, 2015 3:33:34 PM$"

"""
Program iterates through a file and determines if there are curse words
"""

file = "/Users/noah/Desktop/PracticePrograms/python programs/DetectCurseWords/src/movie_quotes.txt" #Path to text file
swearWords = ("fuck" , "Fuck", "Shit", "shit", "Bitch", "bitch") #List of curse words

def detect_profanity():
    with open(file) as fq:
        for word in fq: #iterated through file sperating each word
            print word
            for i in swearWords: #iterate through list of curse words
                if i in word: #determine if the word is a curse word
                    print "Profanity Detechted"
                    sys.exit(0)


    print "No Profanity Detechted"    
detect_profanity()