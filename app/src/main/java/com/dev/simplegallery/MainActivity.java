package com.dev.simplegallery;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.dev.simplegallery.dummy.DummyContent;

public class MainActivity extends AppCompatActivity
        implements GalleryFragment.OnGalleryFragmentInteractionListener,
        ProductFragment.OnProductFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnRevealProductsClicked(View view) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        GalleryFragment gf = GalleryFragment.newInstance();
        ft.add(R.id.frameContainer, gf).addToBackStack(null).commit();

        Button btnRevealProducts = (Button) findViewById(R.id.btnRevealProducts);
        btnRevealProducts.setVisibility(View.GONE);
        FrameLayout frameContainer = (FrameLayout) findViewById(R.id.frameContainer);
        frameContainer.setVisibility(View.VISIBLE);
    }

    @Override
    public void onProductClicked(DummyContent.ProductItem item) {
        FragmentManager fm = getSupportFragmentManager();
        GalleryFragment gf = (GalleryFragment) fm.findFragmentById(R.id.frameContainer);

        if (gf == null) {
            throw new IllegalStateException();
        }

        FragmentTransaction ft = fm.beginTransaction();
        ft.remove(gf);

        ProductFragment pf = ProductFragment.newInstance(item);
        ft.add(R.id.frameContainer, pf).addToBackStack(null).commit();
    }

    @Override
    public void onProductFragmentHidden() {
        FragmentManager fm = getSupportFragmentManager();
        ProductFragment pf = (ProductFragment) fm.findFragmentById(R.id.frameContainer);

        if (pf == null) {
            throw new IllegalStateException();
        }

        FragmentTransaction ft = fm.beginTransaction();
        ft.remove(pf).commit();

        Button btnRevealProducts = (Button) findViewById(R.id.btnRevealProducts);
        btnRevealProducts.setVisibility(View.VISIBLE);
    }
}
