package com.devscode.curso.exercises

fun main(){
    val edMaverick =  song("Somos nuevos seres","Ed maverick", 2023, 1_000_000)
      edMaverick.printDescription()
    edMaverick.isPopular
}

class song(
    val title:String,
    val artist:String,
    val yearPublished:Int,
    val playCout:Int
) {
  val isPopular:Boolean
      get() =  playCout >= 1000

    fun printDescription(){
        println("$title, performed by $artist, was released in year published $yearPublished.")
    }
}
