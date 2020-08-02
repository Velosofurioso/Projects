package com.velosolucas.app_festa_fim_ano.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import com.velosolucas.app_festa_fim_ano.R;
import com.velosolucas.app_festa_fim_ano.constant.FimDeAnoConstants;
import com.velosolucas.app_festa_fim_ano.data.SecurityPreferences;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder viewHolder = new ViewHolder();
    private SecurityPreferences mSecurityPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        this.mSecurityPreferences = new SecurityPreferences(getApplicationContext());

        this.viewHolder.participar = findViewById(R.id.chk_participar);
        this.viewHolder.participar.setOnClickListener(this);

        this.loadDataFromActivity();
    }

    private void loadDataFromActivity() {
        Bundle extras = getIntent().getExtras();
        if(extras != null && !extras.isEmpty()){
            if (FimDeAnoConstants.CONFIRMATION_YES.equals(extras.getString(FimDeAnoConstants.PRESENCE_KEY))) {
                this.viewHolder.participar.setChecked(true);
            } else {
                this.viewHolder.participar.setChecked(false);
            }

        }

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.chk_participar){
            if(this.viewHolder.participar.isChecked()){
                this.mSecurityPreferences.storeSting(FimDeAnoConstants.PRESENCE_KEY, FimDeAnoConstants.CONFIRMATION_YES);
            }
            else{
                this.mSecurityPreferences.storeSting(FimDeAnoConstants.PRESENCE_KEY, FimDeAnoConstants.CONFIRMATION_NO);
            }
        }
    }

    public static class ViewHolder{
        CheckBox participar;
    }
}