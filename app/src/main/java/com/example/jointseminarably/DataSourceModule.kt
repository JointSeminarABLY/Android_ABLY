package com.example.jointseminarably

import com.example.jointseminarably.detailproduct.ReviewDataSource
import com.example.jointseminarably.detailproduct.ReviewDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideReviewDataSource(): ReviewDataSource = ReviewDataSourceImpl()
}