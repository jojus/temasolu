package com.example.temasolution;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Justin Joy (jojus) on 22-05-2017.
 */

@SuppressWarnings("DefaultFileTemplate")
public class AddPrescription extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.add_prescription,container,false);
    }
}
