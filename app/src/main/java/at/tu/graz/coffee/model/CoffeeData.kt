package at.tu.graz.coffee.model

object CoffeeData {
    private val coffees : List<Coffee> = listOf(
        Coffee(1,"Caffe Crema", 9.00, "Supermarket",
            CoffeeType.NONE, 1.00,1," ",
            "spar_premium_caffe_crema" ),
        Coffee(2,"Barista Espresso", 3.50, "Supermarket",
            CoffeeType.NONE, 1.00,1," ",
            "tchibo_barista_espresso" ),
        Coffee(3,"Black and White", 5.0, "Supermarket",
            CoffeeType.NONE, 1.00,1," ",
            "tchibo_black_and_white" ),
        Coffee(4,"Caffe Crema", 9.00, "Supermarket",
            CoffeeType.NONE, 1.00,1," ",
            "spar_premium_caffe_crema"),
        Coffee(5,"Barista Espresso", 3.50, "Supermarket",
            CoffeeType.NONE, 1.00,1," ",
            "tchibo_barista_espresso" ),
        Coffee(6,"Black and White", 5.0, "Supermarket",
            CoffeeType.NONE, 1.00,1," ",
            "tchibo_black_and_white" ),
        Coffee(7,"Caffe Crema", 9.00, "Supermarket",
            CoffeeType.NONE, 1.00,1," ",
            "spar_premium_caffe_crema" ),
        Coffee(8,"Barista Espresso", 3.50, "Supermarket",
            CoffeeType.NONE, 1.00,1," ",
            "tchibo_barista_espresso" ),
        Coffee(9,"Black and White", 5.0, "Supermarket",
            CoffeeType.NONE, 1.00,1," ",
            "tchibo_black_and_white" ),
        Coffee(10,"Black and White", 5.0, "Supermarket",
            CoffeeType.NONE, 1.00,1," ",
            "tchibo_black_and_white" ),
    )

    fun getCoffees() : List<Coffee> {
        return coffees;
    }

    fun getCoffee(id: Int) : Coffee? {
        val coffeeList = coffees.filter{it.id == id}

        if(coffeeList.isNullOrEmpty()) {
            return null;
        }
        return coffeeList[0]
    }

    fun filterCoffee(rangeTotal: List<Float>, rangeTaste: List<Float>, rangeCost: List<Float>,
                     rangeAvailability: List<Float>) : List<Coffee> {
        val filteredCoffees: MutableList<Coffee> = mutableListOf()

        coffees.forEach{
            if(it.evaluationTotal >= rangeTotal[0] && it.evaluationTotal <= rangeTotal[1] &&
                it.evaluationTaste >= rangeTaste[0] && it.evaluationTaste <= rangeTaste[1] &&
                it.evaluationCost >= rangeCost[0] && it.evaluationCost <= rangeCost[1] &&
                it.evaluationAvailability >= rangeAvailability[0] &&
                it.evaluationAvailability <= rangeAvailability[1]) {
                filteredCoffees.add(it)
            }
        }
        return filteredCoffees
    }
}
