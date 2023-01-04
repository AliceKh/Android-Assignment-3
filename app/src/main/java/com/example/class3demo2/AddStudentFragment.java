package com.example.class3demo2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.navigation.Navigation;

import android.os.Looper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.class3demo2.databinding.FragmentAddStudentBinding;
import com.example.class3demo2.model.Model;
import com.example.class3demo2.model.Student;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;

public class AddStudentFragment extends Fragment {

//    Button btnDatePicker, btnTimePicker;
//    EditText txtDate, txtTime;
//    private int mYear, mMonth, mDay, mHour, mMinute;

    FragmentAddStudentBinding binding;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentActivity parentActivity = getActivity();
        parentActivity.addMenuProvider(new MenuProvider() {
            @Override
            public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
                menu.removeItem(R.id.addStudentFragment);
            }

            @Override
            public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
                return false;
            }

        },this, Lifecycle.State.RESUMED);
//        setContentView(R.layout.fragment_add_student);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAddStudentBinding.inflate(inflater,container,false);
        View view = binding.getRoot();

        binding.saveBtn.setOnClickListener(view1 -> {
            String name = binding.nameEt.getText().toString();
            String stId = binding.idEt.getText().toString();
            DatePicker datePicker = view.findViewById(R.id.date_picker);
            String stBirthday = datePicker.getDayOfMonth() + "/" + datePicker.getMonth()+1 +"/"+ datePicker.getYear();
            TimePicker timePicker = view.findViewById(R.id.time_picker);
            String stTime = timePicker.getHour() +":"+ timePicker.getMinute();
            Student st = new Student(stId,name,stBirthday,stTime,"",false);
            Model.instance().addStudent(st,()->{
                Navigation.findNavController(view1).popBackStack();
            });

        popUp(inflater, view, R.layout.success_popup);


//            Button btnDatePicker=view.findViewById(R.id.btn_date);
//            Button btnTimePicker=view.findViewById(R.id.btn_time);
//            EditText txtDate=view.findViewById(R.id.in_date);
//            EditText txtTime=view.findViewById(R.id.in_time);
//
//            btnDatePicker.setOnClickListener(this);
//            btnTimePicker.setOnClickListener(this);
        });

        binding.cancellBtn.setOnClickListener(view1 -> Navigation.findNavController(view1).popBackStack(R.id.studentsListFragment,false));
        return view;
    }

    public void popUp(LayoutInflater inflater, View view, int popUpId) {
        // inflate the layout of the popup window
        View popupView = inflater.inflate(popUpId, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        // dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });

        new android.os.Handler(Looper.getMainLooper()).postDelayed(
                new Runnable() {
                    public void run() {
                        popupWindow.dismiss();
                    }
                },
                5000);
    }

//    @Override
//    public void onClick(View v) {
//
//        if (v == btnDatePicker) {
//
//            // Get Current Date
//            final Calendar c = Calendar.getInstance();
//            mYear = c.get(Calendar.YEAR);
//            mMonth = c.get(Calendar.MONTH);
//            mDay = c.get(Calendar.DAY_OF_MONTH);
//
//
//            DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
//                    new DatePickerDialog.OnDateSetListener() {
//
//                        @Override
//                        public void onDateSet(DatePicker view, int year,
//                                              int monthOfYear, int dayOfMonth) {
//
//                            txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
//
//                        }
//                    }, mYear, mMonth, mDay);
//            datePickerDialog.show();
//        }
//        if (v == btnTimePicker) {
//
//            // Get Current Time
//            final Calendar c = Calendar.getInstance();
//            mHour = c.get(Calendar.HOUR_OF_DAY);
//            mMinute = c.get(Calendar.MINUTE);
//
//            // Launch Time Picker Dialog
//            TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(),
//                    new TimePickerDialog.OnTimeSetListener() {
//
//                        @Override
//                        public void onTimeSet(TimePicker view, int hourOfDay,
//                                              int minute) {
//
//                            txtTime.setText(hourOfDay + ":" + minute);
//                        }
//                    }, mHour, mMinute, false);
//            timePickerDialog.show();
//        }
//    }

}