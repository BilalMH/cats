package uk.co.bilalhaider.cats.mobileapi.client.response

import kotlinx.serialization.Serializable
import uk.co.bilalhaider.cats.mobileapi.client.response.base.Response
import uk.co.bilalhaider.cats.model.SearchResultItem

/**
 * Created by Bilal Haider on 12/03/2022
 */
@Serializable
data class SearchResponse(
    override val data: List<SearchResultItem>
) : Response<List<SearchResultItem>>