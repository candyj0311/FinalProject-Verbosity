package candacelizelle.finalproject_candacejlizelles;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CategoriesPage extends AppCompatActivity {
    private List<Category> categories;
    private CategoriesAdapter categoriesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories_page);

        initialData();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        categoriesAdapter = new CategoriesAdapter(categories, this);
        recyclerView.setAdapter(categoriesAdapter);
    }

    private void initialData() {
        categories = new ArrayList<>();
        categories.add(new Category("Fruit", R.drawable.grapes));
        categories.add(new Category("Animals", R.drawable.bear));
        categories.add(new Category("Colors", R.drawable.purple));
    }
}
