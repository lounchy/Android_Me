package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.List;

public class BodyPartFragment extends Fragment {
    private static String TAG = "BodyPartFragment";
    private List<Integer> mImageIds;
    private int mListIndex;
    public BodyPartFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);
        ImageView bodyPartIv = (ImageView)rootView.findViewById(R.id.body_part_iv);
        bodyPartIv.setImageResource(AndroidImageAssets.getHeads().get(0));
        if (mImageIds != null){
            bodyPartIv.setImageResource(mImageIds.get(mListIndex));
        }else {
            Log.v(TAG, "This Fragment has a null list of image id's");
        }
        return rootView;
    }

    public void setImageIds(List<Integer> mImageIds) {
        this.mImageIds = mImageIds;
    }

    public void setListIndex(int mListIndex) {
        this.mListIndex = mListIndex;
    }
}
