package com.example.myandroidapp.repository;

import com.example.myandroidapp.data.CarDao;
import com.example.myandroidapp.model.Car;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J*\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00f8\u0001\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0086@\u00f8\u0001\u0002\u00a2\u0006\u0002\u0010\u0015J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\bH\u0086@\u00f8\u0001\u0002\u00a2\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0082\u0002\u000f\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b\u0019\u00a8\u0006\u0018"}, d2 = {"Lcom/example/myandroidapp/repository/CarRepository;", "", "carDao", "Lcom/example/myandroidapp/data/CarDao;", "(Lcom/example/myandroidapp/data/CarDao;)V", "cars", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/myandroidapp/model/Car;", "getCars", "()Lkotlinx/coroutines/flow/Flow;", "addCar", "Lkotlin/Result;", "", "car", "addCar-gIAlu-s", "(Lcom/example/myandroidapp/model/Car;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "colorExists", "", "color", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteCar", "", "app_debug"})
public final class CarRepository {
    @org.jetbrains.annotations.NotNull
    private final com.example.myandroidapp.data.CarDao carDao = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.example.myandroidapp.model.Car>> cars = null;
    
    public CarRepository(@org.jetbrains.annotations.NotNull
    com.example.myandroidapp.data.CarDao carDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.myandroidapp.model.Car>> getCars() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deleteCar(@org.jetbrains.annotations.NotNull
    com.example.myandroidapp.model.Car car, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object colorExists(@org.jetbrains.annotations.NotNull
    java.lang.String color, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
}