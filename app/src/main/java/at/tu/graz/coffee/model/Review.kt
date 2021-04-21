package at.tu.graz.coffee.model

class Review {
    var taste: Int = 0
    set(value) {
        if (value in 0..10) field = value
    }
    var cost: Int = 0
        set(value) {
            if (value in 0..10) field = value
        }
    var availability:Int=0
        set(value) {
            if (value in 0..10) field = value
        }


}