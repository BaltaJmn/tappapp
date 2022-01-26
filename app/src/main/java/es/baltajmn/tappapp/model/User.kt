package es.baltajmn.tappapp.model;

data class User(val name: String = "", var order: ArrayList<Order> = ArrayList(), var expand : Boolean = false)
data class Order(val name: String = "", val price: Double = 0.00)