package com.example.recyclerviewtitan;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewtitan.adapter.ParentItemAdapter;
import com.example.recyclerviewtitan.model.ChildItem;
import com.example.recyclerviewtitan.model.ParentItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity
        extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView ParentRecyclerViewItem = findViewById(R.id.parent_recyclerview);

        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        ParentItemAdapter parentItemAdapter = new ParentItemAdapter(ParentItemList());

        ParentRecyclerViewItem.setAdapter(parentItemAdapter);
        ParentRecyclerViewItem.setLayoutManager(layoutManager);
    }

    private List<ParentItem> ParentItemList()
    {
        List<ParentItem> itemList = new ArrayList<>();

        ParentItem item0 = new ParentItem( "Titulo Faixa", ChildItemList(""));
        itemList.add(item0);

        ParentItem item1 = new ParentItem( "Toyota", ChildItemList("Toyota"));
        itemList.add(item1);

        ParentItem item2 = new ParentItem( "Ferrari", ChildItemList("Ferrari"));
        itemList.add(item2);

        ParentItem item3 = new ParentItem( "Fiat", ChildItemList("Fiat"));
        itemList.add(item3);

        return itemList;
    }

    private List<ChildItem> ChildItemList(String CarBrand)
    {
        List<ChildItem> ChildItemList
                = new ArrayList<>();

        switch (CarBrand) {
            case "Toyota":
                ChildItemList.add(new ChildItem("Corola", 177));
                ChildItemList.add(new ChildItem("Corola", 177));
                ChildItemList.add(new ChildItem("SW4", 204));
                ChildItemList.add(new ChildItem("Corola" ,177));
                ChildItemList.add(new ChildItem("Etios", 88));
                break;
            case "Fiat":
                ChildItemList.add(new ChildItem("Uno", 75));
                ChildItemList.add(new ChildItem("Uno", 75));
                ChildItemList.add(new ChildItem("Palio", 75));
                break;
            case "Ferrari":
                ChildItemList.add(new ChildItem("812 GTS", 800));
                ChildItemList.add(new ChildItem("812 GTS", 800));
                ChildItemList.add(new ChildItem("812 GTS", 800));
                ChildItemList.add(new ChildItem("296 GTS", 830));
                ChildItemList.add(new ChildItem("Roma", 620));
                break;
            default:
                break;
        }
        return ChildItemList;
    }
}