package com.example.myandroidapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.example.myandroidapp.MainActivity;
import com.example.myandroidapp.databinding.DayCellBinding;
import com.example.myandroidapp.databinding.FragmentCalendarBinding;
import com.example.myandroidapp.viewmodel.CarViewModel;
import com.example.myandroidapp.viewmodel.ReservationViewModel;
import com.kizitonwose.calendar.core.DayPosition;
import java.time.YearMonth;
import com.kizitonwose.calendar.view.MonthDayBinder;
import com.kizitonwose.calendar.view.ViewContainer;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import androidx.appcompat.app.AlertDialog;
import java.time.format.DateTimeFormatter;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000fH\u0002J$\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\'H\u0016J\u001a\u0010(\u001a\u00020\'2\u0006\u0010)\u001a\u00020\u001f2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0018\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0018H\u0002J\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u001cH\u0002J\b\u00102\u001a\u00020\'H\u0002J\u0010\u00103\u001a\u00020\'2\u0006\u0010.\u001a\u00020\u0018H\u0002J#\u00104\u001a\u00020\'2\b\u00105\u001a\u0004\u0018\u00010-2\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u001aH\u0002\u00a2\u0006\u0002\u00107J\u0010\u00108\u001a\u00020\'2\u0006\u0010\u001d\u001a\u00020\u000fH\u0002J\f\u00109\u001a\u00020\u001a*\u00020\u0018H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\r\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006:"}, d2 = {"Lcom/example/myandroidapp/ui/CalendarFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/example/myandroidapp/databinding/FragmentCalendarBinding;", "binding", "getBinding", "()Lcom/example/myandroidapp/databinding/FragmentCalendarBinding;", "carViewModel", "Lcom/example/myandroidapp/viewmodel/CarViewModel;", "getCarViewModel", "()Lcom/example/myandroidapp/viewmodel/CarViewModel;", "carViewModel$delegate", "Lkotlin/Lazy;", "currentMonth", "Ljava/time/YearMonth;", "firstDayOfWeek", "Ljava/time/DayOfWeek;", "reservationViewModel", "Lcom/example/myandroidapp/viewmodel/ReservationViewModel;", "getReservationViewModel", "()Lcom/example/myandroidapp/viewmodel/ReservationViewModel;", "reservationViewModel$delegate", "millisToLocalDate", "Ljava/time/LocalDate;", "ms", "", "monthLabel", "", "month", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "onViewCreated", "view", "overlaps", "", "res", "Lcom/example/myandroidapp/model/Reservation;", "date", "parseColorSafe", "", "hex", "setupCalendar", "showDayReservationsDialog", "showReservationDialog", "reservation", "dayStart", "(Lcom/example/myandroidapp/model/Reservation;Ljava/lang/Long;)V", "updateMonth", "toEpochDayMillis", "app_debug"})
public final class CalendarFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable
    private com.example.myandroidapp.databinding.FragmentCalendarBinding _binding;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy carViewModel$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy reservationViewModel$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final java.time.DayOfWeek firstDayOfWeek = java.time.DayOfWeek.MONDAY;
    @org.jetbrains.annotations.NotNull
    private java.time.YearMonth currentMonth;
    
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
    
    private final void setupCalendar() {
    }
    
    private final void showDayReservationsDialog(java.time.LocalDate date) {
    }
    
    private final boolean overlaps(com.example.myandroidapp.model.Reservation res, java.time.LocalDate date) {
        return false;
    }
    
    private final java.time.LocalDate millisToLocalDate(long ms) {
        return null;
    }
    
    private final long toEpochDayMillis(java.time.LocalDate $this$toEpochDayMillis) {
        return 0L;
    }
    
    private final int parseColorSafe(java.lang.String hex) {
        return 0;
    }
    
    private final void updateMonth(java.time.YearMonth month) {
    }
    
    private final java.lang.String monthLabel(java.time.YearMonth month) {
        return null;
    }
    
    private final void showReservationDialog(com.example.myandroidapp.model.Reservation reservation, java.lang.Long dayStart) {
    }
    
    @java.lang.Override
    public void onDestroyView() {
    }
}