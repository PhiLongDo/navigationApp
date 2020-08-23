package com.example.navigationapp.ui.poker;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.navigationapp.R;

import java.util.ArrayList;
import java.util.List;

public class PokerFragment extends Fragment {

    private Button btnAdd;
    private EditText edtNum01, edtNum02, edtNum03, edtNum04;
    private TextView sum01, sum02, sum03, sum04;
    private ListView lvPoints;
    private List<EditText> listEditText = new ArrayList<>();
    private List<TextView> listTextViewSum = new ArrayList<>();
    private List<LinePoint> listItems = new ArrayList<>();
    private LinePointAdapter linePointAdapter;

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
        lvPoints = root.findViewById(R.id.lvPoints);

        initList();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<String> listnum = new ArrayList<>();
                for (int i=0; i<4; i++){
                    String num = listEditText.get(i).getText().toString();
                    if (num.length() == 0){
                        listnum.add("0");
                    }
                    else{
                        Integer sum = (Integer) (Integer.parseInt(listTextViewSum.get(i).getText().toString())+Integer.parseInt(num));
                        if (sum >= 0) {
                            listTextViewSum.get(i).setText(sum.toString());
                        } else {
                            listTextViewSum.get(i).setText("0");
                        }
                        listnum.add(((Integer) Integer.parseInt(num)).toString());
                    }
                    listEditText.get(i).setText("");
                }
                listItems.add(0,new LinePoint(listnum.get(0),listnum.get(1),listnum.get(2),listnum.get(3)));
                linePointAdapter = new LinePointAdapter(listItems);
                lvPoints.setAdapter(linePointAdapter);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        btnAdd = null;
        edtNum01 = null;
        edtNum02 = null;
        edtNum03 = null;
        edtNum04 = null;
        sum01 = null;
        sum02 = null;
        sum03 = null;
        sum04 = null;
        lvPoints = null;
    }

    private void initList(){
        listEditText.add(edtNum01);
        listEditText.add(edtNum02);
        listEditText.add(edtNum03);
        listEditText.add(edtNum04);

        listTextViewSum.add(sum01);
        listTextViewSum.add(sum02);
        listTextViewSum.add(sum03);
        listTextViewSum.add(sum04);

    }
    private TextView newItemList(String num){
        TextView tv = new TextView(getContext());
        tv.setText(num);
        tv.setTextColor(Color.WHITE);
        return tv;
    }

    class LinePoint{
        String num1, num2, num3, num4;

        public LinePoint(String num1, String num2, String num3, String num4) {
            this.num1 = num1;
            this.num2 = num2;
            this.num3 = num3;
            this.num4 = num4;
        }

        public String getNum1() {
            return num1;
        }

        public void setNum1(String num1) {
            this.num1 = num1;
        }

        public String getNum2() {
            return num2;
        }

        public void setNum2(String num2) {
            this.num2 = num2;
        }

        public String getNum3() {
            return num3;
        }

        public void setNum3(String num3) {
            this.num3 = num3;
        }

        public String getNum4() {
            return num4;
        }

        public void setNum4(String num4) {
            this.num4 = num4;
        }
    }

    class ListLinePoint{
        TextView num01,num02,num03,num04;
    }

    class LinePointAdapter extends BaseAdapter{

        List<LinePoint> list;

        public LinePointAdapter(List<LinePoint> list) {
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return list.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ListLinePoint listLinePoint = null;
            if (view == null){
                listLinePoint = new ListLinePoint();
                view = getLayoutInflater().inflate(R.layout.item_line_point, viewGroup,false);

                listLinePoint.num01 = (TextView) view.findViewById(R.id.num01);
                listLinePoint.num02 = (TextView) view.findViewById(R.id.num02);
                listLinePoint.num03 = (TextView) view.findViewById(R.id.num03);
                listLinePoint.num04 = (TextView) view.findViewById(R.id.num04);

                view.setTag(listLinePoint);
            } else {
                listLinePoint = (ListLinePoint) view.getTag();
            }

            listLinePoint.num01.setText(list.get(i).getNum1());
            listLinePoint.num02.setText(list.get(i).getNum2());
            listLinePoint.num03.setText(list.get(i).getNum3());
            listLinePoint.num04.setText(list.get(i).getNum4());

            return view;
        }
    }
}