package com.example.myandroidapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.example.myandroidapp.data.AppDatabase;
import com.example.myandroidapp.repository.CarRepository;
import com.example.myandroidapp.repository.ReservationRepository;
import com.example.myandroidapp.ui.SectionsPagerAdapter;
import com.example.myandroidapp.viewmodel.CarViewModel;
import com.example.myandroidapp.viewmodel.ReservationViewModel;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086.\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b@BX\u0086.\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f@BX\u0086.\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/example/myandroidapp/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "<set-?>", "Lcom/example/myandroidapp/viewmodel/CarViewModel$Factory;", "carViewModelFactory", "getCarViewModelFactory", "()Lcom/example/myandroidapp/viewmodel/CarViewModel$Factory;", "Lcom/example/myandroidapp/data/AppDatabase;", "database", "getDatabase", "()Lcom/example/myandroidapp/data/AppDatabase;", "Lcom/example/myandroidapp/viewmodel/ReservationViewModel$Factory;", "reservationViewModelFactory", "getReservationViewModelFactory", "()Lcom/example/myandroidapp/viewmodel/ReservationViewModel$Factory;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.example.myandroidapp.data.AppDatabase database;
    private com.example.myandroidapp.viewmodel.CarViewModel.Factory carViewModelFactory;
    private com.example.myandroidapp.viewmodel.ReservationViewModel.Factory reservationViewModelFactory;
    
    public MainActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.myandroidapp.data.AppDatabase getDatabase() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.myandroidapp.viewmodel.CarViewModel.Factory getCarViewModelFactory() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.myandroidapp.viewmodel.ReservationViewModel.Factory getReservationViewModelFactory() {
        return null;
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
}