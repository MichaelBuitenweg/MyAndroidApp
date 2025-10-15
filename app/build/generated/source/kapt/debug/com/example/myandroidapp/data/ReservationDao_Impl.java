package com.example.myandroidapp.data;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.myandroidapp.model.Reservation;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class ReservationDao_Impl implements ReservationDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Reservation> __insertionAdapterOfReservation;

  private final EntityDeletionOrUpdateAdapter<Reservation> __deletionAdapterOfReservation;

  private final EntityDeletionOrUpdateAdapter<Reservation> __updateAdapterOfReservation;

  public ReservationDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfReservation = new EntityInsertionAdapter<Reservation>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `reservations` (`id`,`carId`,`startDate`,`endDate`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Reservation entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getCarId());
        statement.bindLong(3, entity.getStartDate());
        statement.bindLong(4, entity.getEndDate());
      }
    };
    this.__deletionAdapterOfReservation = new EntityDeletionOrUpdateAdapter<Reservation>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `reservations` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Reservation entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfReservation = new EntityDeletionOrUpdateAdapter<Reservation>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `reservations` SET `id` = ?,`carId` = ?,`startDate` = ?,`endDate` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Reservation entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getCarId());
        statement.bindLong(3, entity.getStartDate());
        statement.bindLong(4, entity.getEndDate());
        statement.bindLong(5, entity.getId());
      }
    };
  }

  @Override
  public Object insert(final Reservation reservation,
      final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfReservation.insertAndReturnId(reservation);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object delete(final Reservation reservation,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfReservation.handle(reservation);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object update(final Reservation reservation,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfReservation.handle(reservation);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Reservation>> getAll() {
    final String _sql = "SELECT `reservations`.`id` AS `id`, `reservations`.`carId` AS `carId`, `reservations`.`startDate` AS `startDate`, `reservations`.`endDate` AS `endDate` FROM reservations ORDER BY startDate";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"reservations"}, new Callable<List<Reservation>>() {
      @Override
      @NonNull
      public List<Reservation> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = 0;
          final int _cursorIndexOfCarId = 1;
          final int _cursorIndexOfStartDate = 2;
          final int _cursorIndexOfEndDate = 3;
          final List<Reservation> _result = new ArrayList<Reservation>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Reservation _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpCarId;
            _tmpCarId = _cursor.getLong(_cursorIndexOfCarId);
            final long _tmpStartDate;
            _tmpStartDate = _cursor.getLong(_cursorIndexOfStartDate);
            final long _tmpEndDate;
            _tmpEndDate = _cursor.getLong(_cursorIndexOfEndDate);
            _item = new Reservation(_tmpId,_tmpCarId,_tmpStartDate,_tmpEndDate);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<Reservation>> getByCar(final long carId) {
    final String _sql = "SELECT * FROM reservations WHERE carId = ? ORDER BY startDate";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, carId);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"reservations"}, new Callable<List<Reservation>>() {
      @Override
      @NonNull
      public List<Reservation> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCarId = CursorUtil.getColumnIndexOrThrow(_cursor, "carId");
          final int _cursorIndexOfStartDate = CursorUtil.getColumnIndexOrThrow(_cursor, "startDate");
          final int _cursorIndexOfEndDate = CursorUtil.getColumnIndexOrThrow(_cursor, "endDate");
          final List<Reservation> _result = new ArrayList<Reservation>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Reservation _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpCarId;
            _tmpCarId = _cursor.getLong(_cursorIndexOfCarId);
            final long _tmpStartDate;
            _tmpStartDate = _cursor.getLong(_cursorIndexOfStartDate);
            final long _tmpEndDate;
            _tmpEndDate = _cursor.getLong(_cursorIndexOfEndDate);
            _item = new Reservation(_tmpId,_tmpCarId,_tmpStartDate,_tmpEndDate);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
