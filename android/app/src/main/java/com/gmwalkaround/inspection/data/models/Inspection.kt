package com.gmwalkaround.inspection.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "inspections")
data class Inspection(
    @PrimaryKey
    val id: String,
    val title: String,
    val description: String,
    val status: String = "pending",
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis(),
    val synced: Boolean = false
) : Serializable

@Entity(tableName = "inspection_items")
data class InspectionItem(
    @PrimaryKey
    val id: String,
    val inspectionId: String,
    val title: String,
    val description: String,
    val status: String = "pending",
    val photoPath: String? = null,
    val notes: String? = null,
    val createdAt: Long = System.currentTimeMillis()
) : Serializable
