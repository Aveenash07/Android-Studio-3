package com.example.task2_othermenus


import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val img1: ImageView = findViewById(R.id.imageView)
        registerForContextMenu(img1)

        val btn1: Button = findViewById(R.id.button)
        btn1.setOnLongClickListener {
            startActionMode(actionModeCallback)
            true
        }
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menu?.setHeaderTitle("Image result for avatar ")
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.float_menu, menu)
    }

    private val actionModeCallback = object : ActionMode.Callback {
        override fun onCreateActionMode(mode: ActionMode, menu: Menu): Boolean {
            menuInflater.inflate(R.menu.context_menu, menu)
            return true
        }


        override fun onPrepareActionMode(mode: ActionMode, menu: Menu) = false
        override fun onActionItemClicked(p0: ActionMode?, p1: MenuItem?): Boolean {
            TODO("Not yet implemented")
        }

        override fun onDestroyActionMode(mode: ActionMode) {}
    }

    }

