package mvvm.roomdatabase.aplicacaoconvidados.view.guest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import mvvm.roomdatabase.aplicacaoconvidados.R
import mvvm.roomdatabase.aplicacaoconvidados.databinding.ActivityGuestFormBinding

class GuestFormActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var _binding: ActivityGuestFormBinding
    private lateinit var mViewModel: GuestFormViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityGuestFormBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        mViewModel = ViewModelProvider(this).get(GuestFormViewModel::class.java)

        setListeners()
        observe()

    }

    override fun onClick(view : View?) {
        val id = view!!.id
        if (id == R.id.button_SaveInformation){

            val name = _binding.editTextWriteName.text.toString()
            val present = _binding.radioButtonSelectPresent.isChecked

            mViewModel.saveFormViewModel(name, present)
        }
    }

    private fun observe() {
       mViewModel.saveGuest.observe(this, Observer {
           if (it){
            Toast.makeText(applicationContext, "Sucesso", Toast.LENGTH_SHORT).show()
           } else {
               Toast.makeText(applicationContext, "Falha", Toast.LENGTH_SHORT).show()
           }
           finish()
       })
    }

    private fun setListeners() {
        _binding.buttonSaveInformation.setOnClickListener(this)
    }


}