package th.co.creativeme.myslidepage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {


    private ViewPager mFmPager;
    private TextView mTvSkip;
    private Button mBtnFooter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTvSkip = (TextView)findViewById(R.id.tvSkip);

        mFmPager = (ViewPager) findViewById(R.id.fmPager);
        final MyPageAdapter adapter = new MyPageAdapter(getSupportFragmentManager());

        final RadioGroup mRdGroup = (RadioGroup) findViewById(R.id.rdGroup);

        mFmPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(final int position) {
                switch (position){
                    case 0:
                        mRdGroup.check(R.id.rdBtn1);
                        mTvSkip.setText("SKIP");
                        break;
                    case 1:
                        mRdGroup.check(R.id.rdBtn2);
                        mTvSkip.setText("SKIP");
                        break;
                    case 2:
                        mRdGroup.check(R.id.rdBtn3);
                        mTvSkip.setText(null);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mTvSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),DummyPage.class);
                startActivity(i);
                Toast.makeText(MainActivity.this, "go to dummy sign up page", Toast.LENGTH_SHORT).show();
            }
        });





        mFmPager.setAdapter(adapter);

    }


}