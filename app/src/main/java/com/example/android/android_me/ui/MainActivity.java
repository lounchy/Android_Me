package com.example.android.android_me.ui;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener {
    private int headIndex, bodyIndex, legIndex;
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (findViewById(R.id.android_me_linear_layout) != null){
            mTwoPane = true;
            Button nextButton = (Button) findViewById(R.id.next_button);
            nextButton.setVisibility(View.GONE);

            GridView gridView = (GridView) findViewById(R.id.body_pasrts_grid_view);
            gridView.setNumColumns(2);
            if (savedInstanceState == null){

//                Bundle b = getIntent().getExtras();
//                int headIndex = b.getInt("headIndex");
//                int bodyIndex = b.getInt("bodyIndex");
//                int legIndex = b.getInt("legIndex");


                BodyPartFragment headFragment = new BodyPartFragment();
                headFragment.setImageIds(AndroidImageAssets.getHeads());
//                headFragment.setListIndex(headIndex);
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.head_container, headFragment)
                        .commit();

                BodyPartFragment bodyFragment = new BodyPartFragment();
                bodyFragment.setImageIds(AndroidImageAssets.getBodies());
//                bodyFragment.setListIndex(bodyIndex);
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.body_container, bodyFragment)
                        .commit();

                BodyPartFragment legFragment = new BodyPartFragment();
                legFragment.setImageIds(AndroidImageAssets.getLegs());
//                legFragment.setListIndex(legIndex);
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.leg_container, legFragment)
                        .commit();
            }
        }else {
            mTwoPane = false;
        }


    }

    @Override
    public void onImageSelected(int position) {

        int bodyPartNumber = position/12;

        int listIndex = position - 12*bodyPartNumber;
        BodyPartFragment newFragment = new BodyPartFragment();
        FragmentManager fm = getSupportFragmentManager();
        if (mTwoPane){
            switch (bodyPartNumber) {
                case 0:
                    newFragment.setImageIds(AndroidImageAssets.getHeads());
                    newFragment.setListIndex(listIndex);
                    fm.beginTransaction()
                            .replace(R.id.head_container, newFragment)
                            .commit();
                    break;
                case 1:
                    newFragment.setImageIds(AndroidImageAssets.getBodies());
                    newFragment.setListIndex(listIndex);
                    fm.beginTransaction()
                            .replace(R.id.body_container, newFragment)
                            .commit();
                    break;
                case 2:
                    newFragment.setImageIds(AndroidImageAssets.getLegs());
                    newFragment.setListIndex(listIndex);
                    fm.beginTransaction()
                            .replace(R.id.leg_container, newFragment)
                            .commit();
                    break;
                 default:
                        break;

            }

        }else {
            switch (bodyPartNumber) {
                case 0:
                    headIndex = listIndex;
                    break;
                case 1:
                    bodyIndex = listIndex;
                    break;
                case 2:
                    legIndex = listIndex;
                    break;
                default:
                    break;
            }
            Bundle b = new Bundle();
            b.putInt("headIndex", headIndex);
            b.putInt("bodyIndex", bodyIndex);
            b.putInt("legIndex", legIndex);

            final Intent intent = new Intent(this, AndroidMeActivity.class);
            intent.putExtras(b);

            Button next = (Button)findViewById(R.id.next_button);
            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(intent);
                }
            });
        }


    }
}
