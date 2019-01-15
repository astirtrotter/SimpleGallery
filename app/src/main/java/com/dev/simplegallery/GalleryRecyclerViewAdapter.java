package com.dev.simplegallery;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dev.simplegallery.dummy.DummyContent.ProductItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link ProductItem} and makes a call to the
 * specified {@link GalleryFragment.OnGalleryFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class GalleryRecyclerViewAdapter extends RecyclerView.Adapter<GalleryRecyclerViewAdapter.ViewHolder> {

    private final List<ProductItem> mValues;
    private final GalleryFragment.OnGalleryFragmentInteractionListener mListener;

    public GalleryRecyclerViewAdapter(List<ProductItem> items, GalleryFragment.OnGalleryFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listitem_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mImageView.setImageResource(R.drawable.product_sample);
        holder.mDescriptionView.setText(holder.mItem.imgUrl);
        holder.mPriceView.setText(String.format("$%.2f", holder.mItem.price));

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onProductClicked(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView mImageView;
        public final TextView mDescriptionView;
        public final TextView mPriceView;
        public ProductItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mImageView = (ImageView) view.findViewById(R.id.image);
            mDescriptionView = (TextView) view.findViewById(R.id.description);
            mPriceView = (TextView) view.findViewById(R.id.price);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mDescriptionView.getText() + "'";
        }
    }
}
