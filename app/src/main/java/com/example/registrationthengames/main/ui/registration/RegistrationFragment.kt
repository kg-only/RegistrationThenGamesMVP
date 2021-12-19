package com.example.registrationthengames.main.ui.registration

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.registrationthengames.R
import com.example.registrationthengames.common.mvp.BaseFragment
import com.example.registrationthengames.databinding.FragmentRegistrationBinding
import com.example.registrationthengames.main.ui.gamelist.GamesFragment
import com.google.firebase.auth.FirebaseAuth

private lateinit var binding: FragmentRegistrationBinding
private lateinit var auth: FirebaseAuth

class RegistrationFragment() : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = FirebaseAuth.getInstance()
        binding.btnRegister.setOnClickListener {
            if (!isValidEmail(binding.emailRegister.text.toString())) {
                Toast.makeText(requireContext(), "Неверный email", Toast.LENGTH_SHORT).show()

            } else if (isValidEmail(binding.emailRegister.text.toString())) {

                when {
                    binding.numberRegister.text.isEmpty() ->
                        binding.numberRegister.error =
                            "Поле не может быть пустым"

                    binding.numberRegister.text.length > 9 ->
                        binding.numberRegister.error = "Не больше 9 цифр"

                    binding.numberRegister.text.length < 9 ->
                        binding.numberRegister.error = "9 цифр без нуля"
                }
                when {
                    binding.emailRegister.text.isEmpty() ->
                        binding.emailRegister.error = "Пустое поле"
                }
                when {
                    binding.passwordRegister.text.length <= 7 ->
                        binding.passwordRegister.error = "Минимум 8 символов"

                    binding.passwordRegister.text.isEmpty() -> binding.passwordRegister.error =
                        "Поле не может быть пустым"
                }
                when {
                    binding.confirmPasswordRegister.text.isEmpty() -> binding.confirmPasswordRegister.error =
                        "Поле не может быть пустым"

                    binding.passwordRegister.text.toString() != binding.confirmPasswordRegister.text.toString() ->
                        binding.confirmPasswordRegister.error = "Пароли не совпадают"

                    binding.passwordRegister.text.toString() == binding.confirmPasswordRegister.text.toString() ->

                        auth.createUserWithEmailAndPassword(
                            binding.emailRegister.text.toString(),
                            binding.passwordRegister.text.toString()
                        ).addOnCompleteListener {
                            if (it.isSuccessful) {
                                changeFragment(GamesFragment(), R.id.frame_layout)
                                Log.e("REGISTER", "DIDN'T GET")
                            } else {
                                Toast.makeText(
                                    requireContext(),
                                    "Регистрация невозможна",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                }
            }
        }
    }
}

