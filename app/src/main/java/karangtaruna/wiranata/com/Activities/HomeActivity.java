package karangtaruna.wiranata.com.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationAdapter;

import karangtaruna.wiranata.com.Fragments.Galeri;
import karangtaruna.wiranata.com.Fragments.Kegiatan;
import karangtaruna.wiranata.com.Fragments.Kontak;
import karangtaruna.wiranata.com.Fragments.Pengurus;
import karangtaruna.wiranata.com.Fragments.Profil;
import karangtaruna.wiranata.com.R;

public class HomeActivity extends AppCompatActivity {

    private AHBottomNavigation bottomNavigation;
    private AHBottomNavigationAdapter navigationAdapter;

    private int selectedMenu = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigation= (AHBottomNavigation) findViewById(R.id.bottom_navigation);

        createBottomMenu();
    }

    private void createBottomMenu() {
        bottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);
        bottomNavigation.setTitleTextSize(getResources().getDimension(R.dimen.text_size_12),getResources().getDimension(R.dimen.text_size_10));
        navigationAdapter = new AHBottomNavigationAdapter(HomeActivity.this,R.menu.bottom_menu);
        navigationAdapter.setupWithBottomNavigation(bottomNavigation, getResources().getIntArray(R.array.menu_color));
        bottomNavigation.setAccentColor(getResources().getColor(R.color.menu_active));
        bottomNavigation.setInactiveColor(getResources().getColor(R.color.menu_nonactive));
        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                switch (position) {
                    case 0:
                        // Profil
                        Profil profilFragment = new Profil();
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.main_fragment, profilFragment)
                                .commit();
                        break;
                    case 1:
                        // Pengurus
                        Pengurus pengurusFragment = new Pengurus();
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.main_fragment, pengurusFragment)
                                .commit();
                        break;
                    case 2:
                        // Kegiatan
                        Kegiatan kegiatanFragment = new Kegiatan();
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.main_fragment, kegiatanFragment)
                                .commit();
                        break;
                    case 3:
                        //Galeri
                        Galeri galeriFragment = new Galeri();
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.main_fragment, galeriFragment)
                                .commit();
                        break;
                    case 4:
                        //Kontak
                        Kontak kontakFragment = new Kontak();
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.main_fragment, kontakFragment)
                                .commit();
                        break;
                }
                return true;
            }
        });
        bottomNavigation.setCurrentItem(0);
//        showFragment();
    }
}
