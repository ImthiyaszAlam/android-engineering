package com.imthiyas.shoppingcart.data

import com.imthiyas.shoppingcart.model.Product

class ProductRepository {

    fun getProducts(): List<Product> =listOf(
        Product(1,"Headphones",149900),
        Product(2,"Keyboard",299900),
        Product(3,"Mouse",79900),
        Product(4,"Monitor",1299900),
        Product(5,"USB Cable",29900),
        Product(6,"Watch",399900),
    )
}