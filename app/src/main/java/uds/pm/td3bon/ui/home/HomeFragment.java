package uds.pm.td3bon.ui.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import uds.pm.td3bon.LevelActivity;
import uds.pm.td3bon.databinding.FragmentHomeBinding;

@SuppressLint("DefaultLocale")
public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    private static int launchesCounter = 0;
    private int score = 0;
    private int level = 1;

    private Context containerContext;
    private TextView levelTextView;
    private TextView scoreTextView;

    private Button restartButton;
    private Button addScoreButton;

    private TextView launchesTextView;
    private int NUMBER_OF_REQUEST_LAUNCHES = 1;
    private void incrementerScore() {
        score++;
        int newLevel = 1 + score/5;
        if(level != newLevel){
            Intent showResultIntent = new Intent(containerContext , LevelActivity.class);
            showResultIntent.putExtra("level" , newLevel );
//            startActivity(showResultIntent);

            startActivityForResult(showResultIntent , NUMBER_OF_REQUEST_LAUNCHES);
        }
        level = newLevel;
    }

    private void clearLevelAndScore() {
        level = 1;
        score = 0;
    }



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        containerContext = container.getContext();

        levelTextView = binding.levelTextView;
        scoreTextView = binding.scoreTextView;
        restartButton = binding.restartButton;
        addScoreButton = binding.upScoreButton;

        // ici on ajoute les ecouteurs d'evenements aux bouttons
        addScoreButton.setOnClickListener(this::addScore);
        restartButton.setOnClickListener(this::restartGame);
        launchesTextView = binding.launchesTextView;
        launchesTextView.setText(String.format("%d",launchesCounter));


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void restartGame(View view) {
        clearLevelAndScore();
        Log.println(Log.WARN, "click-event", "restarted");
        scoreTextView.setText(String.format("%d", score));
        levelTextView.setText(String.format("%d", level));
    }


    public void addScore(View view) {
        incrementerScore();
        Log.println(Log.WARN, "click-event", "score added");
        scoreTextView.setText(String.format("%d", score));
        levelTextView.setText(String.format("%d", level));
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == NUMBER_OF_REQUEST_LAUNCHES && resultCode == -1){
            String finishMsg = data.getStringExtra("backMsg");
            int launches = data.getIntExtra("launches" , 1);
            launchesTextView.setText(String.format("%d",launches));
            launchesCounter = launches;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}