package com.binbin.demo.listviewoptimize;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by 陈锡滨 on 2017/3/16.
 */
public class MyAdapterSecond extends BaseAdapter{
    private ArrayList<HashMap<String,Object>> mDatas;
    private Context context;
    private LayoutInflater inflater;

    public MyAdapterSecond(Context context,ArrayList<HashMap<String,Object>> datas){
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.mDatas =  datas;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount(){
        return 2;
    }
    @Override
    public int getItemViewType(int position){
        return (int)mDatas.get(position).get("type");
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolderTypeOne viewHolderTypeOne = null;
        ViewHolderTypeTwo viewHolderTypeTwo = null;
        int type = getItemViewType(position);

        if(convertView == null){
            switch (type){
                case 0:
                    convertView = inflater.inflate(R.layout.mylistview_layout_type0,null,false);
                    viewHolderTypeOne = new ViewHolderTypeOne();
                    viewHolderTypeOne.mItemImage = (ImageView) convertView.findViewById(R.id.itemImage);
                    viewHolderTypeOne.mItemContent = (TextView) convertView.findViewById(R.id.itemContent);
                    viewHolderTypeOne.mItemButton = (Button) convertView.findViewById(R.id.itemButton_type0);
                    convertView.setTag(viewHolderTypeOne);
                    break;
                case 1:
                    convertView=inflater.inflate(R.layout.mylistview_layout_type1,null,false);
                    viewHolderTypeTwo=new ViewHolderTypeTwo();
                    viewHolderTypeTwo.mItemContent=(TextView)convertView.findViewById(R.id.itemContent);
                    viewHolderTypeTwo.mItemTitle=(TextView)convertView.findViewById(R.id.itemTitle);
                    viewHolderTypeTwo.mItemButton=(Button)convertView.findViewById(R.id.itemButton_type1);
                    convertView.setTag(viewHolderTypeTwo);
                    break;
            }
        }else{
            switch (type){
                case 0:
                    viewHolderTypeOne = (ViewHolderTypeOne) convertView.getTag();
                    break;
                case 1:
                    viewHolderTypeTwo = (ViewHolderTypeTwo) convertView.getTag();
                    break;
                default:break;
            }
        }
        switch (type){
            case 0:
                viewHolderTypeOne.mItemContent.setText( mDatas.get(position).get("itemContent").toString());
                viewHolderTypeOne.mItemImage.setImageResource((Integer) mDatas.get(position).get("itemImage"));
                addListener(viewHolderTypeOne.mItemButton);
                break;
            case 1:
                viewHolderTypeTwo.mItemContent.setText(mDatas.get(position).get("itemContent").toString());
                viewHolderTypeTwo.mItemTitle.setText(mDatas.get(position).get("itemTitle").toString());
                addListener(viewHolderTypeTwo.mItemButton);
                break;
            default:break;
        }
        return convertView;
    }

    private void addListener(View view) {
        switch (view.getId()){
            case R.id.itemButton_type0:
                view.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context,"你点了布局0的button",Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case R.id.itemButton_type1:
                view.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context,"你点了布局1的button",Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            default:break;
        }
    }

    final static class ViewHolderTypeOne{
        ImageView mItemImage;
        TextView mItemContent;
        Button mItemButton;
    }
    final static class ViewHolderTypeTwo{
        TextView mItemTitle;
        TextView mItemContent;
        Button mItemButton;
    }
}
