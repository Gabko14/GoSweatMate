package ch.bbcag.gosweatmate.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import ch.bbcag.gosweatmate.R;
import ch.bbcag.gosweatmate.helper.ExerciseModelStorage;
import ch.bbcag.gosweatmate.helper.SelectListener;

public class CreatePlanExercisesAdapter extends RecyclerView.Adapter<CreatePlanExercisesAdapter.ViewHolder> {
    private final List<ExerciseModelStorage> exerciseModel;
    private Context context;

    public CreatePlanExercisesAdapter(Context context, List<ExerciseModelStorage> exerciseModel) {
        this.exerciseModel = exerciseModel;
        this.context = context;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtHeader;
        public ImageView exerciseImage;
        public RelativeLayout relativeLayout;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            exerciseImage = (ImageView) v.findViewById(R.id.icon);
            relativeLayout = (RelativeLayout) v.findViewById(R.id.main_container);

        }
    }

    public void add(int position, ExerciseModelStorage item) {
        exerciseModel.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        exerciseModel.remove(position);
        notifyItemRemoved(position);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.row_layout_create_plan_exercises, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        final ExerciseModelStorage currentModel = exerciseModel.get(position);
        holder.txtHeader.setText(currentModel.getName());

        //This puts image urls into imageViews
        if (currentModel.getImageLink() != "" && currentModel.getImageLink() != null) {
            Picasso.get().load(currentModel.getImageLink()).into(holder.exerciseImage);
        }
    }

    @Override
    public int getItemCount() {
        return exerciseModel.size();
    }

}

