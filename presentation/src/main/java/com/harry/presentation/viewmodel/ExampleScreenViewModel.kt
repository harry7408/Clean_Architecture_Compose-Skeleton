package com.harry.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.harry.domain.usecase.LocalUseCase
import com.harry.domain.usecase.RemoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExampleScreenViewModel @Inject constructor(
    private val localUseCase: LocalUseCase,
    private val remoteUseCase: RemoteUseCase,
) : ViewModel() {

    private var _name : MutableStateFlow<String> = MutableStateFlow("Test")
    val name = _name.asStateFlow()

    private var _id : MutableStateFlow<Int> = MutableStateFlow(0)
    val id = _id.asStateFlow()

    fun getName() {
        viewModelScope.launch {
            _name.value = localUseCase.invoke().name
        }
    }

    fun getId() {
        viewModelScope.launch {
            _id.value=remoteUseCase.invoke().score
        }
    }
}