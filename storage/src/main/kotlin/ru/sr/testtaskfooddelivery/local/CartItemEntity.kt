package ru.sr.testtaskfooddelivery.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart")
class CartItemEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "dishe_id")
    val id: Int?,
    val imageUrl: String,
    val name: String,
    val price: Int,
    val weight: Int,
)