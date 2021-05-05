package at.tu.graz.coffee.model

object CoffeeData {
    private val reviews : List<Review> = listOf(
        Review(1, 2,10,  "Just a comment"),
        Review(10, 3,4,  "Another comment"),
        Review(6, 5,5,  "1"),
        Review(1, 1,1,  "2"),
        Review(6, 6,2,  "3"),
        Review(1, 7,5,  "4"),
        Review(3, 4,7,  "5")
    )
    private val coffees : List<Coffee> = listOf(
        Coffee(1,"Caffe Crema", 9.00, "Supermarket",
            CoffeeType.NONE, 1.00,1," ",
            "spar_premium_caffe_crema", reviews as MutableList<Review>
        ),
        Coffee(2,"Barista Espresso", 3.50, "Supermarket",
            CoffeeType.NONE, 1.00,1," ",
            "tchibo_barista_espresso",reviews as MutableList<Review> ),
        Coffee(3,"Black and White", 5.0, "Supermarket",
            CoffeeType.NONE, 1.00,1," ",
            "tchibo_black_and_white",reviews as MutableList<Review> ),
        Coffee(4,"Caffe Crema", 9.00, "Supermarket",
            CoffeeType.NONE, 1.00,1," ",
            "spar_premium_caffe_crema",reviews as MutableList<Review> ),
        Coffee(5,"Barista Espresso", 3.50, "Supermarket",
            CoffeeType.NONE, 1.00,1," ",
            "tchibo_barista_espresso",reviews as MutableList<Review> ),
        Coffee(6,"Black and White", 5.0, "Supermarket",
            CoffeeType.NONE, 1.00,1," ",
            "tchibo_black_and_white",reviews as MutableList<Review> ),
        Coffee(7,"Caffe Crema", 9.00, "Supermarket",
            CoffeeType.NONE, 1.00,1," ",
            "spar_premium_caffe_crema" ,reviews as MutableList<Review>),
        Coffee(8,"Barista Espresso", 3.50, "Supermarket",
            CoffeeType.NONE, 1.00,1," ",
            "tchibo_barista_espresso",reviews as MutableList<Review> ),
        Coffee(9,"Black and White", 5.0, "Supermarket",
            CoffeeType.NONE, 1.00,1," ",
            "tchibo_black_and_white",reviews as MutableList<Review> ),
        Coffee(10,"Black and White", 5.0, "Supermarket",
            CoffeeType.NONE, 1.00,1," ",
            "tchibo_black_and_white" ,reviews as MutableList<Review>),
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
}
