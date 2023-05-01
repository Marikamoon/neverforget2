package com.example.neverforgettest1;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.NumberPicker;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;



public class dialog extends DialogFragment {
    private NumberPicker picker;
    private Context dialog;

        public int setAPicker(){
            return 0;
        };

        @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = (View)inflater.inflate(R.layout.dialog, null);


        NumberPicker setNum = (NumberPicker) view.findViewById(R.id.numPicker);
        setNum.setMinValue(collection.minNum);
        setNum.setMaxValue(collection.maxNum);
        setNum.setDisplayedValues(collection.strList);



        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(view)
                // Add action buttons
                .setPositiveButton("Set", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // sign in the user ...
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });


        return builder.create();

    }
}

