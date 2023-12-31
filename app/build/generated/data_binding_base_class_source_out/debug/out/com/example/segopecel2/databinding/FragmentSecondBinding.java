// Generated by view binder compiler. Do not edit!
package com.example.segopecel2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.segopecel2.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentSecondBinding implements ViewBinding {
  @NonNull
  private final NestedScrollView rootView;

  @NonNull
  public final EditText NameeditTextText;

  @NonNull
  public final EditText SidedishEditTextText3;

  @NonNull
  public final EditText addresseditTextText2;

  @NonNull
  public final Button cameraButton;

  @NonNull
  public final Button deletebutton;

  @NonNull
  public final NestedScrollView drinkText;

  @NonNull
  public final EditText drinkeditText;

  @NonNull
  public final ImageView photoImageView;

  @NonNull
  public final EditText priceTextText2;

  @NonNull
  public final Button savebutton;

  @NonNull
  public final TextView textView;

  @NonNull
  public final TextView textView2;

  @NonNull
  public final TextView textView3;

  @NonNull
  public final TextView textView6;

  @NonNull
  public final TextView textView7;

  private FragmentSecondBinding(@NonNull NestedScrollView rootView,
      @NonNull EditText NameeditTextText, @NonNull EditText SidedishEditTextText3,
      @NonNull EditText addresseditTextText2, @NonNull Button cameraButton,
      @NonNull Button deletebutton, @NonNull NestedScrollView drinkText,
      @NonNull EditText drinkeditText, @NonNull ImageView photoImageView,
      @NonNull EditText priceTextText2, @NonNull Button savebutton, @NonNull TextView textView,
      @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView6,
      @NonNull TextView textView7) {
    this.rootView = rootView;
    this.NameeditTextText = NameeditTextText;
    this.SidedishEditTextText3 = SidedishEditTextText3;
    this.addresseditTextText2 = addresseditTextText2;
    this.cameraButton = cameraButton;
    this.deletebutton = deletebutton;
    this.drinkText = drinkText;
    this.drinkeditText = drinkeditText;
    this.photoImageView = photoImageView;
    this.priceTextText2 = priceTextText2;
    this.savebutton = savebutton;
    this.textView = textView;
    this.textView2 = textView2;
    this.textView3 = textView3;
    this.textView6 = textView6;
    this.textView7 = textView7;
  }

  @Override
  @NonNull
  public NestedScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentSecondBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentSecondBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_second, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentSecondBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.NameeditTextText;
      EditText NameeditTextText = ViewBindings.findChildViewById(rootView, id);
      if (NameeditTextText == null) {
        break missingId;
      }

      id = R.id.SidedishEditTextText3;
      EditText SidedishEditTextText3 = ViewBindings.findChildViewById(rootView, id);
      if (SidedishEditTextText3 == null) {
        break missingId;
      }

      id = R.id.addresseditTextText2;
      EditText addresseditTextText2 = ViewBindings.findChildViewById(rootView, id);
      if (addresseditTextText2 == null) {
        break missingId;
      }

      id = R.id.cameraButton;
      Button cameraButton = ViewBindings.findChildViewById(rootView, id);
      if (cameraButton == null) {
        break missingId;
      }

      id = R.id.deletebutton;
      Button deletebutton = ViewBindings.findChildViewById(rootView, id);
      if (deletebutton == null) {
        break missingId;
      }

      NestedScrollView drinkText = (NestedScrollView) rootView;

      id = R.id.drinkeditText;
      EditText drinkeditText = ViewBindings.findChildViewById(rootView, id);
      if (drinkeditText == null) {
        break missingId;
      }

      id = R.id.photoImageView;
      ImageView photoImageView = ViewBindings.findChildViewById(rootView, id);
      if (photoImageView == null) {
        break missingId;
      }

      id = R.id.priceTextText2;
      EditText priceTextText2 = ViewBindings.findChildViewById(rootView, id);
      if (priceTextText2 == null) {
        break missingId;
      }

      id = R.id.savebutton;
      Button savebutton = ViewBindings.findChildViewById(rootView, id);
      if (savebutton == null) {
        break missingId;
      }

      id = R.id.textView;
      TextView textView = ViewBindings.findChildViewById(rootView, id);
      if (textView == null) {
        break missingId;
      }

      id = R.id.textView2;
      TextView textView2 = ViewBindings.findChildViewById(rootView, id);
      if (textView2 == null) {
        break missingId;
      }

      id = R.id.textView3;
      TextView textView3 = ViewBindings.findChildViewById(rootView, id);
      if (textView3 == null) {
        break missingId;
      }

      id = R.id.textView6;
      TextView textView6 = ViewBindings.findChildViewById(rootView, id);
      if (textView6 == null) {
        break missingId;
      }

      id = R.id.textView7;
      TextView textView7 = ViewBindings.findChildViewById(rootView, id);
      if (textView7 == null) {
        break missingId;
      }

      return new FragmentSecondBinding((NestedScrollView) rootView, NameeditTextText,
          SidedishEditTextText3, addresseditTextText2, cameraButton, deletebutton, drinkText,
          drinkeditText, photoImageView, priceTextText2, savebutton, textView, textView2, textView3,
          textView6, textView7);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
