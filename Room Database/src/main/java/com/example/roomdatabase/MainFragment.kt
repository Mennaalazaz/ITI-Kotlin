package com.example.roomdatabase

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.roomdatabase.Adapter.ToDoAdapter
import com.example.roomdatabase.ViewModel.ToDoViewModel
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase.Local_db.ToDoEntity

class MainFragment : Fragment() {
    private lateinit var todoViewModel: ToDoViewModel
    private lateinit var adapter: ToDoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.todoRecyclerView)
        val inputTitle = view.findViewById<EditText>(R.id.inputTitle)
        val inputDesc = view.findViewById<EditText>(R.id.inputDesc)
        val addButton = view.findViewById<Button>(R.id.addButton)

        adapter = ToDoAdapter { task -> todoViewModel.delete(task) }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        todoViewModel = ViewModelProvider(this)[ToDoViewModel::class.java]
        todoViewModel.allTasks.observe(viewLifecycleOwner) { tasks ->
            adapter.setData(tasks)
        }

        addButton.setOnClickListener {
            val title = inputTitle.text.toString()
            val desc = inputDesc.text.toString()
            if (title.isNotBlank()) {
                todoViewModel.insert(ToDoEntity(title = title, description = desc))
                inputTitle.text.clear()
                inputDesc.text.clear()
            }
        }

        return view
    }
}

