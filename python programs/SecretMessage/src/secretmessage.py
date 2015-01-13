import os 
import re
from string import digits

__author__="Noah Abdelguerfi" 
__date__ ="$Dec 26, 2014 12:38:04 AM$" 

#iterates throught files in a directory
#remove numbers from file names

rootDir = "/Users/noah/Desktop/PracticePrograms/python programs/SecretMessage/src/Pictures.bak" #root directory path 

for dirName, subdirList, fileList in os.walk(rootDir): 
    for fname in fileList:                  
        
        newName = fname.translate(None, digits) #remove numbers
        old_string = rootDir + '/' + fname
        new_string = rootDir + '/' + newName
        
        os.rename(old_string, new_string) #reanmes file  
        print fname + ' renamed to: ' + newName


