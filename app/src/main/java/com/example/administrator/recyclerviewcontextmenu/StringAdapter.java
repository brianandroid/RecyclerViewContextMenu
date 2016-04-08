package com.example.administrator.recyclerviewcontextmenu;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 08/04/2016.
 */
public class StringAdapter extends RecyclerView.Adapter<StringAdapter.StringViewHolder> {

    private final Context mCtx;
    private List<String> mString;

    public StringAdapter(Context context, List<String> strings) {
        this.mCtx = context;
        this.mString = strings;
    }

    @Override
    public StringViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(mCtx).inflate(R.layout.item_layout, parent, false);
        return new StringViewHolder(root);
    }

    @Override
    public void onBindViewHolder(StringViewHolder holder, int position) {
        final String data = mString.get(position);
        holder.bind(data);
    }

    @Override
    public int getItemCount() {
        return mString.size();
    }

    public static class StringViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {

        TextView title;
        TextView subtitle;

        public StringViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            subtitle = (TextView) view.findViewById(R.id.subtitle);
        }

        public void bind(final String message) {
            title.setText(message);
            subtitle.setText(String.valueOf(getAdapterPosition()));
            this.itemView.setOnCreateContextMenuListener(this);
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.setHeaderTitle("Select action...");
            menu.add(Menu.NONE, R.id.action_edit, 0, "Edit");
            menu.add(Menu.NONE, R.id.action_remove, 0, "Remove");
        }
    }
}
