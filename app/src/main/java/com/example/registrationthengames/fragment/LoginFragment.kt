package com.example.registrationthengames.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.registrationthengames.R
import com.example.registrationthengames.base.BaseFragment
import com.example.registrationthengames.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth

private lateinit var binding: FragmentLoginBinding
private lateinit var auth: FirebaseAuth

class LoginFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.CreateAccountTextView.setOnClickListener {
            changeFragment(RegistrationFragment(), R.id.frame_layout)
        }

        auth = FirebaseAuth.getInstance()


        binding.btnLogin.setOnClickListener {
            when {
                binding.emailEditText.text.isEmpty() ->
                    binding.emailEditText.error = "Поле не может быть пустым"

                binding.passwordEditText.text.isEmpty() ->
                    binding.passwordEditText.error = "Поле не может быть пустым"

                binding.passwordEditText.text.length <= 7 ->
                    binding.passwordEditText.error = "Минимум 8 символов"

                else -> auth.signInWithEmailAndPassword(
                    binding.emailEditText.text.toString(),
                    binding.passwordEditText.text.toString()
                ).addOnCompleteListener {
                    if (it.isSuccessful) {
                        changeFragment(GamesFragment(), R.id.frame_layout)
                    } else {
                        Toast.makeText(
                            requireContext(),
                            "Ошибка, если нет аккаунта, зарегистрируйтесь.",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }
                }
            }
        }
    }
}