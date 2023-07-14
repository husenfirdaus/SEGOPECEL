package com.example.segopecel2.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.segopecel2.model.Pecel;
import java.lang.Class;
import java.lang.Double;
import java.lang.Exception;
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
public final class Peceldao_Impl implements Peceldao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Pecel> __insertionAdapterOfPecel;

  private final EntityDeletionOrUpdateAdapter<Pecel> __deletionAdapterOfPecel;

  private final EntityDeletionOrUpdateAdapter<Pecel> __updateAdapterOfPecel;

  public Peceldao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPecel = new EntityInsertionAdapter<Pecel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `pecel_pecel` (`id`,`name`,`address`,`sidedish`,`drink`,`price`,`latitude`,`longitude`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Pecel value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getAddress() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAddress());
        }
        if (value.getSidedish() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getSidedish());
        }
        if (value.getDrink() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getDrink());
        }
        if (value.getPrice() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getPrice());
        }
        if (value.getLatitude() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindDouble(7, value.getLatitude());
        }
        if (value.getLongitude() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindDouble(8, value.getLongitude());
        }
      }
    };
    this.__deletionAdapterOfPecel = new EntityDeletionOrUpdateAdapter<Pecel>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `pecel_pecel` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Pecel value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfPecel = new EntityDeletionOrUpdateAdapter<Pecel>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `pecel_pecel` SET `id` = ?,`name` = ?,`address` = ?,`sidedish` = ?,`drink` = ?,`price` = ?,`latitude` = ?,`longitude` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Pecel value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getAddress() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAddress());
        }
        if (value.getSidedish() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getSidedish());
        }
        if (value.getDrink() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getDrink());
        }
        if (value.getPrice() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getPrice());
        }
        if (value.getLatitude() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindDouble(7, value.getLatitude());
        }
        if (value.getLongitude() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindDouble(8, value.getLongitude());
        }
        stmt.bindLong(9, value.getId());
      }
    };
  }

  @Override
  public Object InsertPecel(final Pecel pecel, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfPecel.insert(pecel);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object DeletePecel(final Pecel pecel, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfPecel.handle(pecel);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object UpdatePecel(final Pecel pecel, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfPecel.handle(pecel);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Pecel>> getALLvPecels() {
    final String _sql = "SELECT * FROM `pecel_pecel` ORDER BY name ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"pecel_pecel"}, new Callable<List<Pecel>>() {
      @Override
      public List<Pecel> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
          final int _cursorIndexOfSidedish = CursorUtil.getColumnIndexOrThrow(_cursor, "sidedish");
          final int _cursorIndexOfDrink = CursorUtil.getColumnIndexOrThrow(_cursor, "drink");
          final int _cursorIndexOfPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "price");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
          final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
          final List<Pecel> _result = new ArrayList<Pecel>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Pecel _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpAddress;
            if (_cursor.isNull(_cursorIndexOfAddress)) {
              _tmpAddress = null;
            } else {
              _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
            }
            final String _tmpSidedish;
            if (_cursor.isNull(_cursorIndexOfSidedish)) {
              _tmpSidedish = null;
            } else {
              _tmpSidedish = _cursor.getString(_cursorIndexOfSidedish);
            }
            final String _tmpDrink;
            if (_cursor.isNull(_cursorIndexOfDrink)) {
              _tmpDrink = null;
            } else {
              _tmpDrink = _cursor.getString(_cursorIndexOfDrink);
            }
            final String _tmpPrice;
            if (_cursor.isNull(_cursorIndexOfPrice)) {
              _tmpPrice = null;
            } else {
              _tmpPrice = _cursor.getString(_cursorIndexOfPrice);
            }
            final Double _tmpLatitude;
            if (_cursor.isNull(_cursorIndexOfLatitude)) {
              _tmpLatitude = null;
            } else {
              _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            }
            final Double _tmpLongitude;
            if (_cursor.isNull(_cursorIndexOfLongitude)) {
              _tmpLongitude = null;
            } else {
              _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
            }
            _item = new Pecel(_tmpId,_tmpName,_tmpAddress,_tmpSidedish,_tmpDrink,_tmpPrice,_tmpLatitude,_tmpLongitude);
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
