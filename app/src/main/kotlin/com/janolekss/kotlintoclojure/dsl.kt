package com.janolekss.kotlintoclojure

import clojure.java.api.*

/**
 * Created by janis.olekss on 1/6/2018.
 */

fun clojure(body : KotlinClojure.() -> Unit) = KotlinClojure(body)

class KotlinClojure(body : KotlinClojure.() -> Unit) {
    init { body() }


    fun f(command : String, vararg args : Any?) : Any {
        val cmd = command.split("/")
        val (ns, name) = if (cmd.size == 1) "" to cmd[0] else cmd[0] to cmd[1]
        val function = Clojure.`var`(ns,name)
        return when (args.size) {
            0 -> function.invoke()
            1 -> function.invoke(args[0])
            2 -> function.invoke(args[0], args[1])
            3 -> function.invoke(args[0], args[1], args[2])
            4 -> function.invoke(args[0], args[1], args[2], args[3])
            5 -> function.invoke(args[0], args[1], args[2], args[3], args[4])
            6 -> function.invoke(args[0], args[1], args[2], args[3], args[4], args[5])
            7 -> function.invoke(args[0], args[1], args[2], args[3], args[4], args[5], args[6])
            else -> throw IllegalArgumentException("I can't handle ${args.size} arguments")
        }
    }

    fun require(nameSpace: String) {
        val require = Clojure.`var`("clojure.core", "require");
        require.invoke(Clojure.read(nameSpace));
    }
}

