package com.imthiyas.shoppingcart.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.imthiyas.shoppingcart.model.CartItem
import kotlinx.coroutines.flow.Flow

@Dao
interface CartDao {

    @Query("SELECT * FROM cart_items ORDER BY productId")
    fun getCartItems(): Flow<List<CartItem>>


    @Query(" SELECT * FROM cart_items WHERE productId=:id ")
    suspend fun getCartItem(id: Int): CartItem?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: CartItem)


    @Query(
        """UPDATE cart_items SET quantity = :quantity WHERE productId = :id"""
    )
    suspend fun updateQuantity(id: Int, quantity: Int)


    @Query("DELETE FROM cart_items WHERE productId = :id ")
    suspend fun deleteItem(id: Int)


    @Transaction
    suspend fun addToCart(product: CartItem) {
        val existing = getCartItem(product.productId)
        if (existing == null) {
            insertItem(product)
        } else {
            updateQuantity(product.productId, existing.quantity + 1)
        }
    }


    @Transaction
    suspend fun changeQuantity(id: Int, delta: Int) {
        val existing = getCartItem(id) ?: return
        val newQuantity = existing.quantity + delta

        if (newQuantity <= 0) {
            deleteItem(id)
        } else {
            updateQuantity(id, newQuantity)
        }
    }


}