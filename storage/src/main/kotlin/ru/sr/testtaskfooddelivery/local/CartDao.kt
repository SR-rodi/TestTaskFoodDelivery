package ru.sr.testtaskfooddelivery.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface CartDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: CartItemEntity)

    @Update(entity = CartItemEntity::class)
    suspend fun update(item: CartItemEntity)

    @Query("SELECT * FROM cart")
    fun getAllItems(): Flow<List<CartItemEntity>>

    @Query("SELECT name FROM cart WHERE dishe_id = :id")
    fun getItemById(id: Int): String?

    @Query("DELETE FROM cart WHERE dishe_id = :id")
    suspend fun delete(id: Int)

}