package uk.co.bilalhaider.cats.mobileapi.client

import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


/**
 * Created by Bilal Haider on 12/03/2022
 */
class MobileAPIClient() {

    private var _httpClient: HttpClient? = null

    internal val client: HttpClient
        get() {
            if (_httpClient == null) {
                _httpClient = HttpClient(OkHttp) {

                    install(HttpTimeout) {
                        requestTimeoutMillis = 30000
                        connectTimeoutMillis = 30000
                        socketTimeoutMillis = 30000
                    }

                    Json {
                        serializer = KotlinxSerializer()
                    }

                    defaultRequest {
                        val baseUrl = Url("https://api.thecatapi.com")

                        host = baseUrl.host
                        url {
                            protocol = baseUrl.protocol
                        }

                        header("x-api-key", "ace1caf2-82ac-4d6a-b6da-34231642123b")
                    }

                }
            }
            return _httpClient as HttpClient
        }

    internal suspend inline fun <reified T> executeGET(
        crossinline block: HttpRequestBuilder.() -> Unit = {}
    ): T? = withContext(Dispatchers.Default) {
        client.get<T>(block = block)
    }
}