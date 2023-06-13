package com.example.trabalhopratico2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView lista;
    private List itemList;
    ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.lista);
        itemList = new ArrayList<>();
        adapter = new ItemAdapter(this, itemList);

        lista.setAdapter(adapter);
        lista.setOnItemClickListener(this);

        registerForContextMenu(lista);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.actAdd) {
            NewItemDialog newItemDialog = new NewItemDialog();
            newItemDialog.show(getSupportFragmentManager(), "add");
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.item_menu, menu);
    }

    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int position = info.position;

        if (item.getItemId() == R.id.actEdit) {
            EditItemDialog editItemDialog = new EditItemDialog();
            editItemDialog.show(getSupportFragmentManager(), "edit");
            return true;

        } else if (item.getItemId() == R.id.actDelete) {
            DeleteItemDialog deleteItemDialog = new DeleteItemDialog();
            deleteItemDialog.show(getSupportFragmentManager(), "delete");

            return true;

        } else {
            return super.onContextItemSelected(item);
        }
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String item = adapterView.getAdapter().getItem(i).toString();

        openContextMenu(view);
    }

    public List<String> getItemList() {
        return itemList;
    }

    public ItemAdapter getAdapter() {
        return adapter;
    }
}