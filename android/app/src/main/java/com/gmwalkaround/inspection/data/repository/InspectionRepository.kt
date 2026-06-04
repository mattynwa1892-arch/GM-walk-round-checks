package com.gmwalkaround.inspection.data.repository

import com.gmwalkaround.inspection.data.local.InspectionDatabase
import com.gmwalkaround.inspection.data.models.Inspection
import com.gmwalkaround.inspection.data.remote.InspectionApiService
import kotlinx.coroutines.flow.Flow

class InspectionRepository(
    private val database: InspectionDatabase,
    private val apiService: InspectionApiService
) {
    fun getAllInspections(): Flow<List<Inspection>> {
        return database.inspectionDao().getAllInspections()
    }

    suspend fun getInspectionById(id: String): Inspection? {
        return database.inspectionDao().getInspectionById(id)
    }

    suspend fun createInspection(inspection: Inspection) {
        database.inspectionDao().insert(inspection)
    }

    suspend fun updateInspection(inspection: Inspection) {
        database.inspectionDao().update(inspection)
        try {
            apiService.updateInspection(inspection.id, inspection)
            database.inspectionDao().markAsSynced(inspection.id)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    suspend fun deleteInspection(inspection: Inspection) {
        database.inspectionDao().delete(inspection)
    }
}
