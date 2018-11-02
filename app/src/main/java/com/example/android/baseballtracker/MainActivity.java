package com.example.android.baseballtracker;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int firstTeam_runs;
    int firstTeam_outs;
    int seconedTeam_runs;
    int seconedTeam_outs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void teamnames(View view) {
        //Strings Holding the team names entered by the user
        String firstTeamName;
        String seconedTeamName;

        EditText firstTeam = findViewById(R.id.firstTeam);
        EditText seconedTeam = findViewById(R.id.seconedTeam);
        firstTeamName = firstTeam.getText().toString();
        seconedTeamName = seconedTeam.getText().toString();

        if (firstTeamName.matches("")) {
            Context context = getApplicationContext();
            CharSequence text = "You Sould Enter The Missing Team Name";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        if (seconedTeamName.matches("")) {
            Context context = getApplicationContext();
            CharSequence text = "You Sould Enter The Missing Team Name";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {
            Button submitButton = findViewById(R.id.Submit_button);
            Button reserButton = findViewById(R.id.reset);

            LinearLayout Linear = findViewById(R.id.Teams_Linear_Layout);
            LinearLayout varTeamNames = findViewById(R.id.varTeamNames);

            TextView varTeam1 = findViewById(R.id.varTeam1);
            TextView varTeam2 = findViewById(R.id.varTeam2);


            varTeam1.setText(firstTeamName);
            varTeam2.setText(seconedTeamName);

            submitButton.setVisibility(View.GONE);
            reserButton.setVisibility(view.VISIBLE);

            Linear.setVisibility(View.VISIBLE);
            varTeamNames.setVisibility(View.GONE);
        }
    }

    private void displayRunsForfirstTeam(int firstTeam_runs) {
        TextView runsView = findViewById(R.id.runs_first_team_score);
        runsView.setText(String.valueOf(firstTeam_runs));
    }

    private void displayRunsForseconedTeam(int seconedTeam_runs) {
        TextView runsView = findViewById(R.id.runs_seconed_team_score);
        runsView.setText(String.valueOf(seconedTeam_runs));
    }

    private void displayOutsForseconedTeam(int seconedTeam_outs) {
        TextView runsView = findViewById(R.id.outs_seconed_team_score);
        runsView.setText(String.valueOf(seconedTeam_outs));
    }

    private void displayOutsForfirstTeam(int firstTeam_outs) {
        TextView runsView = findViewById(R.id.outs_first_team_score);
        runsView.setText(String.valueOf(firstTeam_outs));
    }

    public void reset(View view) {
        firstTeam_outs = 0;
        firstTeam_runs = 0;
        seconedTeam_outs = 0;
        seconedTeam_runs = 0;
        displayRunsForfirstTeam(firstTeam_runs);
        displayRunsForseconedTeam(seconedTeam_runs);
        displayOutsForseconedTeam(seconedTeam_outs);
        displayOutsForfirstTeam(firstTeam_outs);
    }

    public void runsforFirstTeam(View view) {
        firstTeam_runs += 1;
        displayRunsForfirstTeam(firstTeam_runs);
    }

    public void runsTorseconedTeam(View view) {
        seconedTeam_runs += 1;
        displayRunsForseconedTeam(seconedTeam_runs);
    }

    public void outsforSeconedTeam(View view) {
        seconedTeam_outs += 1;
        displayOutsForseconedTeam(seconedTeam_outs);

    }

    public void outsforFirstTeam(View view) {
        firstTeam_outs += 1;
        displayOutsForfirstTeam(firstTeam_outs);
    }

}