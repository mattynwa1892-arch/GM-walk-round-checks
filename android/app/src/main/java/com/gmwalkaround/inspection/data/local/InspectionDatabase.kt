package com.gmwalkaround.inspection.data.local

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.RoomDatabase
import androidx.room.Update
import com.gmwalkaround.inspection.data.models.Inspection
import com.gmwalkaround.inspection.data.models.InspectionItem
import kotlinx.coroutines.flow.Flow

@Dao
interface InspectionDao {
    @Insert
    suspend fun insert(inspection: Inspection)

    @Update
    suspend fun update(inspection: Inspection)

    @Delete
    suspend fun delete(inspection: Inspection)

    @Query("SELECT * FROM inspections WHERE id = :id")
    suspend fun getInspectionById(id: String): Inspection?

    @Query("SELECT * FROM inspections ORDER BY createdAt DESC")
    fun getAllInspections(): Flow<List<Inspection>>

    @Query("UPDATE inspections SET synced = 1 WHERE id = :id")
    suspend fun markAsSynced(id: String)
}

@Dao
interface InspectionItemDao {
    @Insert
    suspend fun insert(item: InspectionItem)

    @Update
    suspend fun update(item: InspectionItem)

    @Query("SELECT * FROM inspection_items WHERE inspectionId = :inspectionId")
    fun getItemsByInspection(inspectionId: String): Flow<List<InspectionItem>>
}

@Database(
    entities = [Inspection::class, InspectionItem::class],
    version = 1,
    exportSchema = false
)
abstract class InspectionDatabase : RoomDatabase() {
    abstract fun inspectionDao(): InspectionDao
    abstract fun inspectionItemDao(): InspectionItemDao
}
