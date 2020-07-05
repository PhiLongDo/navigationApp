package com.example.navigationapp.ui.poker;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.navigationapp.R;

import java.util.ArrayList;
import java.util.List;

public class PokerFragment extends Fragment {

    private Button btnAdd;
    private EditText edtNum01, edtNum02, edtNum03, edtNum04;
    private TextView sum01, sum02, sum03, sum04;
    private ListView lvPoint01, lvPoint02, lvPoint03, lvPoint04;
    private List<EditText> listEditText = new ArrayList<>();
    private List<TextView> listTextView = new ArrayList<>();
    private List<ListView> listListView = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_poker, container, false);

        btnAdd = root.findViewById(R.id.btnAdd);
        edtNum01 = root.findViewById(R.id.edtNum01);
        edtNum02 = root.findViewById(R.id.edtNum02);
        edtNum03 = root.findViewById(R.id.edtNum03);
        edtNum04 = root.findViewById(R.id.edtNum04);
        sum01 = root.findViewById(R.id.sum01);
        sum02 = root.findViewById(R.id.sum02);
        sum03 = root.findViewById(R.id.sum03);
        sum04 = root.findViewById(R.id.sum04);
        lvPoint01 = root.findViewById(R.id.lvPoint01);
        lvPoint02 = root.findViewById(R.id.lvPoint02);
        lvPoint03 = root.findViewById(R.id.lvPoint03);
        lvPoint04 = root.findViewById(R.id.lvPoint04);

        initList();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i=0; i<4; i++){
                    String num = listEditText.get(i).getText().toString();
                    if (num.length() == 0){
                        listListView.get(i).addHeaderView(newItemList("0"));
                    }
                    else{
                        listListView.get(i).addHeaderView(newItemList(num));
                        listTextView.get(i).setText(
                                ((Integer) (Integer.parseInt(listTextView.get(i).getText().toString())+Integer.parseInt(num))).toString()
                        );
                    }
                    listEditText.get(i).setText("");
                }
            }
        });

        return root;
    }

    private void initList(){
        listEditText.add(edtNum01);
        listEditText.add(edtNum02);
        listEditText.add(edtNum03);
        listEditText.add(edtNum04);

        listTextView.add(sum01);
        listTextView.add(sum02);
        listTextView.add(sum03);
        listTextView.add(sum04);

        listListView.add(lvPoint01);
        listListView.add(lvPoint02);
        listListView.add(lvPoint03);
        listListView.add(lvPoint04);
    }
    private TextView newItemList(String num){
        TextView tv = new TextView(getContext());
        tv.setText(num);
        tv.setTextColor(Color.WHITE);
        return tv;
    }

}