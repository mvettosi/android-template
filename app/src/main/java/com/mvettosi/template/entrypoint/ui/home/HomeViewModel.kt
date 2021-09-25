package com.mvettosi.template.entrypoint.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mvettosi.template.core.domain.Name
import com.mvettosi.template.core.usecases.GetNameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel @Inject constructor(private val getNameUseCase: GetNameUseCase) : ViewModel() {
  private val _name = MutableStateFlow<Name?>(null)
  val name: StateFlow<Name?> = _name

  fun refreshName() {
    viewModelScope.launch {
      _name.emit(Name(first = "...name", last = "loading..."))
      delay(100)
      _name.emit(getNameUseCase())
    }
  }
}
