package candacelizelle.finalproject_candacejlizelles;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CategoryViewHolder extends RecyclerView.ViewHolder {
    private CardView cardView;
    private TextView categoryNameView;
    private ImageView categoryImageView;
    private Context context;

    public CategoryViewHolder(View itemView, final Context context) {
        super(itemView);
        cardView = (CardView) itemView.findViewById(R.id.category_card_view);
        categoryNameView = (TextView) itemView.findViewById(R.id.category_name);
        categoryImageView = (ImageView) itemView.findViewById(R.id.category_image);
        this.context = context;
    }

    public void bind(final Category category) {
        categoryNameView.setText(category.categoryName);
        categoryImageView.setImageResource(category.photoId);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CategoriesPage.class);
                intent.putExtra(BundleKey.NAME_KEY, category.categoryName);
                intent.putExtra(BundleKey.PHOTO_KEY, category.photoId);

                context.startActivity(intent);
            }
        });
    }

}
