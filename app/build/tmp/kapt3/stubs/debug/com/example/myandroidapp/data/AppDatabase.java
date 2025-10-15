package com.example.myandroidapp.data;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.myandroidapp.model.Car;
import com.example.myandroidapp.model.Reservation;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\b"}, d2 = {"Lcom/example/myandroidapp/data/AppDatabase;", "Landroidx/room/RoomDatabase;", "()V", "carDao", "Lcom/example/myandroidapp/data/CarDao;", "reservationDao", "Lcom/example/myandroidapp/data/ReservationDao;", "Companion", "app_debug"})
@androidx.room.Database(entities = {com.example.myandroidapp.model.Car.class, com.example.myandroidapp.model.Reservation.class}, version = 2, exportSchema = false)
public abstract class AppDatabase extends androidx.room.RoomDatabase {
    @kotlin.jvm.Volatile()
    @org.jetbrains.annotations.Nullable()
    private static volatile com.example.myandroidapp.data.AppDatabase INSTANCE;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.myandroidapp.data.AppDatabase.Companion Companion = null;
    
    public AppDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.myandroidapp.data.CarDao carDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.myandroidapp.data.ReservationDao reservationDao();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/example/myandroidapp/data/AppDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/example/myandroidapp/data/AppDatabase;", "getDatabase", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.myandroidapp.data.AppDatabase getDatabase(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
    }
}