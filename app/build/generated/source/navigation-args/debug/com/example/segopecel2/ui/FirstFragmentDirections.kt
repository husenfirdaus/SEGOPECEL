package com.example.segopecel2.ui

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavDirections
import com.example.segopecel2.R
import com.example.segopecel2.model.Pecel
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

public class FirstFragmentDirections private constructor() {
  private data class ActionFirstFragmentToSecondFragment(
    public val pecel: Pecel?
  ) : NavDirections {
    public override val actionId: Int = R.id.action_FirstFragment_to_SecondFragment

    public override val arguments: Bundle
      @Suppress("CAST_NEVER_SUCCEEDS")
      get() {
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
  }

  public companion object {
    public fun actionFirstFragmentToSecondFragment(pecel: Pecel?): NavDirections =
        ActionFirstFragmentToSecondFragment(pecel)
  }
}
