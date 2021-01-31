package com.example.notes;

import android.icu.util.Calendar;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Note implements Parcelable {
    private final int index;
    private String title;
    private String description;
    private Date creationDate;

    public Note(int index, String title, String description) {
        this.index = index;
        this.title = title;
        this.description = description;
        this.creationDate = Calendar.getInstance().getTime();
    }

    protected Note(Parcel in) {
        index = in.readInt();
        title = in.readString();
        description = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(index);
        dest.writeString(title);
        dest.writeString(description);
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    public int getIndex() {
        return index;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
