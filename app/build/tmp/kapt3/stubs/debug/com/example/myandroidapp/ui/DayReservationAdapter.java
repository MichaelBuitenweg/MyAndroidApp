package com.example.myandroidapp.ui;

import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myandroidapp.databinding.ItemDayReservationsBinding;
import com.example.myandroidapp.model.Car;
import com.example.myandroidapp.model.Reservation;
import java.text.SimpleDateFormat;
import java.util.*;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001eB-\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0004\u00a2\u0006\u0002\u0010\tJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u001c\u0010\u0011\u001a\u00020\u00062\n\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\u001c\u0010\u0014\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0010H\u0016J\u0014\u0010\u0018\u001a\u00020\u00062\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u001aJ0\u0010\u001b\u001a\u00020\u00062\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u001a2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\f0\u001a2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u001aR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/example/myandroidapp/ui/DayReservationAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/myandroidapp/ui/DayReservationAdapter$VH;", "onDoubleTapReservation", "Lkotlin/Function1;", "Lcom/example/myandroidapp/model/Reservation;", "", "onDoubleTapEmpty", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "cars", "", "Lcom/example/myandroidapp/model/Car;", "days", "reservations", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "submitDays", "dayList", "", "updateData", "carList", "reservationList", "VH", "app_debug"})
public final class DayReservationAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.myandroidapp.ui.DayReservationAdapter.VH> {
    @org.jetbrains.annotations.NotNull
    private final kotlin.jvm.functions.Function1<com.example.myandroidapp.model.Reservation, kotlin.Unit> onDoubleTapReservation = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.jvm.functions.Function1<java.lang.Long, kotlin.Unit> onDoubleTapEmpty = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<java.lang.Long> days = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.example.myandroidapp.model.Car> cars = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.example.myandroidapp.model.Reservation> reservations = null;
    
    public DayReservationAdapter(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.example.myandroidapp.model.Reservation, kotlin.Unit> onDoubleTapReservation, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.Long, kotlin.Unit> onDoubleTapEmpty) {
        super();
    }
    
    public final void submitDays(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.Long> dayList) {
    }
    
    public final void updateData(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.Long> dayList, @org.jetbrains.annotations.NotNull
    java.util.List<com.example.myandroidapp.model.Car> carList, @org.jetbrains.annotations.NotNull
    java.util.List<com.example.myandroidapp.model.Reservation> reservationList) {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.example.myandroidapp.ui.DayReservationAdapter.VH onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.example.myandroidapp.ui.DayReservationAdapter.VH holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0002J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/example/myandroidapp/ui/DayReservationAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/example/myandroidapp/databinding/ItemDayReservationsBinding;", "(Lcom/example/myandroidapp/ui/DayReservationAdapter;Lcom/example/myandroidapp/databinding/ItemDayReservationsBinding;)V", "dateFormat", "Ljava/text/SimpleDateFormat;", "bind", "", "dayStart", "", "isSameDay", "", "time", "day", "isWithin", "reservation", "Lcom/example/myandroidapp/model/Reservation;", "app_debug"})
    public final class VH extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final com.example.myandroidapp.databinding.ItemDayReservationsBinding binding = null;
        @org.jetbrains.annotations.NotNull
        private final java.text.SimpleDateFormat dateFormat = null;
        
        public VH(@org.jetbrains.annotations.NotNull
        com.example.myandroidapp.databinding.ItemDayReservationsBinding binding) {
            super(null);
        }
        
        public final void bind(long dayStart) {
        }
        
        private final boolean isSameDay(long time, long day) {
            return false;
        }
        
        private final boolean isWithin(com.example.myandroidapp.model.Reservation reservation, long day) {
            return false;
        }
    }
}