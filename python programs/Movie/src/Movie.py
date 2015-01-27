
__author__="Noah Abdelguerfi"
__date__ ="$Jan 14, 2015 11:23:27 PM$"
#!/usr/bin/python

class Movie:
   'Common base class for all employees'
   movieCount = 0

   def __init__(self, title, storyline, poster_image, youtube_trailer):
      self.title = title
      self.storyline = storyline
      self.poster_image = poster_image
      self.youtube_trailer = youtube_trailer
      Movie.movieCount += 1
   
   def displayCount(self):
     print "Total Employee %d" % Employee.empCount

   def displayMovie(self):
      print "Title : ", self.title,  ", Storyline: ", self.storyline, "Poster_Image", self.poster_image, "Youtube_Trailer", self.youtube_trailer


movie1 = Movie("Avator", "Blue People running around", "Green Human", " trailer url")

#emp2 = Employee("Manni", 5000)
movie1.displayMovie()

toy_story = Movie("Toy Story", "Toy Story is about the 'secret life of toys' when people are not around. When Buzz Lightyear, a space-ranger, takes Woody's place as Andy's favorite toy, Woody doesn't like the situation and gets into a fight with Buzz.")
school_of_rock
ratouille



#emp2.displayEmployee()
print "Total Movie Count: %d" % Movie.movieCount