package com.dbappgame.myapplicationchallenge.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.dbappgame.myapplicationchallenge.domain.model.Dog
import com.dbappgame.myapplicationchallenge.domain.model.Resource
import com.dbappgame.myapplicationchallenge.domain.repository.DogRepository
import com.google.common.truth.Truth
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class DogViewModelTest {

    @get: Rule
    val rule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    val repository: DogRepository = mockk{
        coEvery { getDog() } returns Resource.Success(
            Dog("urlNew","success")
        )
    }

    val viewModel = DogViewModel(repository, dispatcher)


    @Test
    fun getDogSuccessResponse() = runTest {
        viewModel.getDog()
        advanceUntilIdle()

        Truth.assertThat(viewModel.dog.value?.message ?: "no").matches("urlNew")

    }

    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}