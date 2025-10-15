package com.example.myandroidapp.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.example.myandroidapp.model.Car;
import com.example.myandroidapp.repository.CarRepository;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004JB\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u001a\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u000b0\u0012J\u000e\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0018"}, d2 = {"Lcom/example/myandroidapp/viewmodel/CarViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/example/myandroidapp/repository/CarRepository;", "(Lcom/example/myandroidapp/repository/CarRepository;)V", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/example/myandroidapp/viewmodel/CarUiState;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "addCar", "", "name", "", "model", "license", "color", "onResult", "Lkotlin/Function2;", "", "deleteCar", "car", "Lcom/example/myandroidapp/model/Car;", "Factory", "app_debug"})
public final class CarViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.myandroidapp.repository.CarRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.myandroidapp.viewmodel.CarUiState> uiState = null;
    
    public CarViewModel(@org.jetbrains.annotations.NotNull()
    com.example.myandroidapp.repository.CarRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.myandroidapp.viewmodel.CarUiState> getUiState() {
        return null;
    }
    
    public final void addCar(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String model, @org.jetbrains.annotations.NotNull()
    java.lang.String license, @org.jetbrains.annotations.NotNull()
    java.lang.String color, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super java.lang.Boolean, ? super java.lang.String, kotlin.Unit> onResult) {
    }
    
    public final void deleteCar(@org.jetbrains.annotations.NotNull()
    com.example.myandroidapp.model.Car car) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J%\u0010\u0005\u001a\u0002H\u0006\"\b\b\u0000\u0010\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\tH\u0016\u00a2\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/example/myandroidapp/viewmodel/CarViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "repository", "Lcom/example/myandroidapp/repository/CarRepository;", "(Lcom/example/myandroidapp/repository/CarRepository;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "app_debug"})
    public static final class Factory implements androidx.lifecycle.ViewModelProvider.Factory {
        @org.jetbrains.annotations.NotNull()
        private final com.example.myandroidapp.repository.CarRepository repository = null;
        
        public Factory(@org.jetbrains.annotations.NotNull()
        com.example.myandroidapp.repository.CarRepository repository) {
            super();
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public <T extends androidx.lifecycle.ViewModel>T create(@org.jetbrains.annotations.NotNull()
        java.lang.Class<T> modelClass) {
            return null;
        }
    }
}