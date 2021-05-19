package com.example.jointseminarably

import com.example.jointseminarably.detailproduct.ReviewDataSource
import com.example.jointseminarably.detailproduct.ReviewRepository
import com.example.jointseminarably.detailproduct.ReviewRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideReviewRepository(dataSource: ReviewDataSource): ReviewRepository = ReviewRepositoryImpl(dataSource)
}