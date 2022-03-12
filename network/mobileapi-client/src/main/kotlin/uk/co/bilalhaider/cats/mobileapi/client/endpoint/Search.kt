package uk.co.bilalhaider.cats.mobileapi.client.endpoint

import uk.co.bilalhaider.cats.mobileapi.client.MobileAPIClient
import uk.co.bilalhaider.cats.mobileapi.client.response.SearchResponse

/**
 * Created by Bilal Haider on 12/03/2022
 */
suspend fun MobileAPIClient.searchRandomImage(): SearchResponse? = executeGET<SearchResponse> {
    url {
        encodedPath = "/v1/images/search"
    }
}

suspend fun MobileAPIClient.searchBreed(
    breedId: String
): SearchResponse? = executeGET<SearchResponse> {
    url {
        encodedPath = "/v1/images/search?breed_ids=$breedId"
    }
}