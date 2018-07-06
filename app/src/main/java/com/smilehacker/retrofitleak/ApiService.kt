package com.smilehacker.retrofitleak

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable

interface ApiService {


    @GET("oversea/hot/{bucket}_{page}.json")
    fun getHotFeed(@Path("bucket") bucket: String = "ko", @Path("page") page: Int = 1) : Call<FeedResp>

    @GET("oversea/hot/{bucket}_{page}.json")
    fun getHotFeedInResp(@Path("bucket") bucket: String = "ko", @Path("page") page: Int = 1) : Call<Response<FeedResp>>

    @GET("oversea/hot/{bucket}_{page}.json")
    fun getHotFeedRx(@Path("bucket") bucket: String = "ko", @Path("page") page: Int = 1) : Observable<FeedResp>

    @GET("oversea/hot/{bucket}_{page}.json")
    fun getHotFeedInRespRx(@Path("bucket") bucket: String = "ko", @Path("page") page: Int = 1) : Observable<Response<FeedResp>>
}