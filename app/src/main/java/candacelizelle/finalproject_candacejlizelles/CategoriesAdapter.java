package candacelizelle.finalproject_candacejlizelles;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoryViewHolder> {
    private List<Category> categories;
    private Context context;

    public CategoriesAdapter(List<Category> categories, Context context) {
        this.categories = categories;
        this.context = context;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_category, parent, false);
        return new CategoryViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        Category category = categories.get(position);
        holder.bind(category);
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }
}
