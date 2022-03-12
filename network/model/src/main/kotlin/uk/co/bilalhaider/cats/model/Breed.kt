package uk.co.bilalhaider.cats.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by Bilal Haider on 07/03/2022
 */
@Serializable
data class Breed(
    val weight: WeightData,
    val id: String,
    val name: String,
    val temperament: String,
    val description: String,
    @SerialName("wikipedia_url") val wikipediaUrl: String,
    @SerialName("life_span") val lifeSpan: String
)