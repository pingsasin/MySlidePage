package th.co.creativeme.myslidepage;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by pingsasin on 7/25/2016 AD.
 */
public class MyPageAdapter extends FragmentPagerAdapter{

    public MyPageAdapter(FragmentManager fm){
        super(fm);
    }

    public int getCount(){
        return 3;
    }

    public Fragment getItem(int position){
        if (position == 0)
            return new OneFragment();
        else if (position == 1)
            return new TwoFragment();
        else if (position == 2)
            return new ThreeFragment();
        return null;
    }
}
