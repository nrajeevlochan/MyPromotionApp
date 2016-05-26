package com.mypromotionapp.uidisplay;

import android.support.v7.widget.RecyclerView;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;

import com.mypromotionapp.R;

/**
 * Created by ${} on 5/24/16.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    RecyclerView recyclerView;
    MainActivity mainActivity;

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mainActivity = getActivity();
        recyclerView = (RecyclerView) mainActivity.findViewById(R.id.recycler_view);
    }

    @SmallTest
    public void testViewsCreated() {
        assertNotNull(getActivity());
        assertNotNull(recyclerView);
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }
}