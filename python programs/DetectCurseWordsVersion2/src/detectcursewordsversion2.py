import urllib
__author__="noah"
__date__ ="$Jan 3, 2015 5:09:56 PM$"

file = "/Users/noah/Desktop/PracticePrograms/python programs/DetectCurseWordsVersion2/src/movie_quotes.txt" #Path to text file

def read_text():
    quotes = open(file)
    file_contents = quotes.read()
    print(file_contents)
    quotes.close()
    check_profanity(file_contents)
    
def check_profanity(text_to_check):
    connection = urllib.urlopen("http://www.wdyl.com/profanity?q="+text_to_check)
    output = connection.read()
    connection.close()
    if "true" in output:
        print "Profanity Detected"
    elif "false" in output:
        print "No Profanity Detected"
    else:
        print "Could not scan the document"
read_text()
    
