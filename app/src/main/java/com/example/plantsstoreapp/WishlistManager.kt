package com.example.plantsstoreapp

import android.content.Context

object WishlistManager {

    private const val PREFS_NAME = "wishlist_prefs"
    private const val KEY_IDS    = "wishlist_ids"

    fun getWishlist(context: Context): MutableSet<Int> {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val raw   = prefs.getStringSet(KEY_IDS, emptySet()) ?: emptySet()
        return raw.mapNotNull { it.toIntOrNull() }.toMutableSet()
    }

    fun toggle(context: Context, plantaId: Int): Boolean {
        val prefs    = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val current  = getWishlist(context)
        val isAdding = !current.contains(plantaId)
        if (isAdding) current.add(plantaId) else current.remove(plantaId)
        prefs.edit()
            .putStringSet(KEY_IDS, current.map { it.toString() }.toSet())
            .apply()
        return isAdding
    }

    fun isInWishlist(context: Context, plantaId: Int): Boolean =
        getWishlist(context).contains(plantaId)

    fun clear(context: Context) {
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            .edit().remove(KEY_IDS).apply()
    }
}
