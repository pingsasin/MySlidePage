package th.co.creativeme.myslidepage;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.widget.RadioGroup;

public class MainActivity extends FragmentActivity {


    private ViewPager mFmPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFmPager = (ViewPager) findViewById(R.id.fmPager);
        MyPageAdapter adapter = new MyPageAdapter(getSupportFragmentManager());

        final RadioGroup mRdGroup = (RadioGroup) findViewById(R.id.rdGroup);

        mFmPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        mRdGroup.check(R.id.rdBtn1);
                        break;
                    case 1:
                        mRdGroup.check(R.id.rdBtn2);
                        break;
                    case 2:
                        mRdGroup.check(R.id.rdBtn3);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        mFmPager.setAdapter(adapter);

    }


}