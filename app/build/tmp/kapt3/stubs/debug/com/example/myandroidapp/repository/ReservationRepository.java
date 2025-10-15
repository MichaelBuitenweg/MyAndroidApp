package com.example.myandroidapp.repository;

import com.example.myandroidapp.data.ReservationDao;
import com.example.myandroidapp.model.Reservation;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\u000eJ\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u0012\u001a\u00020\fJ\u0016\u0010\u0013\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/example/myandroidapp/repository/ReservationRepository;", "", "reservationDao", "Lcom/example/myandroidapp/data/ReservationDao;", "(Lcom/example/myandroidapp/data/ReservationDao;)V", "reservations", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/myandroidapp/model/Reservation;", "getReservations", "()Lkotlinx/coroutines/flow/Flow;", "addReservation", "", "reservation", "(Lcom/example/myandroidapp/model/Reservation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteReservation", "", "reservationsByCar", "carId", "updateReservation", "app_debug"})
public final class ReservationRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.example.myandroidapp.data.ReservationDao reservationDao = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.example.myandroidapp.model.Reservation>> reservations = null;
    
    public ReservationRepository(@org.jetbrains.annotations.NotNull()
    com.example.myandroidapp.data.ReservationDao reservationDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.myandroidapp.model.Reservation>> getReservations() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.myandroidapp.model.Reservation>> reservationsByCar(long carId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object addReservation(@org.jetbrains.annotations.NotNull()
    com.example.myandroidapp.model.Reservation reservation, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateReservation(@org.jetbrains.annotations.NotNull()
    com.example.myandroidapp.model.Reservation reservation, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteReservation(@org.jetbrains.annotations.NotNull()
    com.example.myandroidapp.model.Reservation reservation, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}