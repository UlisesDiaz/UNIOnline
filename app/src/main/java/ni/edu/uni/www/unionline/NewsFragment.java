package ni.edu.uni.www.unionline;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class NewsFragment extends Fragment {
    static boolean calledAlready = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
// Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_news, container, false);

        if (!calledAlready) {
            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
            calledAlready = true;
        } else {
        }
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference().child("news");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

              try {
                  final RecyclerView rvNews;
                  //Inicializar RecilcerView
                  rvNews = (RecyclerView) view.findViewById(R.id.rvNews);
                  final ArrayList<ModelNews> listNews = new ArrayList<>();

                  for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                      ModelNews news = snapshot.getValue(ModelNews.class);
                      //writeNews(news.getImage(),news.getNewsTitle(), news.getNewsDetails(), news.getNewsCreateDate());
                      listNews.add(new ModelNews(news.getImage(), news.getNewsTitle(), news.getNewsDetails(), news.getNewsCreateDate()));
                  }
                  LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                  RecyclerView.LayoutManager rvLayoutManager = linearLayoutManager;
                  rvNews.setLayoutManager(rvLayoutManager);

                  NewsAdapter newsAdapter = new NewsAdapter(getContext(), listNews);

                  rvNews.setAdapter(newsAdapter);
              }catch (Exception e)
              {
                  Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
              }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getContext(), "Ha ocurrido un error (" + databaseError.getMessage() + ")", Toast.LENGTH_SHORT).show();

            }
        });

        return view;
    }

    private void writeNews(String image, String newsTitle, String newsDetails, String newsCreateDate) {
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        try {
            ModelNews news = new ModelNews(image, newsTitle, newsDetails, newsCreateDate);

            myRef.child("news").child(newsTitle).setValue(news);
        } catch (Exception e) {
            Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT);
        }
    }
}
