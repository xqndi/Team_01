package at.tu.graz.coffee.model

import junit.framework.TestCase

class CoffeeDataTest : TestCase() {

    fun testGetCoffee() {
        val id = 2
        val coffee = CoffeeData.getCoffee(id)
        assertEquals(id, coffee?.coffeeId   )
    }

    fun testGetCoffeeList() {
        val ids: IntArray = intArrayOf(2, 4, 7)
        val coffees = CoffeeData.getCoffeeList(ids)
        coffees.forEach{
            assertEquals(true, ids.contains(it.coffeeId))
        }

    }

    fun testGetStoresOfAllCoffees() {
        val stores = CoffeeData.getStoresOfAllCoffees()
        val coffees = CoffeeData.getCoffees()
        coffees.forEach{
            assertEquals(true, stores.contains(it.storeToBuyFrom))
        }
    }

    fun testFilterCoffeeTotal() {
        val rangeTotal : List<Float> = listOf(3f, 7f)
        val rangeTaste : List<Float> = listOf(0f, 10f)
        val rangeCost : List<Float> = listOf(0f, 10f)
        val rangeAvailability : List<Float> = listOf(0f, 10f)
        val selectedStore = ""
        val searchText = ""
        val filteredCoffees = CoffeeData.filterCoffee(rangeTotal, rangeTaste, rangeCost,
            rangeAvailability, selectedStore, searchText)

        val coffees = CoffeeData.getCoffeeList(filteredCoffees.toIntArray())
        coffees.forEach{
            assertEquals(true, it.evaluationTotal in 3.0..7.0)
        }
    }

    fun testFilterCoffeeTaste() {
        val rangeTotal : List<Float> = listOf(0f, 10f)
        val rangeTaste : List<Float> = listOf(3f, 7f)
        val rangeCost : List<Float> = listOf(0f, 10f)
        val rangeAvailability : List<Float> = listOf(0f, 10f)
        val selectedStore = ""
        val searchText = ""
        val filteredCoffees = CoffeeData.filterCoffee(rangeTotal, rangeTaste, rangeCost,
            rangeAvailability, selectedStore, searchText)

        val coffees = CoffeeData.getCoffeeList(filteredCoffees.toIntArray())
        coffees.forEach{
            assertEquals(true, it.evaluationTaste in 3.0..7.0)
        }
    }

    fun testFilterCoffeeCost() {
        val rangeTotal : List<Float> = listOf(0f, 10f)
        val rangeTaste : List<Float> = listOf(0f, 10f)
        val rangeCost : List<Float> = listOf(3f, 7f)
        val rangeAvailability : List<Float> = listOf(0f, 10f)
        val selectedStore = ""
        val searchText = ""
        val filteredCoffees = CoffeeData.filterCoffee(rangeTotal, rangeTaste, rangeCost,
            rangeAvailability, selectedStore, searchText)

        val coffees = CoffeeData.getCoffeeList(filteredCoffees.toIntArray())
        coffees.forEach{
            assertEquals(true, it.evaluationCost in 3.0..7.0)
        }
    }

    fun testFilterCoffeeAvailability() {
        val rangeTotal : List<Float> = listOf(0f, 10f)
        val rangeTaste : List<Float> = listOf(0f, 10f)
        val rangeCost : List<Float> = listOf(0f, 10f)
        val rangeAvailability : List<Float> = listOf(3f, 7f)
        val selectedStore = ""
        val searchText = ""
        val filteredCoffees = CoffeeData.filterCoffee(rangeTotal, rangeTaste, rangeCost,
            rangeAvailability, selectedStore, searchText)

        val coffees = CoffeeData.getCoffeeList(filteredCoffees.toIntArray())
        coffees.forEach{
            assertEquals(true, it.evaluationAvailability in 3.0..7.0)
        }
    }

    fun testFilterCoffeeSelectedStore() {
        val rangeTotal : List<Float> = listOf(0f, 10f)
        val rangeTaste : List<Float> = listOf(0f, 10f)
        val rangeCost : List<Float> = listOf(0f, 10f)
        val rangeAvailability : List<Float> = listOf(0f, 10f)
        val selectedStore = "Amazon"
        val searchText = ""
        val filteredCoffees = CoffeeData.filterCoffee(rangeTotal, rangeTaste, rangeCost,
            rangeAvailability, selectedStore, searchText)

        val coffees = CoffeeData.getCoffeeList(filteredCoffees.toIntArray())
        coffees.forEach{
            assertEquals(true, it.storeToBuyFrom == selectedStore )
        }
    }

    fun testFilterCoffeeSearchText() {
        val rangeTotal : List<Float> = listOf(0f, 10f)
        val rangeTaste : List<Float> = listOf(0f, 10f)
        val rangeCost : List<Float> = listOf(0f, 10f)
        val rangeAvailability : List<Float> = listOf(0f, 10f)
        val selectedStore = ""
        val searchText = "Black"
        val filteredCoffees = CoffeeData.filterCoffee(rangeTotal, rangeTaste, rangeCost,
            rangeAvailability, selectedStore, searchText)

        val coffees = CoffeeData.getCoffeeList(filteredCoffees.toIntArray())
        coffees.forEach{
            assertEquals(true, it.name.contains(searchText, ignoreCase = true))
        }
    }
}