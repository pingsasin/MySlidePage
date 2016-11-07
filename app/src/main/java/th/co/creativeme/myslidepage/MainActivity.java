package th.co.creativeme.myslidepage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {


    private ViewPager mFmPager;
    private TextView mTvSkip;
    private Button mBtnNext;

    private String TAG = "Main";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTvSkip = (TextView) findViewById(R.id.tvSkip);
        mBtnNext = (Button) findViewById(R.id.btnFooter);
        mFmPager = (ViewPager) findViewById(R.id.fmPager);

        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "Click");

                mFmPager.setCurrentItem(mFmPager.getCurrentItem() + 1, true);




            }

        });
        final MyPageAdapter adapter = new MyPageAdapter(getSupportFragmentManager());
        Log.i(TAG, "onCreate");
        final RadioGroup mRdGroup = (RadioGroup) findViewById(R.id.rdGroup);

        mFmPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(final int position) {
                switch (position) {
                    case 0:
                        mRdGroup.check(R.id.rdBtn1);
                        mTvSkip.setText("SKIP");
                        mBtnNext.setText("NEXT");
                        Log.i(TAG, "Case 0");
                        break;
                    case 1:
                        mRdGroup.check(R.id.rdBtn2);
                        mTvSkip.setText("SKIP");
                        mBtnNext.setText("NEXT");
                        Log.i(TAG, "Case 1");
                        break;
                    case 2:
                        mRdGroup.check(R.id.rdBtn3);
                        mTvSkip.setText(null);
                        mBtnNext.setText("LET'S SIGN UP");
                        Log.i(TAG, "Case 2");

                        mBtnNext.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Log.i(TAG, "Dummy Page");
                                Intent i = new Intent(getApplicationContext(), DummyPage.class);
                                startActivity(i);
                                Toast.makeText(MainActivity.this, "go to dummy sign up page", Toast.LENGTH_SHORT).show();

                            }
                        });
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        mTvSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "Dummy Page");
                Intent i = new Intent(getApplicationContext(), DummyPage.class);
                startActivity(i);
                Toast.makeText(MainActivity.this, "go to dummy sign up page", Toast.LENGTH_SHORT).show();
            }
        });

        mFmPager.setAdapter(adapter);

    }

    // TODO: 11/7/2016 AD test create new branch


    // TODO: 11/7/2016 AD test commit sasin1 branch 


}