package ni.edu.uni.www.unionline;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by ulises diaz on 17/05/2018.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> implements View.OnClickListener {

    private Context mContext;
    ArrayList<ModelNews> mListNews;

    NewsAdapter(Context context, ArrayList<ModelNews> ListNews) {
        mContext = context;
        mListNews = ListNews;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.rv_news_items, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        try {
            ModelNews modelNews = mListNews.get(position);
            ImageView iv_NewsImage = holder.iv_NewsImage;

            TextView tv_NewsTitle = holder.tv_NewsTitle;
            TextView tv_NewsDetails = holder.tv_NewsDetails;
            TextView tv_NewsCreateDate = holder.tv_NewsCreateDate;

            String base = modelNews.getImage();

            final String pureBase64Encoded = base.substring(base.indexOf(",")  + 1);

            byte[] imageAsBytes = Base64.decode(pureBase64Encoded, Base64.DEFAULT);

            iv_NewsImage.setImageBitmap(BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length));
            tv_NewsTitle.setText(modelNews.getNewsTitle());
            tv_NewsDetails.setText(modelNews.getNewsDetails());
            tv_NewsCreateDate.setText(modelNews.getNewsCreateDate());
        } catch (Exception e) {
            Toast.makeText(this.mContext, e.getMessage(), Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public int getItemCount() {
        return mListNews.size();
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this.mContext, "Click", Toast.LENGTH_SHORT).show();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_NewsImage;
        TextView tv_NewsTitle;
        TextView tv_NewsDetails;
        TextView tv_NewsCreateDate;

        public ViewHolder(View itemView) {
            super(itemView);

            iv_NewsImage = itemView.findViewById(R.id.iv_newsImage);
            tv_NewsTitle = itemView.findViewById(R.id.tv_NewsTitle);
            tv_NewsDetails = itemView.findViewById(R.id.tv_NewsDetails);
            tv_NewsCreateDate = itemView.findViewById(R.id.tv_NewsCreateDate);

        }
    }

}
