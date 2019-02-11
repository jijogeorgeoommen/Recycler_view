package com.example.user.recycler_view;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    private RecyclerView horizontal_recyclerview;
    private HorizontalAdapter horizontalAdapter;
    private ArrayList<String> namestr;
    private int[] image = {R.drawable.capamm, R.drawable.irronmann, R.drawable.hulkk, R.drawable.thor, R.drawable.blackwid, R.drawable.clintbarton, R.drawable.wintersoldierr};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        horizontal_recyclerview = findViewById(R.id.horizontalrview);
        super.onCreate(savedInstanceState);
        namestr = new ArrayList<String>();
        namestr.add("Cap.America");
        namestr.add("Iron Man");
        namestr.add("Hulk");
        namestr.add("Thor");
        namestr.add("Black Widow");
        namestr.add("Hawkeye");
        namestr.add("Winter Soldier");

        horizontalAdapter = new HorizontalAdapter(namestr);
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        horizontal_recyclerview.setAdapter(horizontalAdapter);
        horizontal_recyclerview.setLayoutManager(horizontalLayoutManager);
    }

    public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.MyViewHolder> {
        private List<String>namelist;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public ImageView photo;
            public TextView tview;

            public MyViewHolder(View view) {
                super(view);
                photo = view.findViewById(R.id.iconid);
                tview = view. findViewById(R.id.txtviewid);
            }
        }

        public HorizontalAdapter(List<String> namestr) {
            this.namelist = namestr;
        }

        @NonNull
        @Override
        public HorizontalAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View item = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.horizontal, viewGroup, false);
            return new MyViewHolder(item);
        }

        @Override
        public void onBindViewHolder(final MyViewHolder myViewHolder, final int i) {
           myViewHolder.photo.setImageResource(image[i]);
            myViewHolder.tview.setText(namestr.get(i));
            myViewHolder.tview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this,myViewHolder.tview.getText().toString(), Toast.LENGTH_SHORT).show();
                }
                });
            myViewHolder.photo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this,myViewHolder.tview.getText(), Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return namelist.size();
        }
    }
}