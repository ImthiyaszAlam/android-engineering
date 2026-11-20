package com.imthiyas.shoppingcart.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.imthiyas.shoppingcart.model.CartItem


@Database(
    entities = [CartItem::class],
    version = 1,
    exportSchema = false
)
abstract class CartDatabase : RoomDatabase() {
    abstract fun cartDao(): CartDao

    companion object {

        private var INSTANCE: CartDatabase? = null
        fun getDatabase(context: Context): CartDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    CartDatabase::class.java,
                    "shopping_cart_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}