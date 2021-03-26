package com.posse.android1.notes.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;
import com.posse.android1.notes.R;
import com.posse.android1.notes.note.Note;
import com.posse.android1.notes.ui.notes.NoteListFragment;

class ViewHolder extends RecyclerView.ViewHolder {

    private final AppCompatTextView mHeader;
    private final MaterialTextView mTimestamp;
    private int mId;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        mHeader = itemView.findViewById(R.id.list_note_header);
        mTimestamp = itemView.findViewById(R.id.list_note_date_time);
    }

    public void fillCard(NoteListFragment fragment, Note note) {
        mId = note.getNoteIndex();
        mHeader.setText(note.getName());
        mTimestamp.setText(note.getCreationDate());
        itemView.setOnLongClickListener((v) -> {
            fragment.setLastSelectedPosition(getLayoutPosition());
            return false;
        });
        fragment.registerForContextMenu(itemView);
    }

    public void clear(Fragment fragment) {
        itemView.setOnLongClickListener(null);
        fragment.unregisterForContextMenu(itemView);
    }
}