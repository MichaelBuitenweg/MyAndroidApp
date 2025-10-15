package com.example.myandroidapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import com.example.myandroidapp.MainActivity;
import com.example.myandroidapp.databinding.FragmentCalendarBinding;
import com.example.myandroidapp.viewmodel.CarViewModel;
import com.example.myandroidapp.viewmodel.ReservationViewModel;
import java.util.Calendar;
import java.util.Locale;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001cH\u0002J$\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0016J\b\u0010(\u001a\u00020\u001cH\u0016J\u001a\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020!2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0016J#\u0010+\u001a\u00020\u001c2\b\u0010,\u001a\u0004\u0018\u00010-2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0015H\u0002\u00a2\u0006\u0002\u0010/R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u0018\u0010\u0019\u00a8\u00060"}, d2 = {"Lcom/example/myandroidapp/ui/CalendarFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/example/myandroidapp/databinding/FragmentCalendarBinding;", "adapter", "Lcom/example/myandroidapp/ui/CalendarMonthAdapter;", "binding", "getBinding", "()Lcom/example/myandroidapp/databinding/FragmentCalendarBinding;", "carViewModel", "Lcom/example/myandroidapp/viewmodel/CarViewModel;", "getCarViewModel", "()Lcom/example/myandroidapp/viewmodel/CarViewModel;", "carViewModel$delegate", "Lkotlin/Lazy;", "currentMonthCal", "Ljava/util/Calendar;", "kotlin.jvm.PlatformType", "monthDays", "", "", "reservationViewModel", "Lcom/example/myandroidapp/viewmodel/ReservationViewModel;", "getReservationViewModel", "()Lcom/example/myandroidapp/viewmodel/ReservationViewModel;", "reservationViewModel$delegate", "changeMonth", "", "delta", "", "generateMonthDays", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "showReservationDialog", "reservation", "Lcom/example/myandroidapp/model/Reservation;", "dayStart", "(Lcom/example/myandroidapp/model/Reservation;Ljava/lang/Long;)V", "app_debug"})
public final class CalendarFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable
    private com.example.myandroidapp.databinding.FragmentCalendarBinding _binding;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy carViewModel$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy reservationViewModel$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<java.lang.Long> monthDays = null;
    private java.util.Calendar currentMonthCal;
    @org.jetbrains.annotations.NotNull
    private final com.example.myandroidapp.ui.CalendarMonthAdapter adapter = null;
    
    public CalendarFragment() {
        super();
    }
    
    private final com.example.myandroidapp.databinding.FragmentCalendarBinding getBinding() {
        return null;
    }
    
    private final com.example.myandroidapp.viewmodel.CarViewModel getCarViewModel() {
        return null;
    }
    
    private final com.example.myandroidapp.viewmodel.ReservationViewModel getReservationViewModel() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void generateMonthDays() {
    }
    
    private final void changeMonth(int delta) {
    }
    
    private final void showReservationDialog(com.example.myandroidapp.model.Reservation reservation, java.lang.Long dayStart) {
    }
    
    @java.lang.Override
    public void onDestroyView() {
    }
}