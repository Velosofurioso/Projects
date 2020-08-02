package com.velosolucas.app_festa_fim_ano.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.velosolucas.app_festa_fim_ano.R;
import com.velosolucas.app_festa_fim_ano.constant.FimDeAnoConstants;
import com.velosolucas.app_festa_fim_ano.data.SecurityPreferences;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private SecurityPreferences mSecurityPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mSecurityPreferences = new SecurityPreferences(this);

        this.mViewHolder.textToday = findViewById(R.id.text_today);
        this.mViewHolder.textDaysLeft = findViewById(R.id.text_days_left);
        this.mViewHolder.buttonConfirm = findViewById(R.id.button_confirm);

        this.mViewHolder.buttonConfirm.setOnClickListener(this);

        // Datas
        this.mViewHolder.textToday.setText(sdf.format(Calendar.getInstance().getTime()));

        String daysLeft = String.format("%s %s", String.valueOf(this.getDaysLeft()), getString(R.string.dias));

        this.mViewHolder.textDaysLeft.setText(daysLeft);

    }

    @Override
    protected void onResume() {
        super.onResume();
        this.verifyPresence();
    }

    private void verifyPresence() {
        String presenceStatus = this.mSecurityPreferences.getStoredString(FimDeAnoConstants.PRESENCE_KEY);

        if("".equals(presenceStatus))
            this.mViewHolder.buttonConfirm.setText(R.string.nao_confimardo);

        else if(FimDeAnoConstants.CONFIRMATION_YES.equals(presenceStatus))
            this.mViewHolder.buttonConfirm.setText(R.string.sim);

        else
            this.mViewHolder.buttonConfirm.setText(R.string.nao);
    }

    @Override
    public void onClick(View v) {
        // Faz a chamada para a Details activity
        if(v.getId()==R.id.button_confirm){
            String presenceStatus = this.mSecurityPreferences.getStoredString(FimDeAnoConstants.PRESENCE_KEY);

            Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtra(FimDeAnoConstants.PRESENCE_KEY, presenceStatus);
            startActivity(intent);
        }
    }


    private int getDaysLeft(){
        // Data de Hoje
        Calendar calendarToday = Calendar.getInstance();
        int today = calendarToday.get(Calendar.DAY_OF_YEAR);

        // Dia maximo do ano
        Calendar calendarLastDay = Calendar.getInstance();
        int maxDay = calendarLastDay.getActualMaximum(Calendar.DAY_OF_YEAR);

        return maxDay - today;
    }



    private static class ViewHolder {
        TextView textToday, textDaysLeft;
        Button buttonConfirm;
    }
}