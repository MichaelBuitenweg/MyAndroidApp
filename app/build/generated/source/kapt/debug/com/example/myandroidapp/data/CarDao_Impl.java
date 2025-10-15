package com.example.myandroidapp.data;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.myandroidapp.model.Car;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
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
public final class CarDao_Impl implements CarDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Car> __insertionAdapterOfCar;

  private final EntityDeletionOrUpdateAdapter<Car> __deletionAdapterOfCar;

  public CarDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCar = new EntityInsertionAdapter<Car>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `cars` (`id`,`name`,`model`,`licenseNumber`,`color`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Car entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        if (entity.getModel() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getModel());
        }
        if (entity.getLicenseNumber() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getLicenseNumber());
        }
        if (entity.getColor() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getColor());
        }
      }
    };
    this.__deletionAdapterOfCar = new EntityDeletionOrUpdateAdapter<Car>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `cars` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Car entity) {
        statement.bindLong(1, entity.getId());
      }
    };
  }

  @Override
  public Object insert(final Car car, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfCar.insertAndReturnId(car);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object delete(final Car car, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfCar.handle(car);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Car>> getAll() {
    final String _sql = "SELECT `cars`.`id` AS `id`, `cars`.`name` AS `name`, `cars`.`model` AS `model`, `cars`.`licenseNumber` AS `licenseNumber`, `cars`.`color` AS `color` FROM cars ORDER BY name";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"cars"}, new Callable<List<Car>>() {
      @Override
      @NonNull
      public List<Car> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = 0;
          final int _cursorIndexOfName = 1;
          final int _cursorIndexOfModel = 2;
          final int _cursorIndexOfLicenseNumber = 3;
          final int _cursorIndexOfColor = 4;
          final List<Car> _result = new ArrayList<Car>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Car _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpModel;
            if (_cursor.isNull(_cursorIndexOfModel)) {
              _tmpModel = null;
            } else {
              _tmpModel = _cursor.getString(_cursorIndexOfModel);
            }
            final String _tmpLicenseNumber;
            if (_cursor.isNull(_cursorIndexOfLicenseNumber)) {
              _tmpLicenseNumber = null;
            } else {
              _tmpLicenseNumber = _cursor.getString(_cursorIndexOfLicenseNumber);
            }
            final String _tmpColor;
            if (_cursor.isNull(_cursorIndexOfColor)) {
              _tmpColor = null;
            } else {
              _tmpColor = _cursor.getString(_cursorIndexOfColor);
            }
            _item = new Car(_tmpId,_tmpName,_tmpModel,_tmpLicenseNumber,_tmpColor);
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
  public Object countByColor(final String color, final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM cars WHERE color = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (color == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, color);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
