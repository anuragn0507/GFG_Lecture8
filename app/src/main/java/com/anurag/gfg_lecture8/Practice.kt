package com.anurag.gfg_lecture8

import java.util.*




//Kotlin program of lamda expression which returns integer valiue

var lambda = {a: Int, b:Int -> a+b}

fun higerFunction (lmda : (Int, Int) -> Int) { // If you are not taking any input & not returning any value
    // Then use (lmda: () -> Unit)

    var result = lmda(2, 4) // we will pass the value in the lambda function
    println("The sum of the two number is $result")
}

// Passing function as a parameter to Higher-Order function

fun printMe(S:String): Unit {
    println(S)
}

fun higerod(str: String, myFun:(String) -> Unit){
    myFun(str)
}

fun mul(a:Int,b:Int): Int{
    return a*b
}

fun higherorder2():((Int, Int) -> Int){
    return ::mul
}
fun main (){
    higerFunction(lambda)
    higerod("I want to be a best android developer", :: printMe)

    var multiply = higherorder2()
    var results = mul(2,5)
    println("Multiple of the two number is $results")
}

