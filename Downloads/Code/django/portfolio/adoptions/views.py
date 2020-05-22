from django.shortcuts import render
from django.http import HttpResponse
from django.http import Http404

from .models import Pet

def home(request):
	pets = Pet.objects.all()
	return render(request, 'home.html', {'pets': pets})
	# pass view's data to template -> {} = dictionary

	#return HttpResponse('<p>home view</p>')

def pet_detail(request, id):
	try:
		pet = Pet.objects.get(id=id)
	except Pet.DoesNotExist:
		raise Http404('Pet not found')
	return render(request, 'pet_detail.html', {'pet': pet})


	#return HttpResponse('<p>pet_detail view with id {}</p>'.format(id))
