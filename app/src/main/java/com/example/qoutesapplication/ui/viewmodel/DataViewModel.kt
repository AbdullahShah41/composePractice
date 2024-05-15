package com.example.qoutesapplication.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qoutesapplication.data.repository.DataRepository
import com.example.qoutesapplication.ui.intent.MainIntent
import com.example.qoutesapplication.ui.states.ViewStates
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DataViewModel @Inject constructor(private val dataRepository: DataRepository) : ViewModel() {

    val mainIntent : Channel<MainIntent> = Channel(Channel.UNLIMITED)

    private val _state = MutableStateFlow<ViewStates>(ViewStates.idle)
    val state: StateFlow<ViewStates> get() = _state

    init {
        handleIntent()
    }

    fun handleIntent() {
        viewModelScope.launch {
            mainIntent.consumeAsFlow().collect { mainIntentObject ->
                when (mainIntentObject) {
                    is MainIntent.getQuotes -> fetchQuotes()
                }
            }
        }
    }

    fun fetchQuotes() {
        viewModelScope.launch {
            _state.value = ViewStates.loading
            try {
                _state.value = ViewStates.success(dataList = dataRepository.getQuotes())
            } catch (exception: Exception) {
                Log.e("error", "Error while fetching quotes data : ${exception.localizedMessage} \ndue to : ${exception.cause}")
                _state.value = ViewStates.failure(errorMessage = exception.localizedMessage.toString())
                exception.printStackTrace()
            }
        }
    }
}
