package com.prank.sound.hair.cut.ps.pranksound.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.prank.sound.hair.cut.ps.pranksound.Activity.RecordActivity
import com.prank.sound.hair.cut.ps.pranksound.Adapter.RecordAdapter
import com.prank.sound.hair.cut.ps.pranksound.R
import com.prank.sound.hair.cut.ps.pranksound.databinding.FragmentCreateBinding
import com.prank.sound.hair.cut.ps.pranksound.utils.Utils


class CreateFragment : Fragment() {
    private lateinit var binding: FragmentCreateBinding

    private lateinit var recyclerView: RecyclerView
    private lateinit var recordAdapter: RecordAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCreateBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.llBtnCreate.setOnClickListener {
            val intent = Intent(requireActivity(),RecordActivity::class.java)
            startActivity(intent)
        }

        val list = Utils.getAudioList(requireActivity())
        for (i in list) {
            Log.d("record", i.filePath)
        }
        if (list.isEmpty()) {
            binding.llNoRecord.visibility = View.VISIBLE
        } else {
            recordAdapter = RecordAdapter(requireActivity(), list)
            binding.rcvRecord.layoutManager =
                LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
            binding.rcvRecord.adapter = recordAdapter
        }
    }




}