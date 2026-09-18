package com.imasha.infotap.testing

import android.util.Log
import com.imasha.infotap.domain.model.Source

object BasicTest {

    private const val TAG = "BasicTest"

    fun runAllTests() {
        //basic()
        scopeFunctions()
    }

    private fun basic() {
        val number = 10;
        val result = number.takeIf { it > 5 }

        Log.d(TAG, "takeIf: "+result)

        val user: String? = null;
        val requireUser = requireNotNull(user) {
            "User name is required"
        }

        Log.d(TAG, "requireUser: "+requireUser)
    }

    private fun scopeFunctions() {
        val name = "Imasha";
        val source = Source("1234", "Imasha")

        val length = name.let {
            (it.length) + 3
        }

        val user = source.run {
            name
        }

        val result = calculate(10, 5) { a, b ->
            a + b
        }

        val (id, person) = source;

        Log.d(TAG, "X: $person")
    }

    fun calculate(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
        return operation(a, b)
    }

    fun showMessage(message: String, callback: () -> Unit) {
        println(message)
        callback()
    }
}