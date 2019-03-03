package com.example.retrofitqueryandpathexercise.frag;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.retrofitqueryandpathexercise.R;
import com.example.retrofitqueryandpathexercise.model.Number;
import com.example.retrofitqueryandpathexercise.network.NumberService;
import com.example.retrofitqueryandpathexercise.network.RetrofitSingleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static com.example.retrofitqueryandpathexercise.MainActivity.NUMBER;


public class MainFragment extends Fragment {
    private static final String TAG = "Main Fragment";
    TextView textView;
    Retrofit retrofit;

    public MainFragment() {
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textView = view.findViewById(R.id.display_textview);
        retrofit = new RetrofitSingleton().getInstance();

        Bundle args = getArguments();
        assert args != null;
        final int number = args.getInt(NUMBER);

        NumberService numberService = retrofit.create(NumberService.class);
        Call<Number> numberCall = numberService.getText(number);
        numberCall.enqueue(new Callback<Number>() {
            @Override
            public void onResponse(Call<Number> call, Response<Number> response) {
                Log.d(TAG, "onResponse: " + response.body());
                textView.setText(response.body().getText());
            }

            @Override
            public void onFailure(Call<Number> call, Throwable t) {
                Log.d(TAG, "onFailure: something went wrong " + t.getMessage());
            }
        });
    }
}
