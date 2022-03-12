package uk.co.bilalhaider.cats.model

import kotlinx.serialization.Serializable

/**
 * Created by Bilal Haider on 07/03/2022
 */
@Serializable
data class WeightData(
    val imperial: String,
    val metric: String
)