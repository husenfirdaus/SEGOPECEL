package com.example.segopecel2.ui

import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import com.example.segopecel2.model.Pecel
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class SecondFragmentArgs(
  public val pecel: Pecel?
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
    val result = Bundle()
    if (Parcelable::class.java.isAssignableFrom(Pecel::class.java)) {
      result.putParcelable("pecel", this.pecel as Parcelable?)
    } else if (Serializable::class.java.isAssignableFrom(Pecel::class.java)) {
      result.putSerializable("pecel", this.pecel as Serializable?)
    } else {
      throw UnsupportedOperationException(Pecel::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    if (Parcelable::class.java.isAssignableFrom(Pecel::class.java)) {
      result.set("pecel", this.pecel as Parcelable?)
    } else if (Serializable::class.java.isAssignableFrom(Pecel::class.java)) {
      result.set("pecel", this.pecel as Serializable?)
    } else {
      throw UnsupportedOperationException(Pecel::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  public companion object {
    @JvmStatic
    @Suppress("DEPRECATION")
    public fun fromBundle(bundle: Bundle): SecondFragmentArgs {
      bundle.setClassLoader(SecondFragmentArgs::class.java.classLoader)
      val __pecel : Pecel?
      if (bundle.containsKey("pecel")) {
        if (Parcelable::class.java.isAssignableFrom(Pecel::class.java) ||
            Serializable::class.java.isAssignableFrom(Pecel::class.java)) {
          __pecel = bundle.get("pecel") as Pecel?
        } else {
          throw UnsupportedOperationException(Pecel::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"pecel\" is missing and does not have an android:defaultValue")
      }
      return SecondFragmentArgs(__pecel)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): SecondFragmentArgs {
      val __pecel : Pecel?
      if (savedStateHandle.contains("pecel")) {
        if (Parcelable::class.java.isAssignableFrom(Pecel::class.java) ||
            Serializable::class.java.isAssignableFrom(Pecel::class.java)) {
          __pecel = savedStateHandle.get<Pecel?>("pecel")
        } else {
          throw UnsupportedOperationException(Pecel::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"pecel\" is missing and does not have an android:defaultValue")
      }
      return SecondFragmentArgs(__pecel)
    }
  }
}
