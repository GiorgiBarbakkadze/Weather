package com.gb.data.network

interface MapFromDataToDomain <T: Any>{
    fun map(): T
}
