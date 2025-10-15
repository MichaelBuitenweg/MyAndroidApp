package com.example.myandroidapp.ui;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import com.example.myandroidapp.databinding.DialogReservationBinding;
import com.example.myandroidapp.model.Car;
import com.example.myandroidapp.model.Reservation;
import com.example.myandroidapp.viewmodel.CarViewModel;
import com.example.myandroidapp.viewmodel.ReservationViewModel;
import com.example.myandroidapp.MainActivity;
import java.util.*;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/example/myandroidapp/ui/ReservationDialog;", "Landroidx/fragment/app/DialogFragment;", "reservation", "Lcom/example/myandroidapp/model/Reservation;", "dayStart", "", "(Lcom/example/myandroidapp/model/Reservation;Ljava/lang/Long;)V", "carViewModel", "Lcom/example/myandroidapp/viewmodel/CarViewModel;", "getCarViewModel", "()Lcom/example/myandroidapp/viewmodel/CarViewModel;", "carViewModel$delegate", "Lkotlin/Lazy;", "Ljava/lang/Long;", "reservationViewModel", "Lcom/example/myandroidapp/viewmodel/ReservationViewModel;", "getReservationViewModel", "()Lcom/example/myandroidapp/viewmodel/ReservationViewModel;", "reservationViewModel$delegate", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class ReservationDialog extends androidx.fragment.app.DialogFragment {
    @org.jetbrains.annotations.Nullable()
    private final com.example.myandroidapp.model.Reservation reservation = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long dayStart = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy carViewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy reservationViewModel$delegate = null;
    
    public ReservationDialog(@org.jetbrains.annotations.Nullable()
    com.example.myandroidapp.model.Reservation reservation, @org.jetbrains.annotations.Nullable()
    java.lang.Long dayStart) {
        super();
    }
    
    private final com.example.myandroidapp.viewmodel.CarViewModel getCarViewModel() {
        return null;
    }
    
    private final com.example.myandroidapp.viewmodel.ReservationViewModel getReservationViewModel() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public android.app.Dialog onCreateDialog(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
}