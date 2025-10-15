package com.example.myandroidapp.ui;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myandroidapp.R;
import com.example.myandroidapp.model.Car;
import com.example.myandroidapp.model.Reservation;
import java.util.Calendar;
import java.util.Date;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001fBR\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0004\u0012#\u0010\t\u001a\u001f\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0004\u00a2\u0006\u0002\u0010\u000eJ\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u001c\u0010\u0014\u001a\u00020\u00062\n\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0013H\u0016J\u001c\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0013H\u0016J\"\u0010\u001b\u001a\u00020\u00062\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u001dR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010\t\u001a\u001f\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/example/myandroidapp/ui/CalendarMonthAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/myandroidapp/ui/CalendarMonthAdapter$DayVH;", "onDayClick", "Lkotlin/Function1;", "", "", "onReservationDoubleTap", "Lcom/example/myandroidapp/model/Reservation;", "resolveCarColor", "Lkotlin/ParameterName;", "name", "carId", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "dayTimestamps", "", "reservations", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "submit", "monthDays", "", "reservationList", "DayVH", "app_debug"})
public final class CalendarMonthAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.myandroidapp.ui.CalendarMonthAdapter.DayVH> {
    @org.jetbrains.annotations.NotNull
    private final kotlin.jvm.functions.Function1<java.lang.Long, kotlin.Unit> onDayClick = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.jvm.functions.Function1<com.example.myandroidapp.model.Reservation, kotlin.Unit> onReservationDoubleTap = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.jvm.functions.Function1<java.lang.Long, java.lang.String> resolveCarColor = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<java.lang.Long> dayTimestamps = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.example.myandroidapp.model.Reservation> reservations = null;
    
    public CalendarMonthAdapter(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.Long, kotlin.Unit> onDayClick, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.example.myandroidapp.model.Reservation, kotlin.Unit> onReservationDoubleTap, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.Long, java.lang.String> resolveCarColor) {
        super();
    }
    
    public final void submit(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.Long> monthDays, @org.jetbrains.annotations.NotNull
    java.util.List<com.example.myandroidapp.model.Reservation> reservationList) {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.example.myandroidapp.ui.CalendarMonthAdapter.DayVH onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.example.myandroidapp.ui.CalendarMonthAdapter.DayVH holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/example/myandroidapp/ui/CalendarMonthAdapter$DayVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/example/myandroidapp/ui/CalendarMonthAdapter;Landroid/view/View;)V", "dotsContainer", "Landroid/view/ViewGroup;", "textDay", "Landroid/widget/TextView;", "bind", "", "dayStart", "", "overlapsDay", "", "res", "Lcom/example/myandroidapp/model/Reservation;", "safeParseColor", "", "hex", "", "app_debug"})
    public final class DayVH extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView textDay = null;
        @org.jetbrains.annotations.NotNull
        private final android.view.ViewGroup dotsContainer = null;
        
        public DayVH(@org.jetbrains.annotations.NotNull
        android.view.View itemView) {
            super(null);
        }
        
        public final void bind(long dayStart) {
        }
        
        private final boolean overlapsDay(com.example.myandroidapp.model.Reservation res, long dayStart) {
            return false;
        }
        
        private final int safeParseColor(java.lang.String hex) {
            return 0;
        }
    }
}