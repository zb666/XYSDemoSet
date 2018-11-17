package com.example.mechrevo.xysdemoset.kotlin

data class KotlinAndroid(var id: Long, var name: String) {
    override fun toString(): String {
        return "[User(id = $id,name=$name)]"
    }
}