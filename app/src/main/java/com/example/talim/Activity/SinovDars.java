package com.example.talim.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.talim.Adapter.VideoAdapter;
import com.example.talim.Model.FanlarEntity;
import com.example.talim.R;
import com.example.talim.Utils.YouTubeVideos;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class SinovDars extends AppCompatActivity {
    RecyclerView recyclerView;
    Vector<YouTubeVideos> youtubeVideos = new Vector<YouTubeVideos>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getActionBar().hide();
        setContentView(R.layout.activity_sinov_dars);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String fan = getIntent().getStringExtra("fan");
        switch (fan) {
            case "Ona tili":
                youtubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/4HH9No1z6_I\" frameborder=\"0\" allowfullscreen></iframe>"));
                youtubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/cxewgQySeIY\" frameborder=\"0\" allowfullscreen></iframe>"));
                youtubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/TamHopcLl2E\" frameborder=\"0\" allowfullscreen></iframe>"));
                youtubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/TZUJ4PmAuuI\" frameborder=\"0\" allowfullscreen></iframe>"));
                youtubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/tucsfKJX4HY\" frameborder=\"0\" allowfullscreen></iframe>"));
                break;
            case "Matematika":
                youtubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/hhL8Ja1BFOI\" frameborder=\"0\" allowfullscreen></iframe>"));
                youtubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/Wc1O69sOpFk\" frameborder=\"0\" allowfullscreen></iframe>"));
                youtubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/6jbScFiSw3A\" frameborder=\"0\" allowfullscreen></iframe>"));
                youtubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/lJoW3OqXwUA\" frameborder=\"0\" allowfullscreen></iframe>"));
                youtubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/jLo4Sq7uLSc\" frameborder=\"0\" allowfullscreen></iframe>"));
                break;
            case "Fizika":
                youtubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/WabES5O8RaQ\" frameborder=\"0\" allowfullscreen></iframe>"));
                youtubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/BTG7vjtNwCE\" frameborder=\"0\" allowfullscreen></iframe>"));
                youtubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/YGbpRlULyJY\" frameborder=\"0\" allowfullscreen></iframe>"));
                youtubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/M0jjwAXQGhk\" frameborder=\"0\" allowfullscreen></iframe>"));
                youtubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/DvTbOJ2FziM\" frameborder=\"0\" allowfullscreen></iframe>"));
                break;
            case "Kimyo":
                youtubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/-5WUzUZHHe4\" frameborder=\"0\" allowfullscreen></iframe>"));
                youtubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/IFIhtX6T-8I\" frameborder=\"0\" allowfullscreen></iframe>"));
                youtubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/UingYqBcOz4\" frameborder=\"0\" allowfullscreen></iframe>"));
                youtubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/ePWsBPiiY-o\" frameborder=\"0\" allowfullscreen></iframe>"));
                youtubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/uRjjqcL6DX4\" frameborder=\"0\" allowfullscreen></iframe>"));
                break;
            case "Biologiya":
                youtubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/0cYqD4YOU-g\" frameborder=\"0\" allowfullscreen></iframe>"));
                youtubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/x0iMkBP3y60\" frameborder=\"0\" allowfullscreen></iframe>"));
                youtubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/44p3Xc7dI6Q\" frameborder=\"0\" allowfullscreen></iframe>"));
                youtubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/R28YkJFmqP0\" frameborder=\"0\" allowfullscreen></iframe>"));
                youtubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/uYAs2ITMK1g\" frameborder=\"0\" allowfullscreen></iframe>"));
                break;
            case "Astronomiya":
                youtubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/SWrn_Zaz5Zc\" frameborder=\"0\" allowfullscreen></iframe>"));
                youtubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/2eXmxELDbrU\" frameborder=\"0\" allowfullscreen></iframe>"));
                youtubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/djLG4fKGooI\" frameborder=\"0\" allowfullscreen></iframe>"));
                youtubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/Vxat_l2wZ4Q\" frameborder=\"0\" allowfullscreen></iframe>"));
                youtubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/KfVM2W4vrqw\" frameborder=\"0\" allowfullscreen></iframe>"));
                break;
            case "Geografiya":
                youtubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/YLj32pjxPY8\" frameborder=\"0\" allowfullscreen></iframe>"));
                youtubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/ETdBH6ycMSc\" frameborder=\"0\" allowfullscreen></iframe>"));
                youtubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/YcqGgSmgOGQ\" frameborder=\"0\" allowfullscreen></iframe>"));
                youtubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/BJjhcHRXK9s\" frameborder=\"0\" allowfullscreen></iframe>"));
                youtubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/zaepZR80OSs\" frameborder=\"0\" allowfullscreen></iframe>"));
                break;
            case "Tarix":       https://youtu.be/https://youtu.be/https://youtu.be/https://youtu.be/https://youtu.be/
                youtubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/RhKmk7br1Ww\" frameborder=\"0\" allowfullscreen></iframe>"));
                youtubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/x7pTGpVuuYU\" frameborder=\"0\" allowfullscreen></iframe>"));
                youtubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/ik6aGTBUSwQ\" frameborder=\"0\" allowfullscreen></iframe>"));
                youtubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/VJgi6zvVdvI\" frameborder=\"0\" allowfullscreen></iframe>"));
                youtubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/3Odhiv3ShXA\" frameborder=\"0\" allowfullscreen></iframe>"));
                break;
        }
        VideoAdapter videoAdapter = new VideoAdapter(youtubeVideos);

        recyclerView.setAdapter(videoAdapter);
    }
}