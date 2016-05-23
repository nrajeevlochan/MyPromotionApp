package com.mypromotionapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ${} on 5/20/16.
 */
public class Promotion implements Parcelable {
    private String mTitle;
    private String mImageUrl;
    private String mDescription;
    private String mFooter;
    private String mButtonTitle;
    private String mButtonWebUrl;

    public Promotion() {
    }

    public Promotion(String title, String imageUrl, String footer, String description, String buttonTitle, String buttonWebUrl) {
        this.mTitle = title;
        this.mImageUrl = imageUrl;
        this.mFooter = footer;
        this.mDescription = description;
        this.mButtonTitle = buttonTitle;
        this.mButtonWebUrl = buttonWebUrl;
    }

    private Promotion(Parcel in) {
        mTitle = in.readString();
        mImageUrl = in.readString();
        mFooter = in.readString();
        mDescription = in.readString();
        mButtonTitle = in.readString();
        mButtonWebUrl = in.readString();
    }

    public String getFooter() {
        return mFooter;
    }

    public void setFooter(String mFooter) {
        this.mFooter = mFooter;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getButtonTitle() {
        return mButtonTitle;
    }

    public void setButtonTitle(String mButtonTitle) {
        this.mButtonTitle = mButtonTitle;
    }

    public String getButtonWebUrl() {
        return mButtonWebUrl;
    }

    public void setButtonWebUrl(String mButtonWebUrl) {
        this.mButtonWebUrl = mButtonWebUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mTitle);
        dest.writeString(mImageUrl);
        dest.writeString(mFooter);
        dest.writeString(mDescription);
        dest.writeString(mButtonTitle);
        dest.writeString(mButtonWebUrl);
    }

    public static final Parcelable.Creator<Promotion> CREATOR
            = new Parcelable.Creator<Promotion>() {

        @Override
        public Promotion createFromParcel(Parcel in) {
            return new Promotion(in);
        }

        @Override
        public Promotion[] newArray(int size) {
            return new Promotion[size];
        }
    };
}
