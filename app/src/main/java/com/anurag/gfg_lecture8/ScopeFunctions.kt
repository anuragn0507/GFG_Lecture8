package com.anurag.gfg_lecture8

//Scope functions -> let, apply, also, with, run
// Scope functions -> let , apply, also , with ,run

fun main(){
    val s  = "Kotlin"

 /*   s.let {
        println(it)
        print(it.length)
    }*/
    var text = Person().run{
        "Name of the person is $name"
    }



}

class Person{
    var name = "Hello"
}