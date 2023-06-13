package com.example.exercicio7;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ButtonsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ButtonsFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private OnFragmentInteractionListener mListener;

    public ButtonsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ButtonsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ButtonsFragment newInstance(String param1, String param2) {
        ButtonsFragment fragment = new ButtonsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_buttons, container, false);

        Button btPreto = (Button) view.findViewById(R.id.btPreto);
        Button btAzul = (Button) view.findViewById(R.id.btAzul);
        Button btVerde = (Button) view.findViewById(R.id.btVerde);
        Button btVermelho = (Button) view.findViewById(R.id.btVermelho);
        Button btAmarelo = (Button) view.findViewById(R.id.btAmarelo);

        btPreto.setOnClickListener(this);
        btAzul.setOnClickListener(this);
        btVerde.setOnClickListener(this);
        btVermelho.setOnClickListener(this);
        btAmarelo.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        if (mListener != null) {
            if (view.getId() == R.id.btPreto) {
                String cor = "#000000";

                mListener.onFragmentInteraction(cor);

            } else if (view.getId() == R.id.btAzul) {
                String cor = "#4169E1";

                mListener.onFragmentInteraction(cor);

            } else if (view.getId() == R.id.btVerde) {
                String cor = "#008000";

                mListener.onFragmentInteraction(cor);

            } else if (view.getId() == R.id.btVermelho) {
                String cor = "#FF0000";

                mListener.onFragmentInteraction(cor);

            } else if (view.getId() == R.id.btAmarelo) {
                String cor = "#FFC222";

                mListener.onFragmentInteraction(cor);
            }
        }
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;

        } else {
            throw new RuntimeException(context.toString() + "must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();

        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(String text);
    }
}