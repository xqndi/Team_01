package at.tu.graz.coffee.ui.home

import androidx.lifecycle.*
import at.tu.graz.coffee.controller.CoffeeRepository
import at.tu.graz.coffee.model.Coffee
import at.tu.graz.coffee.model.CoffeeWithReviews
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: CoffeeRepository) : ViewModel() {

    val allCoffees: LiveData<List<CoffeeWithReviews>> = repository.allCoffees.asLiveData()

    /*fun addCoffee(coffee: Coffee) = viewModelScope.launch {
        repository.insert(coffee)
    }*/
}

class HomeViewModelFactory(private val repository: CoffeeRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HomeViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}