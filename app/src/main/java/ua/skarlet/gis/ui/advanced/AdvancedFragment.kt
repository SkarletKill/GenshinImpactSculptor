package ua.skarlet.gis.ui.advanced

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.skarlet.gis.R
import ua.skarlet.gis.ui.artifact.ArtifactsViewModel

class AdvancedFragment : Fragment() {

    private lateinit var viewModel: ArtifactsViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(ArtifactsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_advanced, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        viewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }
}