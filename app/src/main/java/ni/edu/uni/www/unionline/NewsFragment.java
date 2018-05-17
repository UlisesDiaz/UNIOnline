package ni.edu.uni.www.unionline;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class NewsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
// Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        RecyclerView rvNews;
        //Inicializar RecilcerView
        rvNews = (RecyclerView) view.findViewById(R.id.rvNews);

        ArrayList<ModelNews> listNews=new ArrayList<>();

        listNews.add(new ModelNews(R.mipmap.news1, "Muere la mancucha", "Muere a causa de un apreton de piernas de la caballeta Muere a causa de un apreton de piernas de la caballeta","17/05/2018"));
        listNews.add(new ModelNews(R.mipmap.news2, "La mancucha se encuentra con vida", "Muere a causa de un apreton de piernas de la caballetaMuere a causa de un apreton de piernas de la caballeta","17/05/2018"));
        listNews.add(new ModelNews(R.mipmap.headerimage, "Muere la mancucha", "Muere a causa de un apreton de piernas de la caballetaMuere a causa de un apreton de piernas de la caballeta","17/05/2018"));
        listNews.add(new ModelNews(R.mipmap.news1, "Muere la mancucha", "Muere a causa de un apreton de piernas de la caballetaMuere a causa de un apreton de piernas de la caballeta","17/05/2018"));
        listNews.add(new ModelNews(R.mipmap.news1, "Muere la mancucha", "Muere a causa de un apreton de piernas de la caballeta","17/05/2018"));
        listNews.add(new ModelNews(R.mipmap.news1, "Muere la mancucha", "Muere a causa de un apreton de piernas de la caballeta","17/05/2018"));
        listNews.add(new ModelNews(R.mipmap.news2, "Muere la mancucha", "Muere a causa de un apreton de piernas de la caballeta","17/05/2018"));
        listNews.add(new ModelNews(R.mipmap.news1, "Muere la mancucha", "Muere a causa de un apreton de piernas de la caballeta","17/05/2018"));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        RecyclerView.LayoutManager rvLayoutManager = linearLayoutManager;
        rvNews.setLayoutManager(rvLayoutManager);

        NewsAdapter  newsAdapter = new NewsAdapter(getContext(), listNews);

        rvNews.setAdapter(newsAdapter);

        return view;
    }

}
