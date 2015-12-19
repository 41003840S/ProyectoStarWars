package com.example.manuel.starwars;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * A placeholder fragment containing a simple view.
 */
public class ComingSoonActivityFragment extends Fragment {

    public ComingSoonActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View ComingFragment =inflater.inflate(R.layout.fragment_coming_soon, container, false);



        VideoView mainVideo = (VideoView) ComingFragment.findViewById(R.id.videoView);
        mainVideo.setVideoURI(Uri.parse("android.resource://" + getContext().getPackageName()+"/"+R.raw.trailer));
        mainVideo.setMediaController(new MediaController(getContext()));
        mainVideo.requestFocus();
        mainVideo.start();

        return ComingFragment;
    }
}
