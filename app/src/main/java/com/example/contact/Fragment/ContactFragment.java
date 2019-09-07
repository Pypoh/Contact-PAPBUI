package com.example.contact.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contact.Adapter.ContactAdapter;
import com.example.contact.MainActivity;
import com.example.contact.R;

public class ContactFragment extends Fragment {

    private LinearLayout myProfileLayout;
    private RecyclerView contactList;
    private ContactAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);

        myProfileLayout = view.findViewById(R.id.my_profile_layout);
        contactList = view.findViewById(R.id.contact_recycler);

        contactList.setLayoutManager(new LinearLayoutManager(this.getContext()));
        adapter = new ContactAdapter(getContext(), MainActivity.dataContact);
        contactList.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        myProfileLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toProfileSetting();
            }
        });

        return view;


    }

    @Override
    public void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

    private void toProfileSetting() {
        Intent toProfileSetting = new Intent(this.getContext(), ProfileSetting.class);
        // Send Data

        startActivity(toProfileSetting);
    }
}
