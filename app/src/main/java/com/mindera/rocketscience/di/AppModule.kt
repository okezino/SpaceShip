package com.mindera.rocketscience.di

import com.mindera.rocketscience.common.NetworkUtil.BASE_URL
import com.mindera.rocketscience.data.network.service.MinderaApiService
import com.mindera.rocketscience.data.repository.CompanyInfoRepositoryImp
import com.mindera.rocketscience.data.repository.LaunchDetailsRepositoryImp
import com.mindera.rocketscience.data.repository.SearchLaunchDetailsRepositoryImp
import com.mindera.rocketscience.domain.repository.CompanyInfoRepository
import com.mindera.rocketscience.domain.repository.LaunchDetailsRepository
import com.mindera.rocketscience.domain.repository.SearchLaunchDetailsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideQuoteApiService(interceptor: Interceptor): MinderaApiService{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client( OkHttpClient.Builder()
                .addInterceptor(interceptor).build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MinderaApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideCompanyInfoRepository(minderaApiService: MinderaApiService) : CompanyInfoRepository{
        return CompanyInfoRepositoryImp(minderaApiService)
    }


    @Provides
    @Singleton
    fun provideLaunchDetailsRepository(minderaApiService: MinderaApiService) : LaunchDetailsRepository{
        return LaunchDetailsRepositoryImp(minderaApiService)
    }

    @Provides
    @Singleton
    fun provideSearchLaunchDetailsRepository(minderaApiService: MinderaApiService) : SearchLaunchDetailsRepository{
        return SearchLaunchDetailsRepositoryImp(minderaApiService)
    }

    @Provides
    @Singleton
    fun provideHeaderInterceptor(): Interceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }
}