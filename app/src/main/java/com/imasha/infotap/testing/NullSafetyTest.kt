package com.imasha.infotap.testing

import android.util.Log

object NullSafetyTest {

    private const val TAG = "NullSafetyTest"

    fun runAllTests() {
        Log.d(TAG, "========== Kotlin Null Safety Tests ==========")

        basicNullableType()
        safeCallOperator()
        elvisOperator()
        notNullAssertion()
        smartCast()
        letWithNullableValue()
        nullableBoolean()
        nullableCollections()
        stringNullHelpers()
        requireNotNullExample()
        checkNotNullExample()
        nullableReceiver()

        Log.d(TAG, "========== Tests Completed ==========")
    }

    // --------------------------------------------------
    // 1. Nullable vs Non-nullable
    // --------------------------------------------------

    private fun basicNullableType() {
        Log.d(TAG, "--- 1. Nullable vs Non-nullable ---")

        val nonNullableName: String = "Kotlin"
        val nullableName: String? = null

        Log.d(TAG, "nonNullableName = $nonNullableName")
        Log.d(TAG, "nullableName = $nullableName")
    }

    // --------------------------------------------------
    // 2. Safe Call ?.
    // --------------------------------------------------

    private fun safeCallOperator() {
        Log.d(TAG, "--- 2. Safe Call ?. ---")

        val name: String? = null

        val length = name?.length

        Log.d(TAG, "name = $name")
        Log.d(TAG, "name?.length = $length")
    }

    // --------------------------------------------------
    // 3. Elvis Operator ?:
    // --------------------------------------------------

    private fun elvisOperator() {
        Log.d(TAG, "--- 3. Elvis Operator ?: ---")

        val name: String? = null

        val displayName = name ?: "Unknown"

        Log.d(TAG, "name = $name")
        Log.d(TAG, "displayName = $displayName")
    }

    // --------------------------------------------------
    // 4. Not-null Assertion !!
    // --------------------------------------------------

    private fun notNullAssertion() {
        Log.d(TAG, "--- 4. Not-null Assertion !! ---")

        val safeName: String? = "Kotlin"

        // Safe because safeName is not null.
        val length = safeName!!.length

        Log.d(TAG, "safeName = $safeName")
        Log.d(TAG, "safeName!!.length = $length")

        /*
         * DO NOT run this unless you specifically want
         * to see the NullPointerException.
         *
         * val unsafeName: String? = null
         * Log.d(TAG, "${unsafeName!!.length}")
         */
    }

    // --------------------------------------------------
    // 5. Smart Cast
    // --------------------------------------------------

    private fun smartCast() {
        Log.d(TAG, "--- 5. Smart Cast ---")

        val name: String? = "Kotlin"
        val temp: String;

        if (name != null) {
            // Kotlin automatically treats name as String here.
            Log.d(TAG, "Name = $name")
            Log.d(TAG, "Length = ${name.length}")
        }
    }

    // --------------------------------------------------
    // 6. let with Nullable Value
    // --------------------------------------------------

    private fun letWithNullableValue() {
        Log.d(TAG, "--- 6. let with Nullable Value ---")

        val name: String? = "Kotlin"

        name?.let { value ->
            Log.d(TAG, "let executed")
            Log.d(TAG, "Value = $value")
            Log.d(TAG, "Length = ${value.length}")
        }

        val nullName: String? = null

        nullName?.let {
            // This will NOT execute.
            Log.d(TAG, "This log will not appear")
        }

        Log.d(TAG, "nullName let block was skipped")
    }

    // --------------------------------------------------
    // 7. Nullable Boolean
    // --------------------------------------------------

    private fun nullableBoolean() {
        Log.d(TAG, "--- 7. Nullable Boolean ---")

        val enabled: Boolean? = null

        if (enabled == true) {
            Log.d(TAG, "Feature is enabled")
        } else {
            Log.d(TAG, "Feature is disabled or null")
        }

        Log.d(TAG, "enabled = $enabled")
    }

    // --------------------------------------------------
    // 8. Nullable Collections
    // --------------------------------------------------

    private fun nullableCollections() {
        Log.d(TAG, "--- 8. Nullable Collections ---")

        // List itself can be null.
        val nullableList: List<String>? = null

        Log.d(TAG, "nullableList size = ${nullableList?.size}")

        // Elements can be null.
        val listWithNullableItems: List<String?> = listOf(
            "Android",
            null,
            "Kotlin",
            null
        )

        Log.d(TAG, "listWithNullableItems = $listWithNullableItems")

        val nonNullItems = listWithNullableItems.filterNotNull()

        Log.d(TAG, "filterNotNull() = $nonNullItems")
    }

    // --------------------------------------------------
    // 9. isNullOrEmpty / isNullOrBlank / orEmpty
    // --------------------------------------------------

    private fun stringNullHelpers() {
        Log.d(TAG, "--- 9. String Null Helpers ---")

        val nullText: String? = null
        val emptyText: String? = ""
        val blankText: String? = "   "

        Log.d(TAG, "nullText.isNullOrEmpty() = ${nullText.isNullOrEmpty()}")
        Log.d(TAG, "emptyText.isNullOrEmpty() = ${emptyText.isNullOrEmpty()}")

        Log.d(TAG, "blankText.isNullOrBlank() = ${blankText.isNullOrBlank()}")

        Log.d(TAG, "nullText.orEmpty() = '${nullText.orEmpty()}'")
    }

    // --------------------------------------------------
    // 10. requireNotNull()
    // --------------------------------------------------

    private fun requireNotNullExample() {
        Log.d(TAG, "--- 10. requireNotNull() ---")

        val userName: String? = "Imasha"

        val nonNullUserName = requireNotNull(userName) {
            "User name is required"
        }

        Log.d(TAG, "userName = $nonNullUserName")
    }

    // --------------------------------------------------
    // 11. checkNotNull()
    // --------------------------------------------------

    private fun checkNotNullExample() {
        Log.d(TAG, "--- 11. checkNotNull() ---")

        val userName: String? = "Imasha"

        val nonNullUserName = checkNotNull(userName) {
            "User name was not initialized"
        }

        Log.d(TAG, "userName = $nonNullUserName")
    }

    // --------------------------------------------------
    // 12. Nullable Receiver
    // --------------------------------------------------

    private fun nullableReceiver() {
        Log.d(TAG, "--- 12. Nullable Receiver ---")

        val name: String? = null

        name.printValue()

        val anotherName: String? = "Kotlin"

        anotherName.printValue()
    }

    private fun String?.printValue() {
        Log.d(TAG, "Nullable receiver value = ${this ?: "null"}")
    }
}