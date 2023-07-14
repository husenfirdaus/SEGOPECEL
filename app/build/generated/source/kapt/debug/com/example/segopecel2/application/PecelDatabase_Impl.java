package com.example.segopecel2.application;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.example.segopecel2.dao.Peceldao;
import com.example.segopecel2.dao.Peceldao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class PecelDatabase_Impl extends PecelDatabase {
  private volatile Peceldao _peceldao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(2) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `pecel_pecel` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL, `address` TEXT NOT NULL, `sidedish` TEXT NOT NULL, `drink` TEXT NOT NULL, `price` TEXT NOT NULL, `latitude` REAL, `longitude` REAL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'ce28bd46e05241adc15d84d5ae69400b')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `pecel_pecel`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      public void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsPecelPecel = new HashMap<String, TableInfo.Column>(8);
        _columnsPecelPecel.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPecelPecel.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPecelPecel.put("address", new TableInfo.Column("address", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPecelPecel.put("sidedish", new TableInfo.Column("sidedish", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPecelPecel.put("drink", new TableInfo.Column("drink", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPecelPecel.put("price", new TableInfo.Column("price", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPecelPecel.put("latitude", new TableInfo.Column("latitude", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPecelPecel.put("longitude", new TableInfo.Column("longitude", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPecelPecel = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPecelPecel = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPecelPecel = new TableInfo("pecel_pecel", _columnsPecelPecel, _foreignKeysPecelPecel, _indicesPecelPecel);
        final TableInfo _existingPecelPecel = TableInfo.read(_db, "pecel_pecel");
        if (! _infoPecelPecel.equals(_existingPecelPecel)) {
          return new RoomOpenHelper.ValidationResult(false, "pecel_pecel(com.example.segopecel2.model.Pecel).\n"
                  + " Expected:\n" + _infoPecelPecel + "\n"
                  + " Found:\n" + _existingPecelPecel);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "ce28bd46e05241adc15d84d5ae69400b", "77990a7f2eb31252c1bed2a56bcd2849");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "pecel_pecel");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `pecel_pecel`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(Peceldao.class, Peceldao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public Peceldao Peceldao() {
    if (_peceldao != null) {
      return _peceldao;
    } else {
      synchronized(this) {
        if(_peceldao == null) {
          _peceldao = new Peceldao_Impl(this);
        }
        return _peceldao;
      }
    }
  }
}
