package com.imthiyas.shoppingcart.util

 fun formatPrice(paise: Long): String {
    return "₹${paise / 100}.${(paise % 100).toString().padStart(2, '0')}"
}