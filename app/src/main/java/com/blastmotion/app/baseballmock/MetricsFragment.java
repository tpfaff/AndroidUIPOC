package com.blastmotion.app.baseballmock;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by tylerpfaff on 2/19/15.
 */
public class MetricsFragment extends Fragment {


    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private LinearLayoutManager mLayoutManager;

    public MetricsFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onStart() {
        super.onStart();

        getActivity().getActionBar().setTitle("Metrics");

        mRecyclerView = (RecyclerView) getActivity().findViewById(R.id.metrics_recycler);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getActivity());
//        if(getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
//            mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        }else{
        mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

//        }

        mRecyclerView.setLayoutManager(mLayoutManager);
        //configure the above layout to go horizontally scrolling

        mAdapter = new MyAdapter(null);
        mRecyclerView.setAdapter(mAdapter);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.metrics, container, false);
    }


    public class MyAdapter extends RecyclerView.Adapter<CardViewHolder> {
        private String[] mDataset;

        // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder
        public class ViewHolder extends RecyclerView.ViewHolder {
            // each data item is just a string in this case
            public TextView mTextView;

            public ViewHolder(TextView v) {
                super(v);
                mTextView = v;
            }
        }

        // Provide a suitable constructor (depends on the kind of dataset)
        public MyAdapter(String[] myDataset) {
            mDataset = myDataset;
        }

        //    Create new views (invoked by the layout manager)
        @Override
        public CardViewHolder onCreateViewHolder(ViewGroup parent,
                                                 int viewType) {

            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.metric_card_layout, parent, false);
            return new CardViewHolder(itemView);
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(CardViewHolder holder, int position) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element
            //holder.mTextView.setText(mDataset[position]);
//            Resources resources=getActivity().getResources();
//            Drawable image=resources.getDrawable(R.drawable.baseball_guy);
//            holder.backgroundImage.setImageDrawable(image);
        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return 4;
        }
    }


    public static class CardViewHolder extends RecyclerView.ViewHolder {
        protected CardView cardView;
        // protected ImageView backgroundImage;

        public CardViewHolder(View v) {
            super(v);
            cardView = (CardView) v.findViewById(R.id.card_view_metrics);
            // backgroundImage=(ImageView)v.findViewById(R.id.card_image);
        }
    }
}
