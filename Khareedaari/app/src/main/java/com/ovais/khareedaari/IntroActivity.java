package com.ovais.khareedaari;

import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;
import com.github.paolorotolo.appintro.model.SliderPage;

public class IntroActivity extends AppIntro {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SliderPage welcomeScreen = new SliderPage();
        welcomeScreen.setTitle(getResources().getString(R.string.Welcome));
        welcomeScreen.setDescription(getResources().getString(R.string.Welcome_Description));
        welcomeScreen.setImageDrawable(R.drawable.welcome);
        welcomeScreen.setBgColor(getResources().getColor(R.color.backgoundColor));
        addSlide(AppIntroFragment.newInstance(welcomeScreen));

        SliderPage shirtScreen = new SliderPage();
        shirtScreen.setTitle(getResources().getString(R.string.intro_heading01));
        shirtScreen.setDescription(getResources().getString(R.string.intro_description01));
        shirtScreen.setImageDrawable(R.drawable.shirt);
        shirtScreen.setBgColor(getResources().getColor(R.color.backgoundColor));
        addSlide(AppIntroFragment.newInstance(shirtScreen));

        SliderPage walletScreen = new SliderPage();
        walletScreen.setTitle(getResources().getString(R.string.intro_heading04));
        walletScreen.setDescription(getResources().getString(R.string.intro_description04));
        walletScreen.setImageDrawable(R.drawable.wallet);
        walletScreen.setBgColor(getResources().getColor(R.color.backgoundColor));
        addSlide(AppIntroFragment.newInstance(walletScreen));

        SliderPage beltScreen = new SliderPage();
        beltScreen.setTitle(getResources().getString(R.string.intro_heading03));
        beltScreen.setDescription(getResources().getString(R.string.intro_description03));
        beltScreen.setImageDrawable(R.drawable.belt);
        beltScreen.setBgColor(getResources().getColor(R.color.backgoundColor));
        addSlide(AppIntroFragment.newInstance(beltScreen));

        SliderPage shoesScreen = new SliderPage();
        shoesScreen.setTitle(getResources().getString(R.string.intro_heading02));
        shoesScreen.setDescription(getResources().getString(R.string.intro_description02));
        shoesScreen.setImageDrawable(R.drawable.sneaker);
        shoesScreen.setBgColor(getResources().getColor(R.color.backgoundColor));
        addSlide(AppIntroFragment.newInstance(shoesScreen));

    }


    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        Intent intent=new Intent(getApplicationContext(), RegisterActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        Intent intent=new Intent(getApplicationContext(), RegisterActivity.class);
        startActivity(intent);
        finish();
    }



}
