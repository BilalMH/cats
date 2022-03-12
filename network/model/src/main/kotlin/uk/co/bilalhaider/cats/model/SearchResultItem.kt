package uk.co.bilalhaider.cats.model

import kotlinx.serialization.Serializable

/**
 * Created by Bilal Haider on 07/03/2022
 */
@Serializable
data class SearchResultItem(
    val breeds: List<Breed>,
    val id: String,
    val url: String,
    val width: Int,
    val height: Int
)