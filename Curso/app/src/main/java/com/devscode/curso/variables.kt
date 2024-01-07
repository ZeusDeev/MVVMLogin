package com.devscode.curso

//Variable Int
val age: Int = 30

//Variable Long
val example: Long = 40


fun main() {


    variablesDeTexto()
    showMyName(name = "Zeus Cach")
    showMyAge(currentAge = 19)
    add(25, 76)
    val mySubstract = subtract(10, 5)
    print(mySubstract)

}

fun showMyName(name: String) {
    println("Hola me llamo $name")
}

fun showMyAge(currentAge: Int) {
    println("Tengo $currentAge años")
}

fun add(firstNumber: Int, secondNumber: Int) {
    println(firstNumber + secondNumber)
}

fun subtract(firstNumber: Int, secondNumber: Int):Int =  firstNumber - secondNumber


fun variablesBooleanas() {
    //Variable Booleanas
    val booExample: Boolean = true

}

fun variablesDeTexto() {
    //Variable Char
    val charExample: Char = 'g'

    //Variable String


}

fun variableNumericas() {
    //Variable Int
    val age: Int = 30


    //Variable Long
    val example: Long = 40

    //Variables Float
    val floatExample: Float = 4.3F

    //Variables Double

    val doubleExample: Double = 404.3

}
