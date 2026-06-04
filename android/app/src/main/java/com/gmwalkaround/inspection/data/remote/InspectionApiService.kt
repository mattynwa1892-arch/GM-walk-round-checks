package com.gmwalkaround.inspection.data.remote

import com.gmwalkaround.inspection.data.models.Inspection
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface InspectionApiService {
    @GET("inspections")
    suspend fun getInspections(): List<Inspection>

    @POST("inspections")
    suspend fun createInspection(@Body inspection: Inspection): Inspection

    @PUT("inspections/{id}")
    suspend fun updateInspection(@Path("id") id: String, @Body inspection: Inspection): Inspection
}
