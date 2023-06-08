package ru.sr.testtaskfooddelivery.feature_home.presentation.product

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.navArgs
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.sr.testtaskfooddelivery.feature_home.databinding.DialogFragmentProductBinding
import ru.sr.testtaskfooddelivery.feature_home.presentation.dishe.model.DisheUiModel
import ru.sr.testtaskfooddelivery.loadImage

class ProductDialogFragment : DialogFragment() {

    private var _binding: DialogFragmentProductBinding? = null
    private val binding get() = _binding!!

    private val args by navArgs<ProductDialogFragmentArgs>()
    private val viewModel by viewModel<ProductViewModel>()

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = DialogFragmentProductBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        bind(args.product)
    }

    private fun bind(item: DisheUiModel) = binding.apply {
        productImage.loadImage(item.imageUrl)
        productDescription.text = item.description
        productPrice.text = item.price.toString()
        productWeight.text = item.weight.toString()

        closeButton.setOnClickListener {
            dismiss()
        }

        addButton.setOnClickListener {
            viewModel.addProductToCart(item)
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}