package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import ru.otus.daggerhomework.di.AppContext
import ru.otus.daggerhomework.di.DaggerFragmentProducerComponent
import javax.inject.Inject

class FragmentProducer : Fragment() {

    @AppContext
    @Inject
    lateinit var appContext: Context

    @Inject
    lateinit var vm: ViewModelProducer

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerFragmentProducerComponent.factory().create(
            (requireActivity() as MainActivity).getMainActivityComponent()!!
        ).inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button).setOnClickListener {
            //отправить результат через livedata в другой фрагмент
            lifecycleScope.launch {
                vm.generateColor()
            }
        }
    }
}