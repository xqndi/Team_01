package at.tu.graz.coffee.ui.filter

import androidx.lifecycle.*
import at.tu.graz.coffee.controller.CoffeeRepository
import at.tu.graz.coffee.model.CoffeeWithReviews
import at.tu.graz.coffee.ui.filter_result.FilterResultViewModel

class FilterViewModel(private val repository: CoffeeRepository) : ViewModel() {
    val allCoffees: LiveData<List<CoffeeWithReviews>> = repository.allCoffees.asLiveData()

    fun getStoresOfAllCoffees(): LiveData<List<String>> {
        return repository.getStoresOfAllCoffees().asLiveData()
    }
}

class FilterViewModelFactory(private val repository: CoffeeRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FilterViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return FilterViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}