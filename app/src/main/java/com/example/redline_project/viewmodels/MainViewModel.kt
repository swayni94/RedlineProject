package com.example.redline_project.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.redline_project.data.ResultData
import com.example.redline_project.models.ResponseResult
import com.example.redline_project.repository.AppRepository
import com.example.redline_project.repository2.RepositoryRxjava
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val repository: AppRepository,
    private val repositoryRxjava: RepositoryRxjava
) : ViewModel() {

    val disposable = CompositeDisposable()

    private val _resultDatalinks = MutableLiveData<List<String>>()
    var resultDataLink : LiveData<List<String>> = _resultDatalinks

    private val _errorString = MutableLiveData<String>()
    var errorString : LiveData<String> = _errorString


    fun getDataList(dogtype: String){
        viewModelScope.launch {
            try {
                when (val response = repository.getdogtypelist(dogtype)){
                    is ResultData.Success -> {
                        _resultDatalinks.postValue(response.data.message)
                        _errorString.postValue("")
                    }
                    is ResultData.Error -> {
                        _errorString.postValue("Bir Hata Olustu.")
                    }
                }
            }catch (e: Exception){
                Log.e("response", "fffffffff")
            }

        }
    }

    fun fechDataRxjava(dogtype: String){
        disposable.add(
            repositoryRxjava.getListdata(dogtype).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<ResponseResult>(){
                    override fun onSuccess(t: ResponseResult) {
                        Log.e("pioow", "oley")
                    }

                    override fun onError(e: Throwable) {
                        Log.e("hata","kontrol et")
                    }
                })
        )
    }
}