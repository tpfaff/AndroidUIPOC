package com.blastmotion.app.baseballmock;

/**
 * Created by tylerpfaff on 2/19/15.
 */

import android.app.ActivityOptions;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.TransitionInflater;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.getbase.floatingactionbutton.FloatingActionButton;

public class HistoryFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;

    private LinearLayoutManager mLayoutManager;
    public boolean useFat=true;
    public HistoryFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        GridView gridView;
        if(useFat) {
         //   getActivity().setContentView(R.layout.grid_layout_fat);
            gridView = (GridView) getActivity().findViewById(R.id.gridview_fat);
        }else{
       //     getActivity().setContentView(R.layout.grid_layout);
            gridView = (GridView) getActivity().findViewById(R.id.gridview);

        }
        gridView.setAdapter(new ImageAdapter(getActivity()));
        getActivity().getActionBar().setTitle("History");
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                TransitionInflater transitionInflater = TransitionInflater.from(getActivity());
                ImageView commonImageView = (ImageView) v.findViewById(R.id.sport_image);
                TextView  commonTextView=(TextView)v.findViewById(R.id.textView_main_metric);
                FloatingActionButton fab=(FloatingActionButton)v.findViewById(R.id.floating_button);
                // Now we can start the Activity, providing the activity options as a bundle
                Intent intent = new Intent(getActivity(), ActionDetailActivity.class);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(getActivity(),
                        new Pair<View,String>(commonImageView,"imageTransition"),
                        new Pair<View,String>(commonTextView,"textTransition"));
                        new Pair<View,String>(fab,"fabTransition");
                // ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(getActivity(),new Pair<View,String>(commonImageView,"R.id.sport_image"),"sharedElementEnterTransition","sharedElementExitTransition"));
                // ActivityOptions.makescenetran

//
                startActivity(intent, options.toBundle());
            }
        });
    }
//
//    @Override
//    public void onStart() {
//        super.onStart();
//        GridView gridView;
//        if(useFat) {
//            getActivity().setContentView(R.layout.grid_layout_fat);
//            gridView = (GridView) getActivity().findViewById(R.id.gridview_fat);
//        }else{
//            getActivity().setContentView(R.layout.grid_layout);
//            gridView = (GridView) getActivity().findViewById(R.id.gridview);
//
//        }
//        gridView.setAdapter(new ImageAdapter(getActivity()));
//        getActivity().getActionBar().setTitle("History");
//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
//
//                TransitionInflater transitionInflater = TransitionInflater.from(getActivity());
//                ImageView commonImageView = (ImageView) v.findViewById(R.id.sport_image);
//                TextView  commonTextView=(TextView)v.findViewById(R.id.textView_main_metric);
//                // Now we can start the Activity, providing the activity options as a bundle
//                Intent intent = new Intent(getActivity(), ActionDetailActivity.class);
//                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(getActivity(),
//                        new Pair<View,String>(commonImageView,"imageTransition"),
//                        new Pair<View,String>(commonTextView,"textTransition"));
//              // ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(getActivity(),new Pair<View,String>(commonImageView,"R.id.sport_image"),"sharedElementEnterTransition","sharedElementExitTransition"));
//               // ActivityOptions.makescenetran
//
////
//                startActivity(intent, options.toBundle());
//            }
//        });
//       // this.getView().setBackground(new ColorDrawable(0xeeeeee));
//    }


//        @Override
//         public void onFinishInflate(){
//
//        }
//        mRecyclerView=(RecyclerView)getActivity().findViewById(R.id.history_recycler);
//        mRecyclerView.setHasFixedSize(true);
//
//        mLayoutManager=new LinearLayoutManager(getActivity());
//        if(getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
//            mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        }else{
//            mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//
//        }
//
//        mRecyclerView.setLayoutManager(mLayoutManager);
//        //configure the above layout to go horizontally scrolling
//
//        mAdapter=new MyAdapter(this);
//        mRecyclerView.setAdapter(mAdapter);



    public class ImageAdapter extends BaseAdapter {
        private Context mContext;

        public ImageAdapter(Context c) {
            mContext = c;
        }

        public int getCount() {
            return mThumbIds.length;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        // create a new ImageView for each item referenced by the Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
//            ImageView imageView;
//            if (convertView == null) {  // if it's not recycled, initialize some attributes
//                imageView = new ImageView(mContext);
//                imageView.setLayoutParams(new GridView.LayoutParams(250, 270));
//                imageView.setScaleType(ImageView.ScaleType.CENTER);
//                imageView.setPadding(8, 4, 4, 8);
//                //imageView.setBackgroundColor(getResources().getColor(R.color.material_deep_teal_500));
//            } else {
//                imageView = (ImageView) convertView;
//            }
//            imageView.setImageResource(mThumbIds[position]);
//            return imageView;

            CardView cardView;
            RelativeLayout layout;

            if(convertView==null){

                LayoutInflater inflater=(getActivity().getLayoutInflater());
               // Activity activity=getActivity();
               // View v = convertView.findViewById(R.id.card_view);
                if(useFat) {
                    layout = (RelativeLayout) inflater.inflate(R.layout.grid_item_wide, parent, false);
                }else{
                    layout = (RelativeLayout) inflater.inflate(R.layout.grid_item, parent, false);

                }
              //  layout.setLayoutParams(new GridView.LayoutParams(250,250));
               // cardView.setPadding(8,8,8,8);
            }else{
                layout=(RelativeLayout)convertView;
            }
           return layout;
        }

        // references to our images
        private Integer[] mThumbIds = {
                R.drawable.baseball_guy,R.drawable.baseball_guy
                ,R.drawable.baseball_guy,R.drawable.baseball_guy
                ,R.drawable.baseball_guy,R.drawable.baseball_guy
                ,R.drawable.baseball_guy,R.drawable.baseball_guy
                ,R.drawable.baseball_guy,R.drawable.baseball_guy
                ,R.drawable.baseball_guy,R.drawable.baseball_guy
                ,R.drawable.baseball_guy,R.drawable.baseball_guy
                ,R.drawable.baseball_guy,R.drawable.baseball_guy
                ,R.drawable.baseball_guy,R.drawable.baseball_guy
                ,R.drawable.baseball_guy,R.drawable.baseball_guy
                ,R.drawable.baseball_guy,R.drawable.baseball_guy
        };
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(useFat) {
            return inflater.inflate(R.layout.grid_layout_fat, container, false);
        }else{
            return inflater.inflate(R.layout.grid_layout,container,false);
        }
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    public void showVideo(View view){
        Log.d("YO","YOMA");
        Intent intent=new Intent(getActivity(),VideoActivity.class);
       getActivity().startActivity(intent);
    }

    public class MyAdapter extends RecyclerView.Adapter<CardViewHolder> {
        private HistoryFragment fragment;

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
        public MyAdapter(HistoryFragment fragment) {
             this.fragment=fragment;
        }

    //    Create new views (invoked by the layout manager)
        @Override
        public CardViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {

            View itemView=LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout,parent,false);
            return new CardViewHolder(itemView,fragment);
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(CardViewHolder holder, int position) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element
            //holder.mTextView.setText(mDataset[position]);
            Resources resources=getActivity().getResources();
            Drawable image=resources.getDrawable(R.drawable.baseball_guy);
                holder.backgroundImage.setImageDrawable(image);
        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
           return 250;
        }
    }


    public static class CardViewHolder extends RecyclerView.ViewHolder {
        protected CardView cardView;
        protected ImageView backgroundImage;
        public CardViewHolder(View v,HistoryFragment fragment) {
            super(v);
           cardView=(CardView)v.findViewById(R.id.card_view);
            final  HistoryFragment frag=fragment;

            cardView.setOnClickListener(new View.OnClickListener(){
                @Override public void onClick(View v){
                    frag.showVideo(v);
                }
            });
            backgroundImage=(ImageView)v.findViewById(R.id.card_image);
        }
    }


}
