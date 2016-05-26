package com.mypromotionapp.uidisplay;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.Button;
import android.widget.TextView;

import com.mypromotionapp.R;

/**
 * Created by ${} on 5/26/16.
 */
public class SubActivityTest extends ActivityInstrumentationTestCase2<SubActivity> {

    TextView titleView;
    TextView descriptionView;
    TextView footerView;
    Button button;
    SubActivity subActivity;

    private static final String EMPTY_TEXT = " ";
    private static final String TEST_TEXT = "Test text";

    public SubActivityTest() {
        super(SubActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        subActivity = getActivity();
        titleView = (TextView) subActivity.findViewById(R.id.subTitleView);
        descriptionView = (TextView) subActivity.findViewById(R.id.subDescriptionView);
        footerView = (TextView) subActivity.findViewById(R.id.subFooterView);
        button = (Button) subActivity.findViewById(R.id.subButton);
    }

    @SmallTest
    public void testViewsCreated() {
        assertNotNull(getActivity());
        assertNotNull(titleView);
        assertNotNull(descriptionView);
        assertNotNull(footerView);
        assertNotNull(button);
    }

    public void testSetTextView() {
        titleView.setText(EMPTY_TEXT);
        assertTrue("set text to empty: ", titleView.getText().toString().equals(EMPTY_TEXT));
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

}