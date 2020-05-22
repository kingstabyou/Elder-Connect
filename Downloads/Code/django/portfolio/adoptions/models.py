from django.db import models

class Pet(models.Model): # inherits from Model
	SEX_CHOICES = [('M','Male'),('F','Female')] # is a tuple, 1st val = stored in database, 2nd val = for display in forms

	name = models.CharField(max_length=100)
	submitter = models.CharField(max_length=100)
	species = models.CharField(max_length=30)
	breed = models.CharField(max_length=30, blank=True)
	description = models.TextField()
	sex = models.CharField(choices=SEX_CHOICES, max_length=1, blank=True)
	submission_date = models.DateTimeField()
	age = models.IntegerField(null=True) # can be null if age unknown
	vaccinations = models.ManyToManyField('Vaccine',blank=True) # arg1 = name of model related to, blank: may not be vaccinated

class Vaccine(models.Model):
	name = models.CharField(max_length=50)

	def __str__(self): # string representation of this model
		return self.name
