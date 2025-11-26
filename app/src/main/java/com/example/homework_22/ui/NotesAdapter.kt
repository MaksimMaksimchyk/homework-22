package com.example.homework_22.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_22.databinding.ItemNoteBinding
import com.example.homework_22.domain.NoteModel
import java.text.SimpleDateFormat
import java.util.Locale

class NotesAdapter(val viewModel: MainActivityViewModel) :
    RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {

    private val notes = mutableListOf<NoteModel>()


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NoteViewHolder {
        val binding = ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: NoteViewHolder,
        position: Int
    ) {
        holder.bind(notes[position])
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    inner class NoteViewHolder(private val binding: ItemNoteBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(note: NoteModel) {
            binding.noteContent.text = note.content
            binding.noteDate.text =
                SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.getDefault()).format(note.createdAt)
            binding.btnDelete.setOnClickListener {
                viewModel.deleteNote(note)
            }
        }

    }

    fun submitList(newNotes: List<NoteModel>) {
        notes.clear()
        notes.addAll(newNotes)
        notifyDataSetChanged()
    }

}