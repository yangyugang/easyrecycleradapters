package com.carlosdelachica.sample.adapter.view_holder_factories;

import android.content.Context;
import android.view.ViewGroup;

import com.carlosdelachica.easyrecycleradapters.adapter.BaseEasyViewHolderFactory;
import com.carlosdelachica.easyrecycleradapters.adapter.EasyViewHolder;
import com.carlosdelachica.sample.adapter.view_holders.ImageEasyViewHolder;
import com.carlosdelachica.sample.adapter.view_holders.TextDataEasyViewHolder;
import com.carlosdelachica.sample.data.ImageData;
import com.carlosdelachica.sample.data.TextData;
import com.squareup.picasso.Picasso;

public class CustomViewHolderFactory extends BaseEasyViewHolderFactory {

  private Picasso picasso;

  public CustomViewHolderFactory(Context context) {
    super(context);
    this.picasso = Picasso.with(context);
  }

  @Override public EasyViewHolder create(int viewType, ViewGroup parent) {
    Class valueClass = getValueClassTypes().get(viewType);
    if (valueClass == ImageData.class) {
      return new ImageEasyViewHolder(context, parent, picasso);
    } else if (valueClass == TextData.class) {
      return new TextDataEasyViewHolder(context, parent);
    }
    return null;
  }
}
