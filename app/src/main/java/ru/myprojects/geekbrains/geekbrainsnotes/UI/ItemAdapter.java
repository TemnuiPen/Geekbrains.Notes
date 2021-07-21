package ru.myprojects.geekbrains.geekbrainsnotes.UI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

import ru.myprojects.geekbrains.geekbrainsnotes.R;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemHolder> {

    private LinkedList<Note> noteList;
    private OnItemClickListener onItemClickListener;

    public ItemAdapter(LinkedList<Note> noteList) {
        this.noteList = noteList;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item, viewGroup,false);
        return new ItemHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        onBind(holder, position, noteList.get(position));
    }

    private void onBind(ItemHolder holder, int position, Note noteList) {
        holder.noteHeadline.setText(noteList.headline);
        holder.noteDate.setText(noteList.date);

        if(noteList.status.equals(NoteStatus.IS_NOT_IN_FAVOURITE)) {
            holder.favouriteStatus.setBackgroundResource(R.drawable.ic_baseline_star_grey_24);
        } else if (noteList.status.equals(NoteStatus.IS_IN_FAVOURITE)) {
            holder.favouriteStatus.setBackgroundResource(R.drawable.ic_baseline_star_yellow_24);
        }

        holder.favouriteStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (noteList.status.equals(NoteStatus.IS_IN_FAVOURITE)) {
                    noteList.status = NoteStatus.IS_NOT_IN_FAVOURITE;
                    holder.favouriteStatus
                            .setBackgroundResource(R.drawable.ic_baseline_star_grey_24);
                }
                else if (noteList.status.equals(NoteStatus.IS_NOT_IN_FAVOURITE)) {
                    noteList.status = NoteStatus.IS_IN_FAVOURITE;
                    holder.favouriteStatus
                            .setBackgroundResource(R.drawable.ic_baseline_star_yellow_24);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

    void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    //интерфейс для обработки нажатий
    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
    public class ItemHolder extends RecyclerView.ViewHolder {
        TextView noteHeadline = itemView.findViewById(R.id.tv_headline);
        TextView noteDate = itemView.findViewById(R.id.tv_date);
        ImageButton favouriteStatus = itemView.findViewById(R.id.btn_star);
        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            noteHeadline.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    if (onItemClickListener!= null) {
                        onItemClickListener.onItemClick(view, getAdapterPosition());
                    }
                }
            });
        }

    }
}
